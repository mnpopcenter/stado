//
// Generated by JTB 1.2.2
//

package org.postgresql.stado.parser.core.syntaxtree;

/**
 * Grammar production:
 * f0 -> <DATE_LITERAL>
 */
public class DateLiteral implements Node {
   public NodeToken f0;

   public DateLiteral(NodeToken n0) {
      f0 = n0;
   }

   public DateLiteral() {
      f0 = new NodeToken("'");
   }

   public void accept(org.postgresql.stado.parser.core.visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(org.postgresql.stado.parser.core.visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}
