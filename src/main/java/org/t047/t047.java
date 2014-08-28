package org.t047;

import org.t047.t047treeparserLexer;
import org.t047.t047treeparserParser;
import org.t047.t047treeparserWalker;

import org.antlr.runtime.*;  
import org.antlr.runtime.tree.*;  
  
public class t047 {  
  public static void main(String[] args) throws Exception {  
    // create an instance of the lexer  
	  ANTLRStringStream s = new ANTLRStringStream(
			  "            char c;                    \n"+
			  "            int x;                     \n"+
			  "                                       \n"+
			  "            void bar(int x);           \n"+
			  "                                       \n"+
			  "            int foo(int y, char d) {   \n"+
			  "              int i;                   \n"+
			  "              for (i=0; i<3; i=i+1) {  \n"+
			  "                x=3;                   \n"+
			  "                y=5;                   \n"+
			  "              }                        \n"+
			  "            }                          \n"
			  );
	  t047treeparserLexer lexer = new t047treeparserLexer(s);  
          
    // wrap a token-stream around the lexer  
    CommonTokenStream tokens = new CommonTokenStream(lexer);  
          
    // create the parser  
    t047treeparserParser parser = new t047treeparserParser(tokens);  
      
    // walk the tree  
    CommonTree tree = (CommonTree)parser.program().getTree();
    System.out.println(tree.toStringTree());
    CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);  
    nodes.setTokenStream(tokens);
    
    // pass the reference to the Map of functions to the tree walker  
    t047treeparserWalker walker = new t047treeparserWalker(nodes/*, parser.functions*/);  
      
    // get the returned node   
    //TLNode returned = 
    //walker.program(); 
    walker.variables();
    //System.out.println(returned == null ? "null" : returned.evaluate());  
  }  
}
