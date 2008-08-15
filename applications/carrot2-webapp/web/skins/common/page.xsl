<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output indent="no" omit-xml-declaration="yes" method="xml"
       doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
       doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
       media-type="text/html" encoding="utf-8" />

  <xsl:strip-space elements="*"/>

  <xsl:variable name="context-path" select="/page/@context-path" />
  <xsl:variable name="skin-path" select="/page/@skin-path" />
  
  <xsl:variable name="search-url" select="/page/config/@search-url" />
  <xsl:variable name="query-param" select="/page/config/@query-param" />
  <xsl:variable name="source-param" select="/page/config/@source-param" />
  <xsl:variable name="algorithm-param" select="/page/config/@algorithm-param" />
  <xsl:variable name="results-param" select="/page/config/@results-param" />
  <xsl:variable name="view-param" select="/page/config/@view-param" />
  <xsl:variable name="skin-param" select="/page/config/@skin-param" />
  
  <xsl:variable name="request-url" select="/page/@request-url" />
  <xsl:variable name="xml-url-encoded" select="/page/@xml-url-encoded" />
  
  <xsl:variable name="documents-url" select="concat($request-url, '&amp;type=DOCUMENTS')" />
  <xsl:variable name="clusters-url" select="concat($request-url, '&amp;type=CLUSTERS')" />
  
  <xsl:variable name="debug" select="false" />

  <!-- HTML scaffolding -->
  <xsl:template match="/">
    <xsl:choose>
      <xsl:when test="page[@full-html = 'true']">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title><xsl:call-template name="page-title" /></title>
    
    <xsl:apply-templates select="page/asset-urls/css-urls/css-url" />
  </head>

  <body>
    <xsl:attribute name="id"><xsl:call-template name="page-body-id" /></xsl:attribute>
    <xsl:if test="$debug = 'true'">
      <xsl:apply-templates select="/page/request/parameter" />
    </xsl:if>
    
    <!-- Page content -->
    <xsl:apply-templates />
    
    <!-- Custom in-line javascript -->
    <xsl:apply-templates select="/page" mode="js" />
  </body>
