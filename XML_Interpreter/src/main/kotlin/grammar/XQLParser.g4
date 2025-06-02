parser grammar XQLParser;

options { tokenVocab=XQLLexer; }

program: statement* EOF;

statement
    : load
    | assignment
    | save
    ;

load: LOAD expr TO ID;

assignment: ID EQUALS expr;

save: SAVE ID TO expr;

expr
    : path
    | countExpr
    | mapExpr
    | aggregateExpr
    | literal
    | xmlTemplate
    ;

path: ID (pathStep)*;

pathStep
    : DOT ID
    | DOT AT ID
    | LEFT_BRACKET NUMBER RIGHT_BRACKET
    ;

countExpr: path HASH;

mapExpr: path ARROW ID (DOT ID)*;

aggregateExpr: path ARROW ID PLUSPLUS;

literal
    : STRING
    | NUMBER
    ;

xmlTemplate: XML_TEMPLATE;