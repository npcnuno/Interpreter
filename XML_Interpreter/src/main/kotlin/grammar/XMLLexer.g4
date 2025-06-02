lexer grammar XMLLexer;

COMMENT     : '<!--' .*? '-->' ;
CDATA       : '<![CDATA[' .*? ']]>' ;
EntityRef   : '&' Name ';' ;
CharRef     : '&#' [0-9]+ ';' | '&#x' [0-9a-fA-F]+ ';' ;
SEA_WS      : (' '|'\t'|'\r'? '\n')+ ;
OPEN        : '<' -> pushMode(INSIDE) ;
XMLDeclOpen : '<?xml' S -> pushMode(INSIDE) ;
PI          : '<?' Name .*? '?>' ;
TEXT        : ~[<&]+ ;

mode INSIDE;

SLASH       : '/' ;
EQUALS      : '=' ;
STRING      : '"' .*? '"' | '\'' .*? '\'' ;
Name        : NameStartChar NameChar* ;
S           : [ \t\r\n]+ -> skip ;
CLOSE       : '>' -> popMode ;
SLASH_CLOSE : '/>' -> popMode ;
SPECIAL_CLOSE: '?>' -> popMode ;

fragment
NameChar    : NameStartChar | '-' | '_' | '.' | [0-9] | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' ;

fragment
NameStartChar : [a-zA-Z] | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' ;
