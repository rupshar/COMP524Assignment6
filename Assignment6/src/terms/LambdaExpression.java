package terms;

import java.util.ArrayList;
import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class LambdaExpression extends CustomExpression {

	public LambdaExpression(SExpression head, SExpression tail) {
		super(head, tail);
		// TODO Auto-generated constructor stub
	}
	
	public SExpression eval(Environment env) {
		Environment childEnv = env.newChild();
		
		Lambda lambda = (Lambda) this.getHead().eval(env);
		
		List<SExpression> list = new ArrayList<SExpression>();
		
		SExpression sexpression = this.getTail();
		
		while(!(sexpression instanceof NilAtom)) {
			list.add(sexpression.getHead().eval(env));
			sexpression = sexpression.getTail();
		}
		
		IdentifierAtom[] args = lambda.getArgumentNames();
		
		for(int i = 0; i < list.size(); i++) {
			childEnv.assign(args[i], list.get(i));
		}
		
		return lambda.eval(childEnv);
		
	}

}
