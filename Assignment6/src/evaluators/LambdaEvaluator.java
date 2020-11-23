package evaluators;

import java.util.ArrayList;
import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class LambdaEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		// TODO Auto-generated method stub
		sexpression = sexpression.getTail();
		List<IdentifierAtom> parameters = new ArrayList<IdentifierAtom>();
		SExpression head = sexpression.getHead();
		
		while(!(head instanceof NilAtom)) {
			parameters.add((IdentifierAtom) head.getHead());
			head = head.getTail();
		}
				
		IdentifierAtom[] params = new IdentifierAtom[parameters.size()]; 
        params = parameters.toArray(params); 
		
		SExpression funcBody = sexpression.getTail();
		
		return LambdaFactory.newInstance(params, funcBody);
	}
	

}
