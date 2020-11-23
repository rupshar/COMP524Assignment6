package assignment;

import evaluators.LambdaEvaluator;
import main.lisp.evaluator.ExpressionEvaluator;
import main.lisp.evaluator.ExpressionEvaluatorFactory;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;
import terms.EvalVariable;
import terms.LambdaExpression;
import registerer.CustomOperationRegisterer;
import registerer.StatefulOperationRegisterer;
import terms.C;
import terms.CustomExpression;

public class CustomMain {
	
	public static void main(String[] args) {
		ExpressionFactory.setClass(CustomExpression.class);
		EnvironmentFactory.setClass(CustomEnvironment.class);
		IdentifierAtomFactory.setClass(EvalVariable.class);
		ExpressionEvaluatorFactory.setClass(C.class);
		
		CustomOperationRegisterer.registerAll();
		StatefulOperationRegisterer.registerAll();
		main.Main.main(args);
	}

}
