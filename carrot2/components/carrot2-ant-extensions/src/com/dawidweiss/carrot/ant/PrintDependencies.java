
package com.dawidweiss.carrot.ant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.util.FileUtils;

import com.dawidweiss.carrot.ant.deps.ComponentDependency;
import com.dawidweiss.carrot.ant.deps.ComponentDependencyUtils;
import com.dawidweiss.carrot.ant.deps.ComponentInProfile;


/**
 * An ANT task that prints all the
 * dependencies of a given component. 
 */
public class PrintDependencies extends Task {

    /**
     * A file to which the results will be saved or null.
     */
    private File outputFile;

    /**
     * Name of a property where the results will be stored or null. 
     */
    private String property;


	/**
     * The component info file of the component
     * for which dependencies are to be retrieved.
     */
    private File componentDescriptor;

    /**
     * A list of <code>FileSet</code> objects
     * that point to component dependency descriptors.
     * This list is used when searching for named
     * dependencies. 
     */
    private LinkedList dependencies = new LinkedList();

    /** Profile for dependency traversal. */
    private String profile;
    
    /**
     * Public empty constructor
     */
    public PrintDependencies() {
    }

    /**
     * Set the profile for dependency traversal.
     * @param profile
     */
    public void setProfile(String profile) {
        if (profile != null && "".equals(profile.trim())) {
            profile = null;
        } else
        	this.profile = profile;
    }

    public void setFile(File file) {
        this.outputFile = file;
    }
    
    /**
     * Sets the name of a property where the result
     * will be stored.
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * Sets a path to the dependency of the component for which dependencies are to be retrieved.
     */
    public void setComponentDescriptor(File dependencyFile) {
        this.componentDescriptor = dependencyFile;
    }

    /**
     * Crates a new path with a set of dependency files to scan.
     */
    public Path createDependencies() {
        Path newPath = new Path(getProject());
        dependencies.add(newPath);
        return newPath;
    }

    /**
     * Checks if all parameters are correct.
     * @throws BuildException
     */
    protected void checkParameters() 
        throws BuildException
    {
        if (getProject() == null) {
            throw new BuildException("Project reference is required.");
        }

        if (this.componentDescriptor == null) {
            throw new BuildException("componentDescriptor attribute is required.");
        }
        
        if (this.outputFile == null && this.property == null)
            throw new BuildException("Either file or property attribute must be specified.");
    }

    /**
     * Searches for components that are not up to date and updates
     * them if possible.
     */
    public void execute() throws BuildException {
        
        checkParameters();
        this.dependencies = Utils.convertPathDependencies(getProject(), dependencies);

        FileUtils futils = FileUtils.newFileUtils();
        try {
            ComponentDependency component = 
                new ComponentDependency(getProject(), this.componentDescriptor);

            // load all dependencies pointed to by embedded filesets.
            HashMap components = new HashMap();
            components.put(component.getName(), component);
            ComponentDependencyUtils.loadComponentDependencies( futils, getProject(), this.dependencies, components);

            ComponentInProfile [] dependencies = component
                .getAllRequiredComponentDependencies(components, profile);
            ComponentInProfile self = new ComponentInProfile(component, profile);

            StringBuffer buf = new StringBuffer();
            buf.append("Component '" + component.getDescription() + "'\n\n");
            buf.append("Dependency profile: " + (profile == null ? "(default)" : "'" + profile + "'") + "\n"); 
            buf.append("Dependencies:\n");

			Arrays.sort(dependencies, new Comparator() {
                public int compare(Object o1, Object o2) {
                	ComponentInProfile d1 = (ComponentInProfile) o1;
                	ComponentInProfile d2 = (ComponentInProfile) o2;
                	return d1.component.getDescription().compareToIgnoreCase(
                            d2.component.getDescription());
                }
			});

            for (int i=0; i<dependencies.length; i++) {
                ComponentInProfile dependency = dependencies[i];
                
                if (dependency.equals(self)) {
                	continue;
                }

                buf.append("   - " + dependency.component.getDescription());
                if (dependency.profile != null) {
                	buf.append(" [in profile: '" + dependency.profile + "']"); 
                }
                buf.append("\n");
            }
            if (dependencies.length - 1 <= 0) {
                buf.append("no dependencies.");
            }

            if (this.outputFile != null) {
                Writer os = 
                    new OutputStreamWriter(new FileOutputStream(outputFile));
                try {
                    os.write(buf.toString());
                } finally {
                    os.close();
                }
            }
            if (this.property != null) {
                getProject().setNewProperty(property, buf.toString());
            }
        } catch (Exception e) {
            throw new BuildException(e);
        }
    }

}
