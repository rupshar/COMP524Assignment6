package evaluators;

import evaluators.AndEvaluator.AtomType;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.AbstractAtom;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class OrEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		
		SExpression operator = sexpression.getHead();
		sexpression = sexpression.getTail();
		
		SExpression head = sexpression.getHead();
		SExpression tail = sexpression.getTail();
		
		while(!(tail instanceof NilAtom)) {
			if(!(head.eval(env) instanceof NilAtom)) {
				return head.eval(env);
			}
			
			head = tail.getHead();
			tail = tail.getTail();
		}
		
		if(!(head.eval(env) instanceof NilAtom)) {
			return head.eval(env);
		} else {
			return new NilAtom();
		}	
		
//		
//		if(sexpression instanceof Atom) {
//			return new NilAtom();
//		} else if(!(sexpression.getHead().eval(env) instanceof NilAtom)) {
//			return sexpression.getHead().eval(env);
//		} else {
//			return this.eval(ExpressionFactory.newInstance(operator, sexpression.getTail()), env);
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