package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.AbstractAtom;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class GTEEvaluator implements Evaluator {
	
	@Override
	public SExpression eval(SExpression sexpression, Environment env) {

		// make sure sexpression is valid	
		
		sexpression = sexpression.getTail();
		
		if(sexpression instanceof NilAtom || sexpression.getHead() instanceof NilAtom || sexpression.getTail() instanceof NilAtom) {
			throw new IllegalStateException("Don't want any NilAtoms");
		}
		
		SExpression head = sexpression.getHead().eval(env);
		SExpression tail = sexpression.getTail().getHead().eval(env);

		AtomType int1Status = checkStatus(head);
		AtomType int2Status = checkStatus(tail);
		if(int1Status == AtomType.NONE || int2Status == AtomType.NONE) {
			throw new IllegalStateException("Need two numbers");
		}
		AbstractAtom<Long> value1 = (AbstractAtom<Long>) head;
		AbstractAtom<Long> value2 = (AbstractAtom<Long>) tail;
		boolean greaterThanEqual = value1.getValue().longValue() >= value2.getValue().longValue();
		return greaterThanEqual ? new TAtom() : new NilAtom();		
	}
	
	public AtomType checkStatus(SExpression sexpression) {
		if(sexpression instanceof IntegerAtom) {
			return AtomType.INTEGER;
		} else if (sexpression instanceof DecimalAtom){
			return AtomType.DECIMAL;
		} else {
			return AtomType.NONE;
		}
	}
	
	enum AtomType {
		INTEGER,
		DECIMAL,
		NONE
	}

}
