package terms;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.scanner.tokens.Token;

public class EvalVariable extends IdentifierAtom {
	
	public EvalVariable(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}
	
	public EvalVariable(Token token) {
		super(token);
	}

	@Override
	public SExpression eval(Environment env) {
		if(env.lookup(this).isPresent()) {
			return env.lookup(this).get();
		} else {
			return null;
		}
	}

}
