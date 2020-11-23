package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class EvalEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		// TODO Auto-generated method stub
		
		sexpression = sexpression.getTail();
		
		if(sexpression instanceof NilAtom) {
			throw new IllegalStateException("Cannot be NilAtom");
		}
		
		SExpression evaluatedSExpression = sexpression.getHead().eval(env);
		
		return evaluatedSExpression.eval(env);

	}

}
