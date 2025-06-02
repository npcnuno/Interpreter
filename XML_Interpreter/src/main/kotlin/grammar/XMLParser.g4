parser grammar XMLParser;

options { tokenVocab=XMLLexer; }

document    : prolog? misc* element misc* EOF ;

prolog      : XMLDeclOpen attribute* SPECIAL_CLOSE ;

content     : chardata? ((element | reference | CDATA | PI | COMMENT) chardata?)* ;

element     : '<' Name attribute* '>' content '<' SLASH Name '>'
            | '<' Name attribute* SLASH_CLOSE
            ;

reference   : EntityRef | CharRef ;

attribute   : Name EQUALS STRING ;

chardata    : TEXT | SEA_WS ;

misc        : COMMENT | PI | SEA_WS ;
