/* The following code was generated by JFlex 1.4.3 on 14.03.10 15:31 */

package org.carrot2.text.analysis;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 14.03.10 15:31 from the specification file
 * <tt>E:/repositories/sourceforge.net/carrot2-3.0/core/carrot2-util-text/src/org/carrot2/text/analysis/ExtendedWhitespaceTokenizerImpl.jflex</tt>
 */
final class ExtendedWhitespaceTokenizerImpl {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\0\1\24\1\0\1\0\1\23\22\0\1\0\1\46\1\0"+
    "\1\47\1\0\1\40\1\37\1\30\4\0\1\43\1\32\1\33\1\42"+
    "\12\26\1\35\1\34\1\0\1\40\1\0\1\41\1\36\32\50\4\0"+
    "\1\31\1\30\1\21\1\14\1\16\1\12\1\11\1\5\1\7\1\45"+
    "\1\2\2\50\1\3\1\1\1\4\1\6\1\22\1\50\1\17\1\44"+
    "\1\20\1\13\1\10\3\50\1\15\105\0\27\25\1\0\37\25\1\0"+
    "\u0568\25\12\27\206\25\12\27\u026c\25\12\27\166\25\12\27\166\25\12\27"+
    "\166\25\12\27\166\25\12\27\167\25\11\27\166\25\12\27\166\25\12\27"+
    "\166\25\12\27\340\25\12\27\166\25\12\27\u0166\25\12\27\u0fb6\25\u1040\0"+
    "\u0150\25\u0170\0\200\25\200\0\u092e\25\u10d2\0\u5200\25\u0c00\0\u2ba4\25\u215c\0"+
    "\u0200\25\u0500\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\3\2\1\1\2\3\1\4\1\5\1\1"+
    "\3\2\1\0\2\6\1\2\2\0\2\2\1\3\1\6"+
    "\2\0\1\6\1\2\1\0\1\2\1\0\2\2\1\7"+
    "\12\6\1\10\1\11\2\2\1\3\12\6\5\3\2\2"+
    "\1\0\1\2\1\0\2\12\1\11\10\12\2\0\1\3"+
    "\1\11\2\2\1\7\1\6\3\13\2\6\1\0\1\6"+
    "\2\13\2\2\12\6\1\10\1\0\2\3\5\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\173\0\244\0\315\0\366\0\u011f"+
    "\0\51\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e"+
    "\0\u0267\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386"+
    "\0\u03af\0\u03d8\0\u0401\0\u042a\0\u0453\0\u047c\0\u04a5\0\u04ce"+
    "\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b\0\u05c4\0\u05ed\0\u0616"+
    "\0\u063f\0\u0668\0\u0691\0\u06ba\0\u06e3\0\u070c\0\u0215\0\u0735"+
    "\0\u075e\0\u0787\0\u07b0\0\u07d9\0\u0802\0\u082b\0\u0854\0\u087d"+
    "\0\u08a6\0\u08cf\0\u08f8\0\u0921\0\u094a\0\u0973\0\u099c\0\u09c5"+
    "\0\u09ee\0\u0a17\0\u0a40\0\u0a69\0\u0a92\0\u0abb\0\u0ae4\0\u0290"+
    "\0\u0b0d\0\u0b36\0\u0b5f\0\u0b88\0\u0bb1\0\u0bda\0\u0c03\0\u0c2c"+
    "\0\u0c55\0\u0c7e\0\u0ca7\0\u042a\0\u0cd0\0\u0cf9\0\u0d22\0\u0abb"+
    "\0\u0d4b\0\u0d74\0\u0d9d\0\u0dc6\0\u0def\0\u0e18\0\u0e41\0\u0e6a"+
    "\0\u0e93\0\u0ebc\0\u0ee5\0\u0f0e\0\u0f37\0\u0f60\0\u0f89\0\u0fb2"+
    "\0\u0fdb\0\u1004\0\u102d\0\u1056\0\u107f\0\u10a8\0\u10d1\0\u10fa"+
    "\0\u1123\0\u114c\0\u1175\0\u119e\0\u11c7\0\u11f0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\3\4\1\5\15\4\1\6\1\2\1\4"+
    "\1\7\1\10\1\11\1\2\1\11\2\12\1\11\1\2"+
    "\1\13\1\2\1\12\1\2\1\11\1\4\1\14\1\12"+
    "\1\2\1\4\52\0\20\15\1\16\1\15\2\0\3\15"+
    "\1\17\1\20\1\21\1\22\2\0\1\23\1\24\4\0"+
    "\1\25\1\15\2\0\1\15\1\0\22\15\2\0\3\15"+
    "\1\17\1\20\1\21\1\22\2\0\1\23\1\24\4\0"+
    "\1\25\1\15\2\0\1\15\1\0\17\15\1\26\2\15"+
    "\2\0\3\15\1\17\1\20\1\21\1\22\2\0\1\23"+
    "\1\24\4\0\1\25\1\15\2\0\1\15\24\0\1\2"+
    "\25\0\22\15\2\0\1\15\1\7\1\27\1\0\1\20"+
    "\1\30\1\31\1\0\1\32\1\23\3\0\2\32\2\15"+
    "\2\0\1\15\1\0\22\15\2\0\1\15\2\27\1\17"+
    "\1\20\1\33\1\34\1\0\1\32\1\23\1\24\2\0"+
    "\2\32\1\25\1\15\2\0\1\15\33\0\2\12\4\0"+
    "\1\12\4\0\1\12\3\0\22\35\3\0\1\35\15\0"+
    "\2\35\1\0\2\35\1\0\17\15\1\36\2\15\2\0"+
    "\3\15\1\17\1\20\1\21\1\22\2\0\1\23\1\24"+
    "\4\0\1\25\1\15\2\0\1\15\1\0\22\15\2\0"+
    "\3\15\1\17\1\20\1\21\1\37\2\0\1\23\1\24"+
    "\4\0\1\25\1\15\2\0\1\15\1\0\1\15\1\40"+
    "\20\15\2\0\3\15\1\17\1\20\1\21\1\37\2\0"+
    "\1\23\1\24\4\0\1\25\1\15\2\0\1\15\1\0"+
    "\22\41\2\0\1\41\1\0\1\41\14\0\2\41\2\0"+
    "\1\41\1\0\22\20\2\0\3\20\1\0\2\20\1\37"+
    "\2\0\1\23\5\0\2\20\2\0\1\20\1\0\22\42"+
    "\2\0\1\42\1\21\1\42\1\0\2\20\1\37\2\0"+
    "\1\23\5\0\2\42\2\0\1\42\1\0\1\43\1\44"+
    "\1\45\1\46\1\45\1\47\1\50\1\45\1\51\2\45"+
    "\1\52\1\45\1\53\2\45\1\54\1\45\2\0\1\45"+
    "\1\20\1\45\14\0\2\45\2\0\1\45\1\0\22\55"+
    "\2\0\3\55\14\0\2\55\2\0\1\55\1\0\22\56"+
    "\2\0\1\56\1\24\1\56\14\0\2\56\2\0\1\56"+
    "\1\0\22\15\2\0\3\15\1\57\1\20\1\21\1\37"+
    "\2\0\1\23\1\24\4\0\1\25\1\15\2\0\1\15"+
    "\1\0\21\15\1\60\2\0\3\15\1\17\1\20\1\21"+
    "\1\37\2\0\1\23\1\24\4\0\1\25\1\15\2\0"+
    "\1\15\1\0\22\15\2\0\1\15\2\27\1\17\1\20"+
    "\1\33\1\31\1\0\1\32\1\23\1\24\2\0\2\32"+
    "\1\25\1\15\2\0\1\15\1\0\22\20\2\0\1\20"+
    "\2\61\1\0\2\20\1\37\2\0\1\23\5\0\2\20"+
    "\2\0\1\20\1\0\1\62\1\63\1\64\1\65\1\64"+
    "\1\66\1\67\1\64\1\70\2\64\1\71\1\64\1\72"+
    "\2\64\1\73\1\64\2\0\1\64\1\61\1\74\14\0"+
    "\2\64\2\0\1\64\26\0\2\75\22\0\22\42\2\0"+
    "\1\42\1\76\1\77\1\0\2\20\1\37\2\0\1\23"+
    "\5\0\2\42\2\0\1\42\1\0\1\43\1\44\1\45"+
    "\1\46\1\45\1\47\1\50\1\45\1\51\2\45\1\52"+
    "\1\45\1\53\2\45\1\54\1\45\2\0\1\45\1\61"+
    "\1\100\14\0\2\45\2\0\1\45\1\0\22\35\3\0"+
    "\1\35\5\0\1\2\7\0\2\35\1\0\2\35\1\0"+
    "\17\15\1\101\2\15\2\0\3\15\1\17\1\20\1\21"+
    "\1\37\2\0\1\23\1\24\4\0\1\25\1\15\2\0"+
    "\1\15\1\0\1\62\1\63\1\64\1\65\1\64\1\66"+
    "\1\67\1\64\1\70\2\64\1\71\1\64\1\72\2\64"+
    "\1\73\1\64\2\0\1\64\1\20\1\64\14\0\2\64"+
    "\2\0\1\64\1\0\2\15\1\102\17\15\2\0\3\15"+
    "\1\17\1\20\1\21\1\37\2\0\1\23\1\24\4\0"+
    "\1\25\1\15\2\0\1\15\1\0\22\41\2\0\3\41"+
    "\1\17\1\0\1\103\4\0\1\24\4\0\1\104\1\41"+
    "\2\0\1\41\1\0\22\42\2\0\3\42\1\105\1\20"+
    "\1\21\1\37\2\0\1\23\5\0\2\42\2\0\1\42"+
    "\1\0\1\106\1\107\20\106\2\0\1\106\1\20\1\106"+
    "\1\0\2\20\1\110\2\0\1\23\5\0\2\106\2\0"+
    "\1\106\1\0\3\106\1\111\16\106\2\0\1\106\1\20"+
    "\1\106\1\0\2\20\1\110\2\0\1\23\5\0\2\106"+
    "\2\0\1\106\1\0\22\106\2\0\1\106\1\20\1\106"+
    "\1\0\2\20\1\110\2\0\1\23\5\0\2\106\2\0"+
    "\1\106\1\0\10\106\1\112\11\106\2\0\1\106\1\20"+
    "\1\106\1\0\2\20\1\110\2\0\1\23\5\0\2\106"+
    "\2\0\1\106\1\0\16\106\1\113\3\106\2\0\1\106"+
    "\1\20\1\106\1\0\2\20\1\110\2\0\1\23\5\0"+
    "\2\106\2\0\1\106\1\0\5\106\1\114\14\106\2\0"+
    "\1\106\1\20\1\106\1\0\2\20\1\110\2\0\1\23"+
    "\5\0\2\106\2\0\1\106\1\0\11\106\1\115\10\106"+
    "\2\0\1\106\1\20\1\106\1\0\2\20\1\110\2\0"+
    "\1\23\5\0\2\106\2\0\1\106\1\0\1\106\1\116"+
    "\20\106\2\0\1\106\1\20\1\106\1\0\2\20\1\110"+
    "\2\0\1\23\5\0\2\106\2\0\1\106\1\0\5\106"+
    "\1\117\14\106\2\0\1\106\1\20\1\106\1\0\2\20"+
    "\1\110\2\0\1\23\5\0\2\106\2\0\1\106\1\0"+
    "\16\106\1\120\3\106\2\0\1\106\1\20\1\106\1\0"+
    "\2\20\1\110\2\0\1\23\5\0\2\106\2\0\1\106"+
    "\1\0\22\55\2\0\3\55\1\0\2\55\1\23\10\0"+
    "\2\55\2\0\1\55\1\0\22\56\2\0\3\56\1\121"+
    "\6\0\1\24\4\0\2\56\2\0\1\56\1\0\22\15"+
    "\2\0\3\15\1\17\1\20\1\21\1\37\1\0\1\122"+
    "\1\23\1\24\4\0\1\25\1\15\2\0\1\15\1\0"+
    "\22\20\2\0\1\20\2\61\1\0\1\20\1\30\1\31"+
    "\1\0\1\32\1\23\3\0\2\32\2\20\2\0\1\20"+
    "\1\0\1\106\1\107\20\106\2\0\1\106\1\20\1\106"+
    "\1\0\2\20\1\37\2\0\1\23\5\0\2\106\2\0"+
    "\1\106\1\0\3\106\1\111\16\106\2\0\1\106\1\20"+
    "\1\106\1\0\2\20\1\37\2\0\1\23\5\0\2\106"+
    "\2\0\1\106\1\0\22\106\2\0\1\106\1\20\1\106"+
    "\1\0\2\20\1\37\2\0\1\23\5\0\2\106\2\0"+
    "\1\106\1\0\10\106\1\112\11\106\2\0\1\106\1\20"+
    "\1\106\1\0\2\20\1\37\2\0\1\23\5\0\2\106"+
    "\2\0\1\106\1\0\16\106\1\113\3\106\2\0\1\106"+
    "\1\20\1\106\1\0\2\20\1\37\2\0\1\23\5\0"+
    "\2\106\2\0\1\106\1\0\5\106\1\114\14\106\2\0"+
    "\1\106\1\20\1\106\1\0\2\20\1\37\2\0\1\23"+
    "\5\0\2\106\2\0\1\106\1\0\11\106\1\115\10\106"+
    "\2\0\1\106\1\20\1\106\1\0\2\20\1\37\2\0"+
    "\1\23\5\0\2\106\2\0\1\106\1\0\1\106\1\116"+
    "\20\106\2\0\1\106\1\20\1\106\1\0\2\20\1\37"+
    "\2\0\1\23\5\0\2\106\2\0\1\106\1\0\5\106"+
    "\1\117\14\106\2\0\1\106\1\20\1\106\1\0\2\20"+
    "\1\37\2\0\1\23\5\0\2\106\2\0\1\106\1\0"+
    "\16\106\1\120\3\106\2\0\1\106\1\20\1\106\1\0"+
    "\2\20\1\37\2\0\1\23\5\0\2\106\2\0\1\106"+
    "\1\0\22\106\2\0\1\106\1\61\1\123\1\0\1\20"+
    "\1\30\1\31\1\0\1\32\1\23\3\0\2\32\2\106"+
    "\2\0\1\106\26\0\2\75\2\0\2\32\1\0\1\32"+
    "\4\0\2\32\6\0\22\42\2\0\1\42\1\76\1\77"+
    "\1\0\1\20\1\30\1\31\1\0\1\32\1\23\3\0"+
    "\2\32\2\42\2\0\1\42\1\0\22\42\2\0\1\42"+
    "\2\77\1\105\1\20\1\33\1\31\1\0\1\32\1\23"+
    "\3\0\2\32\2\42\2\0\1\42\1\0\22\106\2\0"+
    "\1\106\1\61\1\123\1\0\1\20\1\30\1\124\1\0"+
    "\1\32\1\23\3\0\2\32\2\106\2\0\1\106\1\0"+
    "\21\15\1\125\2\0\3\15\1\17\1\20\1\21\1\37"+
    "\2\0\1\23\1\24\4\0\1\25\1\15\2\0\1\15"+
    "\1\0\17\15\1\126\2\15\2\0\3\15\1\17\1\20"+
    "\1\21\1\37\2\0\1\23\1\24\4\0\1\25\1\15"+
    "\2\0\1\15\1\0\22\127\2\0\1\127\1\103\1\127"+
    "\14\0\2\127\2\0\1\127\1\0\22\41\2\0\3\41"+
    "\1\57\1\0\1\103\4\0\1\24\4\0\1\104\1\41"+
    "\2\0\1\41\1\0\22\127\2\0\1\127\1\0\1\127"+
    "\14\0\2\127\2\0\1\127\1\0\22\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\2\130\1\106\17\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\4\130\1\134\15\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\17\130\1\106\2\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\6\130\1\106\13\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\7\130\1\106\12\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\12\130\1\106\7\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\14\130\1\106\5\130\2\0\3\130"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\130"+
    "\2\0\1\130\1\0\1\106\21\130\2\0\3\130\1\0"+
    "\2\130\1\131\2\132\1\133\4\132\1\0\2\130\2\0"+
    "\1\130\1\0\21\130\1\135\2\0\3\130\1\0\2\130"+
    "\1\131\2\132\1\133\4\132\1\0\2\130\2\0\1\130"+
    "\1\0\22\56\2\0\1\56\1\0\1\56\14\0\2\56"+
    "\2\0\1\56\42\0\1\136\7\0\22\130\2\0\1\130"+
    "\2\123\1\0\1\130\1\137\1\140\1\132\1\141\1\133"+
    "\3\132\1\141\1\32\2\130\2\0\1\130\1\0\22\15"+
    "\2\0\3\15\1\17\1\20\1\21\1\37\1\0\1\122"+
    "\1\23\1\24\4\0\1\142\1\15\2\0\1\15\1\0"+
    "\5\15\1\143\14\15\2\0\3\15\1\17\1\20\1\21"+
    "\1\37\2\0\1\23\1\24\4\0\1\25\1\15\2\0"+
    "\1\15\1\0\22\127\2\0\3\127\1\105\1\0\1\103"+
    "\11\0\2\127\2\0\1\127\1\0\1\144\1\145\1\146"+
    "\1\147\1\146\1\150\1\151\1\146\1\152\2\146\1\153"+
    "\1\146\1\154\2\146\1\155\1\146\2\0\1\146\1\130"+
    "\1\146\1\0\12\132\1\0\2\146\2\0\1\146\1\0"+
    "\22\132\2\0\3\132\1\0\12\132\1\0\2\132\2\0"+
    "\1\132\1\0\22\156\2\0\3\156\1\0\12\132\1\0"+
    "\2\156\2\0\1\156\1\0\5\130\1\106\14\130\2\0"+
    "\3\130\1\0\2\130\1\131\2\132\1\133\4\132\1\0"+
    "\2\130\2\0\1\130\1\0\20\130\1\106\1\130\2\0"+
    "\3\130\1\0\2\130\1\131\2\132\1\133\4\132\1\0"+
    "\2\130\2\0\1\130\42\0\1\157\7\0\22\130\2\0"+
    "\1\130\2\123\1\0\2\130\1\131\2\132\1\133\4\132"+
    "\1\0\2\130\2\0\1\130\1\0\1\144\1\145\1\146"+
    "\1\147\1\146\1\150\1\151\1\146\1\152\2\146\1\153"+
    "\1\146\1\154\2\146\1\155\1\146\2\0\1\146\1\123"+
    "\1\160\1\0\12\132\1\0\2\146\2\0\1\146\1\0"+
    "\22\132\2\0\1\132\2\161\1\0\12\132\1\0\2\132"+
    "\2\0\1\132\1\0\22\15\2\0\3\15\1\57\1\20"+
    "\1\21\1\37\1\0\1\122\1\23\1\24\4\0\1\25"+
    "\1\15\2\0\1\15\1\0\22\15\2\0\3\15\1\17"+
    "\1\20\1\21\1\37\1\0\1\162\1\23\1\24\4\0"+
    "\1\25\1\15\2\0\1\15\1\0\1\106\1\107\20\106"+
    "\2\0\1\106\1\130\1\106\1\0\2\130\1\131\2\132"+
    "\1\133\4\132\1\0\2\106\2\0\1\106\1\0\3\106"+
    "\1\111\16\106\2\0\1\106\1\130\1\106\1\0\2\130"+
    "\1\131\2\132\1\133\4\132\1\0\2\106\2\0\1\106"+
    "\1\0\22\106\2\0\1\106\1\130\1\106\1\0\2\130"+
    "\1\131\2\132\1\133\4\132\1\0\2\106\2\0\1\106"+
    "\1\0\10\106\1\112\11\106\2\0\1\106\1\130\1\106"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\106"+
    "\2\0\1\106\1\0\16\106\1\113\3\106\2\0\1\106"+
    "\1\130\1\106\1\0\2\130\1\131\2\132\1\133\4\132"+
    "\1\0\2\106\2\0\1\106\1\0\5\106\1\114\14\106"+
    "\2\0\1\106\1\130\1\106\1\0\2\130\1\131\2\132"+
    "\1\133\4\132\1\0\2\106\2\0\1\106\1\0\11\106"+
    "\1\115\10\106\2\0\1\106\1\130\1\106\1\0\2\130"+
    "\1\131\2\132\1\133\4\132\1\0\2\106\2\0\1\106"+
    "\1\0\1\106\1\116\20\106\2\0\1\106\1\130\1\106"+
    "\1\0\2\130\1\131\2\132\1\133\4\132\1\0\2\106"+
    "\2\0\1\106\1\0\5\106\1\117\14\106\2\0\1\106"+
    "\1\130\1\106\1\0\2\130\1\131\2\132\1\133\4\132"+
    "\1\0\2\106\2\0\1\106\1\0\16\106\1\120\3\106"+
    "\2\0\1\106\1\130\1\106\1\0\2\130\1\131\2\132"+
    "\1\133\4\132\1\0\2\106\2\0\1\106\1\0\22\156"+
    "\2\0\3\156\1\0\2\156\1\133\7\132\1\0\2\156"+
    "\2\0\1\156\1\0\22\163\2\0\3\163\14\0\2\163"+
    "\2\0\1\163\1\0\22\106\2\0\1\106\2\123\1\0"+
    "\1\130\1\137\1\140\1\132\1\141\1\133\3\132\1\141"+
    "\1\32\2\106\2\0\1\106\1\0\22\132\2\0\1\132"+
    "\2\161\1\0\1\132\2\141\1\132\1\141\4\132\1\141"+
    "\1\32\2\132\2\0\1\132\1\0\22\164\2\0\3\164"+
    "\14\0\2\164\2\0\1\164\1\0\22\163\2\0\3\163"+
    "\1\0\2\163\1\165\10\0\2\163\2\0\1\163\1\0"+
    "\22\164\2\0\3\164\1\0\2\164\1\162\2\0\1\23"+
    "\5\0\2\164\2\0\1\164\1\0\22\166\2\0\1\166"+
    "\1\163\1\166\14\0\2\166\2\0\1\166\1\0\22\132"+
    "\2\0\1\132\1\163\1\132\1\0\2\163\1\165\10\0"+
    "\2\132\2\0\1\132";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4633];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\6\1\1\11\5\1\1\0\3\1\2\0"+
    "\4\1\2\0\2\1\1\0\1\1\1\0\43\1\1\0"+
    "\1\1\1\0\13\1\2\0\13\1\1\0\20\1\1\0"+
    "\2\1\5\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	public final int yychar()
	{
	    return yychar;
	}
    /**
     * Return the internal token's character buffer.
     */
	final char [] yybuffer() {
		return zzBuffer;
	}

	final int yystart() {
		return zzStartRead;
	}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  ExtendedWhitespaceTokenizerImpl(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  ExtendedWhitespaceTokenizerImpl(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 204) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int getNextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { return ITokenType.TT_PUNCTUATION;
          }
        case 12: break;
        case 8: 
          { return ITokenType.TT_EMAIL;
          }
        case 13: break;
        case 3: 
          { return ITokenType.TT_NUMERIC;
          }
        case 14: break;
        case 1: 
          { ;
          }
        case 15: break;
        case 7: 
          { return ITokenType.TT_HYPHTERM;
          }
        case 16: break;
        case 6: 
          { return ITokenType.TT_FILE;
          }
        case 17: break;
        case 11: 
          { return ITokenType.TT_FULL_URL;
          }
        case 18: break;
        case 9: 
          { return ITokenType.TT_ACRONYM;
          }
        case 19: break;
        case 10: 
          { return ITokenType.TT_BARE_URL;
          }
        case 20: break;
        case 2: 
          { return ITokenType.TT_TERM;
          }
        case 21: break;
        case 5: 
          { return ITokenType.TT_PUNCTUATION | ITokenType.TF_SEPARATOR_SENTENCE;
          }
        case 22: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
