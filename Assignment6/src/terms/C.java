package terms;

import java.util.ArrayList;
import java.util.List;

import evaluators.LambdaEvaluator;
import main.lisp.evaluator.BasicExpressionEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationManager;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class C extends BasicExpressionEvaluator {
	
	public C() {
		super();
	}
	
	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		SExpression head = sexpression.getHead();
		if(head instanceof IdentifierAtom) {
			Evaluator evaluator = BuiltinOperationManagerSingleton.get().getEvaluator(sexpression.getHead().toString());
			SExpression newEval = evaluator.eval(sexpression, env);
			return newEval;
		} else {
			Environment childEnv = env.newChild();
			Evaluator evaluator = BuiltinOperationManagerSingleton.get().getEvaluator(head.getHead().toString());
			SExpression lambdaEval = evaluator.eval(head, env);
			IdentifierAtom[] params = ((Lambda) lambdaEval).getArgumentNames();
			SExpression inputParams = sexpression.getTail();
			List<Atom> inputs = new ArrayList<Atom>();
			SExpression inputHead = null;
			
			while(!(inputParams instanceof NilAtom)) {
				inputHead = inputParams.getHead();
				inputs.add((Atom) inputHead);
				inputParams = inputParams.getTail();
			}
			
			for(int i = 0; i < inputs.size(); i++) {
				env.assign(params[i], inputs.get(i));
			}
			
			return lambdaEval.eval(childEnv);
		}
	}

}
