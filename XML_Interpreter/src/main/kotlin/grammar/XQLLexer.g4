lexer grammar XQLLexer;

LOAD: 'load';
TO: 'to';
SAVE: 'save';
EQUALS: '=';
DOT: '.';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
AT: '@';
HASH: '#';
ARROW: '->';
PLUSPLUS: '++';

STRING: '"' (~["\\] | '\\' .)* '"';
NUMBER: [0-9]+ ('.' [0-9]+)?;
ID: [a-zA-Z_$][a-zA-Z0-9_]*;
XML_TEMPLATE: '***' .*? '***' -> mode(DEFAULT_MODE);

SEA_WS: (' ' | '\t' | '\r'? '\n')+ -> skip;
COMMENT: '<!--' .*? '-->' -> skip;