package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;

public class QuoteEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		// TODO Auto-generated method stub
		return sexpression.getTail().getHead();
	}

}
