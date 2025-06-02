grammar Csv;
csv: line (NEWLINE line)* NEWLINE?;
line: value (SEPARATOR value)*;
value: (BOOLEAN | NUMBER | STRING)?;


BOOLEAN: 'true'|'false';
NUMBER: [0-9]+ ('.'[0-9]+)?;
STRING: '"' ~('"'|'\n')* '"';
SEPARATOR: ',' | ';';
NEWLINE: '\n'|'\n\r';
SPACE: ' '+ -> skip;