package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.AbstractAtom;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class AndEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {	
		
		SExpression operator = sexpression.getHead();
		sexpression = sexpression.getTail();
		
		SExpression head = sexpression.getHead();
		SExpression tail = sexpression.getTail();
		
		while(!(tail instanceof NilAtom)) {
			if(head.eval(env) instanceof NilAtom) {
				return new NilAtom();
			}
			
			head = tail.getHead();
			tail = tail.getTail();
		}
		
		if(!(head.eval(env) instanceof NilAtom)) {
			return head.eval(env);
		} else {
			return new NilAtom();
		}
		
//		SExpression evalHead = sexpression.getHead().eval(env);
//		SExpression evalTail = sexpression.getTail();
//		
//		AtomType headStatus = checkStatus(evalHead);
//		AtomType tailStatus = checkStatus(evalTail);
//		
//		if(headStatus == AtomType.NIL) {
//			return evalHead;
//		} else if(tailStatus == AtomType.ATOM || tailStatus == AtomType.NIL) {
//			return evalHead;
//		} else {
//			return this.eval(ExpressionFactory.newInstance(operator, evalTail), env);
//		}
		
		
		
	}
	
	public AtomType checkStatus(SExpression check) {
		if(check instanceof NilAtom) {
			return AtomType.NIL;
		} else if(check instanceof Atom) {
			return AtomType.ATOM;
		} else {
			return AtomType.NONE;
		}
	}
	
	public enum AtomType {
		NIL,
		ATOM,
		NONE
	}

}
