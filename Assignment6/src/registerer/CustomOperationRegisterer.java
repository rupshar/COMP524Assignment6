package registerer;

import evaluators.AndEvaluator;
import evaluators.CondEvaluator;
import evaluators.EvalEvaluator;
import evaluators.GTEEvaluator;
import evaluators.GTEvaluator;
import evaluators.LTEEvaluator;
import evaluators.LTEvaluator;
import evaluators.LambdaEvaluator;
import evaluators.ListEvaluator;
import evaluators.LoadEvaluator;
import evaluators.NotEvaluator;
import evaluators.OrEvaluator;
import evaluators.QuoteEvaluator;
import evaluators.SetQEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.OperationRegisterer;


public class CustomOperationRegisterer implements OperationRegisterer{

	@Override
	public void registerOperations() {
		registerAll();
	}
	
	public static void registerAll() {
		registerList();
		registerQuote();
		registerLoad();
		registerLT();
		registerLTE();
		registerGT();
		registerGTE();
		registerAnd();
		registerOr();
		registerNot();
		registerCond();
		registerEval();
	}
	
	public static void registerList() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("list", new ListEvaluator());
	}
	
	public static void registerQuote() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("quote", new QuoteEvaluator());
	}
	
	public static void registerLoad() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("load", new LoadEvaluator());
	}
	
	public static void registerLT() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("<", new LTEvaluator());
	}
	
	public static void registerLTE() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("<=", new LTEEvaluator());
	}
	
	public static void registerGT() {
		BuiltinOperationManagerSingleton.get().registerEvaluator(">", new GTEvaluator());
	}
	
	public static void registerGTE() {
		BuiltinOperationManagerSingleton.get().registerEvaluator(">=", new GTEEvaluator());
	}
	
	public static void registerAnd() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("and", new AndEvaluator());
	}
	
	public static void registerOr() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("or", new OrEvaluator());
	}
	
	public static void registerNot() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("not", new NotEvaluator());
	}
	
	public static void registerCond() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("cond", new CondEvaluator());
	}
	
	public static void registerEval() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("eval", new EvalEvaluator());
	}
	
}
