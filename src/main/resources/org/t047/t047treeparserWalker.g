tree grammar t047treeparserWalker;
options {
    tokenVocab=t047treeparser;
    ASTLabelType=CommonTree;
    filter=true;
	output = AST;
}

@header {
package org.t047;

import java.util.Vector;    
}

variable
    :   ^(VAR_DEF type declarator)
        { 
            System.out.println($declarator.text);
        }
    ;

variables //returns [List<String> res]
//@init {
//    res = new ArrayList<String>(4);
//}
	: (v=variable 
	//{ $res.add(v); } 
	)*
	;

declarator
    :   ID 
    ;

type
    :   'int'
    |   'char'
    |   'void'
    |   ID        
    ;
