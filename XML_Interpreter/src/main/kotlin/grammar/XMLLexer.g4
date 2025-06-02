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
NameChar    : NameStartChar | '-' | '_' | '.' | [0-9];

fragment
NameStartChar : [a-zA-Z0-9_] ;
