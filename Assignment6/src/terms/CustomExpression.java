package terms;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class CustomExpression extends BasicExpression implements SExpression {

	public CustomExpression(SExpression head, SExpression tail) {
		super(head, tail);
	}

	@Override
	public boolean isList() {
		SExpression tail = this.getTail();
		if(isNil(tail)) {
			return true;
		} else {
			return tail.isList();
		}
	}
	
	public boolean isNil(SExpression expression) {
		if(expression instanceof NilAtom) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toStringAsList() {
		// TODO Auto-generated method stub
		StringBuilder ret_str = new StringBuilder();
		
		SExpression head = this.getHead();
		SExpression tail = this.getTail();
		
		ret_str.append("(");
		ret_str.append(head.toString());
		StringBuilder new_string = toStringAsListHelperPublic(tail, ret_str);
		new_string.append(")");
		return new_string.toString();
	}
	
	public StringBuilder toStringAsListHelperPublic(SExpression tail, StringBuilder str) {
		if(!(isNil(tail))) {
			str.append(" ");
			str.append(tail.getHead().toString());
			toStringAsListHelperPublic(tail.getTail(), str);
		}
		return str;
	}

	@Override
	public String toStringAsSExpression() {
		// TODO Auto-generated method stub
		return new StringBuilder().append("(").append(this.getHead().toString()).append(" . ").append(this.getTail().toString()).append(")").toString();	
	}

	@Override
	public String toStringAsSExpressionDeep() {
		// TODO Auto-generated method stub
		return new StringBuilder().append("(").append(this.getHead().toStringAsSExpressionDeep()).append(" . ").append(this.getTail().toStringAsSExpressionDeep()).append(")").toString();	
	}
	
	public String toString() {
		return this.isList()? this.toStringAsList() : this.toStringAsSExpression();
	}

}