</html>
      </xsl:when>
      
      <xsl:otherwise>
        <xsl:apply-templates />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template match="parameter">
    Param: <xsl:value-of select="@name" />, value: <xsl:apply-templates select="value/@value" /><br />
  </xsl:template>
  
  <!-- HTML head title -->
  <xsl:template name="page-title">
    <xsl:if test="string-length(/page/request/@query) > 0">
      <xsl:value-of select="/page/request/@query" />
      -
    </xsl:if>
    Carrot2 Clustering Engine 
  </xsl:template>
  
  <!-- Stylesheets -->
  <xsl:template match="css-url">
    <link rel="stylesheet" href="{.}" type="text/css" />
  </xsl:template>
  
  <!-- JS -->
  <xsl:template match="js-url">
    <script src="{.}" type="text/javascript"><xsl:comment></xsl:comment></script>
  </xsl:template>
  
  <xsl:template match="/page" mode="js" />
  
  <!-- Body tag id -->
  <xsl:template name="page-body-id">
    <xsl:choose>
      <xsl:when test="string-length(/page/request/@query) > 0">results</xsl:when>
      <xsl:otherwise>startup</xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <!-- Error message -->
  <xsl:template match="page[@type = 'ERROR']">
    <div class="processing-error">
    Our apologies, the following processing error has occurred: 
    <span class="message"><xsl:value-of select="/page/@exception-message" /></span>
    If the error persists, please <a href="http://project.carrot2.org/support.html">contact us</a>.
    </div>
  </xsl:template>

  <!-- Main page contents -->
  <xsl:template match="page[@type = 'PAGE' or @type = 'FULL']">
    <noscript>
      <div class="noscript"><xsl:call-template name="no-javascript-message" /></div>
    </noscript>

    <xsl:if test="/page/request/@modern = 'false'">
      <span id="use-modern">Use a <a href="http://browsehappy.com/">modern browser</a> for best experience!</span>
    </xsl:if>
              
    <div id="logo">
      <h1><a href="{$context-path}/{$search-url}"><span class="hide"><xsl:call-template name="main-title" /></span></a></h1>
    </div>
    
    <p class="hide">
      <xsl:call-template name="main-intro" />
    </p>

    <hr class="hide" />

    <div id="main-area">
      <div id="main-area-top"><xsl:comment></xsl:comment></div>
      <div id="main-area-inside">
        <xsl:apply-templates select="/page" mode="sources" />
        
        <div id="search-area">
          <form action="{$context-path}/{$search-url}">
            <h3 class="hide">Type your query:</h3>

            <div id="required" class="clearfix">
              <input type="hidden" name="{$source-param}" id="source" value="{/page/request/@source}" />
              <input type="hidden" name="{$view-param}" id="view" value="{/page/request/@view}" />
              <input type="hidden" name="{$skin-param}" value="{/page/request/@skin}" />
              
              <xsl:apply-templates select=".." mode="query" />
              <xsl:apply-templates select=".." mode="search" />
              
              <span id="show-options"><a href="#more-options">More options</a></span>
            </div>

            <div id="options" class="hide">
              <xsl:if test="count(/page/config/sizes/size) > 1">
                <label>
                  Download
                  <select name="{$results-param}">
                    <xsl:for-each select="/page/config/sizes/size">
                      <option value="{string(.)}">
                        <xsl:if test="string(.) = /page/request/@results">
                          <xsl:attribute name="selected">selected</xsl:attribute>
                        </xsl:if>
                        <xsl:value-of select="." /> results
                      </option>
                    </xsl:for-each>
                  </select>
                </label>
              </xsl:if>
                          
              <xsl:if test="count(/page/config/components/algorithms/algorithm) > 1">
                <label>
                  Cluster with
                  <select name="{$algorithm-param}">
                    <xsl:for-each select="/page/config/components/algorithms/algorithm">
                      <option value="{@id}">
                        <xsl:if test="@id = /page/request/@algorithm">
                          <xsl:attribute name="selected">selected</xsl:attribute>
                        </xsl:if>
                        <xsl:value-of select="label" />
                      </option>
                    </xsl:for-each>
                  </select>
                </label>
              </xsl:if>
            </div>
          </form>
        </div>

        <xsl:if test="string-length(/page/request/@query) > 0">
          <xsl:apply-templates select="/page" mode="results" />
        </xsl:if>
      </div>
      <div id="main-area-bottom"><xsl:comment></xsl:comment></div>
    </div>

    <hr class="hide" />

    <div id="util-links">
      <h3 class="hide">About Carrot<sup>2</sup>:</h3>
      <ul class="util-links">
        <li><a href="#">About</a><xsl:call-template name="pipe" /></li>
        <li class="hot"><a href="#">New features!</a><xsl:call-template name="pipe" /></li>
        <li class="main"><a href="#">Beta</a><xsl:call-template name="pipe" /></li>
        <li><a href="#">More demos</a><xsl:call-template name="pipe" /></li>
        <li><a href="#">Plugins</a><xsl:call-template name="pipe" /></li>
        <li><a href="#">Download</a><xsl:call-template name="pipe" /></li>
        <li><a href="#">FAQ</a><xsl:call-template name="pipe" /></li>
        <li class="main"><a href="#">Carrot Search</a><xsl:call-template name="pipe" /></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </div>

    <div id="loading">Loading...</div>
    
    <xsl:if test="string-length(/page/request/@query) > 0">
      <div id="template-document" class="hide">
        <xsl:apply-templates select="document('template-document.xml')" />
      </div>
    </xsl:if>
  </xsl:template>

  <xsl:template name="pipe"><span class='pipe'> | </span></xsl:template>

  <xsl:template match="page" mode="sources">
    <div id="source-tabs">
      <xsl:variable name="is-first-source-active"><xsl:apply-templates select=".." mode="is-first-source-active" /></xsl:variable>
      <xsl:if test="$is-first-source-active = 'yes'">
        <xsl:attribute name="class">first-active</xsl:attribute>
      </xsl:if>

      <h3 class="hide">Choose where to search:</h3>
      
      <span id="tab-lead-in"><xsl:comment></xsl:comment></span>
      <ul class="tabs clearfix">
        <xsl:apply-templates select="." mode="sources-internal" />
      </ul>
    </div>
  </xsl:template>

  <xsl:template match="page" mode="sources-internal">
    <xsl:apply-templates select="config/components/sources/source" />
  </xsl:template>

  <xsl:template match="page" mode="is-first-source-active">
    <xsl:apply-templates select=".." mode="is-first-source-active-internal" />
  </xsl:template>

  <xsl:template match="page" mode="is-first-source-active-internal">
    <xsl:if test="/page/config/components/sources/source[1]/@id = /page/request/@source">yes</xsl:if>
  </xsl:template>

  <xsl:template match="page" mode="query">
    <xsl:apply-templates select=".." mode="query.field" />
  </xsl:template>

  <xsl:template match="page" mode="query.field">
    <input type="text" name="{$query-param}" id="query" value="{/page/request/@query}" />
  </xsl:template>

  <xsl:template match="page" mode="search">
    <xsl:apply-templates select=".." mode="search.field" />
  </xsl:template>

  <xsl:template match="page" mode="search.field">
    <button type="submit" id="search">Search</button>
  </xsl:template>

  <xsl:template match="source">
    <xsl:variable name="source-position" select="position()" />
    
    <xsl:call-template name="source">
      <xsl:with-param name="source-id" select="@id" />
      <xsl:with-param name="is-last" select="position() = count(/page/config/components/sources/source)" />
      <xsl:with-param name="is-active" select="@id = /page/request/@source" />
      <xsl:with-param name="is-before-active" select="/page/request/@source = /page/config/components/sources/source[$source-position + 1]/@id" />
    </xsl:call-template>
  </xsl:template>

  <xsl:template name="source">
    <xsl:param name="source-id" />
    <xsl:param name="is-last" />
    <xsl:param name="is-active" />
    <xsl:param name="is-before-active" />
    
    <xsl:variable name="source" select="/page/config/components/sources/source[@id = $source-id]" />
    
    <li id="{$source/@id}">
      <xsl:attribute name="class">tab <xsl:choose>
          <xsl:when test="$is-active">active <xsl:choose>
              <xsl:when test="$is-last">active-last</xsl:when>
            </xsl:choose>
          </xsl:when>
          <xsl:otherwise>
            <xsl:choose>
              <xsl:when test="$is-last">passive-last</xsl:when>
            </xsl:choose>
          </xsl:otherwise>
        </xsl:choose>
      
        <xsl:if test="$is-before-active">before-active</xsl:if>
      </xsl:attribute>

      <a class="label {$source/@id}" href="#" title="{$source/title}"><xsl:apply-templates select="$source/label" /></a>
      <span class="hide">
        <span class="tab-info"><xsl:value-of select="$source/description" /></span><br />
        <span class="example-queries">Example queries: 
          <xsl:apply-templates select="$source/example-queries/example-query" />
        </span>
      </span>
      <span class="right"><xsl:comment></xsl:comment></span>
    </li>
  </xsl:template>

  <xsl:template match="source/example-queries/example-query">
    <a href="{$context-path}/{$search-url}?{concat($source-param, '=', string(../../@id), '&amp;', $query-param, '=', string(.))}"><xsl:apply-templates /></a>
  </xsl:template>

  <xsl:template name="no-javascript-message">
    To use Carrot<sup>2</sup>, please enable 
    JavaScript in your browser.
  </xsl:template>

  <xsl:template name="main-title">
    Carrot2 Search Results Clustering Engine
  </xsl:template>

  <xsl:template name="main-intro">
    Carrot2 is an Open Source Search Results Clustering Engine. It can
    automatically organize (cluster) search results into thematic
    categories.
  </xsl:template>
  
  <!-- Documents -->
  <xsl:template match="page[@type = 'DOCUMENTS']">
    <div id="documents">
      <xsl:choose>
        <xsl:when test="count(searchresult/document) > 0">
          <xsl:apply-templates select="searchresult/document" />
        
          <script>
            var fetchedDocumentsCount = <xsl:value-of select="count(searchresult/document)" />;
            var totalDocumentsCount = "<xsl:value-of select="searchresult/attribute[@key = 'results-total']/value/@value" />";
            var sourceTime = "<xsl:value-of select="searchresult/attribute[@key = 'processing-time-source']/value/@value" />";
          </script>
        </xsl:when>
        
        <xsl:otherwise>
          <div id="no-documents">Your query returned no documents. <br />Please try a more general query.</div>
        </xsl:otherwise>
      </xsl:choose>    
    </div>
  </xsl:template>

  <xsl:template match="document">
    <div id="d{@id}" class="document">
      <div class="title">
        <h3>
          <span class="rank"><xsl:value-of select="number(@id) + 1" /></span>
          <span class="title-in-clusters">
            <a href="{url}" class="title"><xsl:value-of disable-output-escaping="yes" select="title" /></a>
            <a href="#" class="in-clusters" title="Show in clusters">&#160;<small>Show in clusters</small></a>
          </span>
          <a href="{url}" target="_blank" class="in-new-window" title="Open in new window">&#160;<small>Open in new window</small></a>
          <a href="#" class="show-preview" title="Show preview">&#160;<small>Show preview</small></a>
        </h3>
      </div>
      <xsl:if test="field[@key = 'thumbnail-url']">
        <img class="thumbnail" src="{field[@key = 'thumbnail-url']/value/@value}" />
      </xsl:if>
      <xsl:if test="string-length(snippet) &gt; 0">
        <div class="snippet"><xsl:value-of disable-output-escaping="yes" select="snippet" /></div>
      </xsl:if>
      <div class="url">
        <xsl:apply-templates select="url" />
        <xsl:if test="count(sources/source) > 0">
          <span class="sources"> [<xsl:apply-templates select="sources/source" />]</span>
        </xsl:if>
      </div>
      <div style="clear: both"><xsl:comment></xsl:comment></div>
    </div>
  </xsl:template>
  
  <xsl:template match="document/sources/source[position() = last()]">
    <xsl:apply-templates />
  </xsl:template>
  
  <xsl:template match="document/sources/source[position() != last()]">
    <xsl:apply-templates />,
  </xsl:template>
  
  <!-- Clusters -->
  <xsl:template match="page[@type = 'CLUSTERS']">
    <div id="clusters">
      <xsl:choose>
        <xsl:when test="count(searchresult/group) > 0">
          <a id="tree-top" href="#"><span class="label">All Topics</span><span class="size">(<xsl:value-of select="count(searchresult/document)" />)</span></a>
          <ul>
            <xsl:apply-templates select="searchresult/group" />
          </ul>
      
          <script>
            var documentCount = <xsl:value-of select="count(searchresult/document)" />;
            var documents = {
              <xsl:apply-templates select="searchresult/group" mode="json" />
            };
            var algorithmTime = "<xsl:value-of select="searchresult/attribute[@key = 'processing-time-algorithm']/value/@value" />";
          </script>
        </xsl:when>
        
        <xsl:otherwise>
          <div id="no-clusters">No clusters found</div>
        </xsl:otherwise>
      </xsl:choose>
    </div>
  </xsl:template>

  <xsl:template match="group">
    <li class="folded" id="{generate-id(.)}">
      <a href="#"><span class="label"><xsl:apply-templates select="title" /></span><span class="size">(<xsl:value-of select="@size" />)</span></a>
      <xsl:if test="group">
        <ul>
          <xsl:apply-templates select="group" />
        </ul>
      </xsl:if>
    </li>
  </xsl:template>

  <xsl:template match="group/title">
    <xsl:choose>
      <xsl:when test="../attribute[@key = 'other-topics']">
        Other topics
      </xsl:when>
      <xsl:otherwise>
        <xsl:apply-templates select="phrase[1]" />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template match="group" mode="json">
    '<xsl:value-of select="generate-id(.)" />': {
      <xsl:if test="document">
        d: [<xsl:apply-templates mode="json" select="document" />]<xsl:if test="group">,</xsl:if>
      </xsl:if>
      <xsl:if test="group">
        c: { 
          <xsl:apply-templates select="group" mode="json" /> 
        }
      </xsl:if>
    }<xsl:if test="not(position() = last())">,</xsl:if>
  </xsl:template>

  <xsl:template match="group/document" mode="json">
    <xsl:value-of select="@refid" /><xsl:if test="not(position() = last())">,</xsl:if>
  </xsl:template>
  
  <!-- Replaces one parameter in the provided url -->
  <xsl:template name="replace-in-url">
    <xsl:param name="url" />
    <xsl:param name="param" />
    <xsl:param name="value" />
    
    <xsl:variable name="left"><xsl:value-of select="substring-before($url, concat($param, '='))" /></xsl:variable>
    <xsl:variable name="after-param"><xsl:value-of select="substring-after($url, concat($param, '='))" /></xsl:variable>
    <xsl:variable name="right"><xsl:value-of select="substring-after(substring($after-param, 1), '&amp;')" /></xsl:variable>
    
    <xsl:value-of select="concat($left, $param, '=', $value)" /><xsl:if test="string-length($right) > 0">
      <xsl:value-of select="concat('&amp;', $right)" />
    </xsl:if>
  </xsl:template>
</xsl:stylesheet>
