package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class CondEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		// TODO Auto-generated method stub
		
		sexpression = sexpression.getTail();
		
		if(sexpression instanceof NilAtom) {
			throw new IllegalStateException("Missing evaluator");
		}
		
		SExpression boolExp = sexpression.getHead().getHead();
		SExpression head = sexpression.getHead();
		SExpression tail = sexpression.getTail();
		
		boolean checkTrue = false;
		
		while(!(tail instanceof NilAtom) || !checkTrue) {
			SExpression evalBoolExp = boolExp.eval(env);
			
			if(!(evalBoolExp instanceof NilAtom)) {
				checkTrue = true;
				break;
			}
			
			if(tail instanceof NilAtom) {
				break;
			}
			
			boolExp = tail.getHead().getHead();
			head = tail.getHead();
			tail = tail.getTail();
		}
		
		if(checkTrue) {
			return head.getTail().getHead().eval(env);
		} else {
			return new NilAtom();
		}
		
	}

}
