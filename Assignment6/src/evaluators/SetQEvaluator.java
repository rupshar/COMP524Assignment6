package evaluators;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import terms.EvalVariable;

public class SetQEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		// TODO Auto-generated method stub
		sexpression = sexpression.getTail();
		
		IdentifierAtom id = (IdentifierAtom) sexpression.getHead();
		SExpression value = sexpression.getTail().getHead();
		
//		Atom evalAtom = (Atom) value.eval(env);
		value = value.eval(env);
		
		env.assign(id, value);
		return value;
	}
	
	

}
