package registerer;

import evaluators.LambdaEvaluator;
import evaluators.SetQEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.OperationRegisterer;

public class StatefulOperationRegisterer implements OperationRegisterer {
	
	public static void registerSetQ() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("setq", new SetQEvaluator());
	}
	
	public static void registerLambda() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("lambda", new LambdaEvaluator());
	}
	
	public static void registerAll() {
		registerSetQ();
		registerLambda();
	}

	@Override
	public void registerOperations() {
		registerAll();
	}

}
