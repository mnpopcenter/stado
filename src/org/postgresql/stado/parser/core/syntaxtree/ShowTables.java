//
// Generated by JTB 1.2.2
//

package org.postgresql.stado.parser.core.syntaxtree;

/**
 * Grammar production:
 * f0 -> <SHOW_TABLES_>
 */
public class ShowTables implements Node {
   public NodeToken f0;

   public ShowTables(NodeToken n0) {
      f0 = n0;
   }

   public ShowTables() {
      f0 = new NodeToken("TABLES");
   }

   public void accept(org.postgresql.stado.parser.core.visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(org.postgresql.stado.parser.core.visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

