package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.AbstractAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class NotEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		
		sexpression = sexpression.getTail();
		
		SExpression head = sexpression.getHead();
		
		if(head.eval(env) instanceof NilAtom) {
			return new TAtom();
		} else {
			return new NilAtom();
		}

	}

}
