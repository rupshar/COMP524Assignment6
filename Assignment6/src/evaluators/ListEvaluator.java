package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.AbstractAtom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import java.util.Stack;

public class ListEvaluator implements Evaluator {
	
	public SExpression eval(SExpression sexpression, Environment env) {

		SExpression head = sexpression.getHead().eval(env);
		SExpression tail = sexpression.getTail();
		
		Stack<SExpression> atoms = new Stack();
		
//		SExpression ret_exp = ExpressionFactory.newInstance(head, tail);
//		
//		if(ret_exp.isList()) {
//			return ret_exp.getTail();
//		} else {
//			return ExpressionFactory.newInstance(head, ExpressionFactory.newInstance(tail, new NilAtom()));
//		}
		
		while(!(tail instanceof NilAtom)) {
			SExpression next = tail.getHead();
			next = next.eval(env);
			atoms.push(next);
			tail = tail.getTail();
		}
		
		if(atoms.empty()) {
			return new NilAtom();
		}
		
		SExpression ret_exp = ExpressionFactory.newInstance(atoms.pop(), new NilAtom());
		while(!atoms.empty()) {
			ret_exp = ExpressionFactory.newInstance(atoms.pop(), ret_exp);
		}
		
		return ret_exp;
		
	}

}
