package assignment;

import java.util.Optional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.environment.AbstractEnvironment;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class CustomEnvironment extends AbstractEnvironment {
	
	public CustomEnvironment() {
		super();
	}
	
	public CustomEnvironment(Environment parent) {
		super(parent);
	}

	@Override
	public void assign(IdentifierAtom arg0, SExpression arg1) {
		// TODO Auto-generated method stub
		this.put(arg0, arg1);
	}

	@Override
	public void assignFun(IdentifierAtom arg0, Function arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Environment copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SExpression> lookup(IdentifierAtom arg0) {
		// TODO Auto-generated method stub
		Optional<SExpression> id = this.get(arg0);
		if(!id.isPresent() && this.getParent() != null) {
			return this.getParent().lookup(arg0);
		} else {
			return id;
		}
	}

	@Override
	public Optional<Function> lookupFun(IdentifierAtom arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment newChild() {
		// TODO Auto-generated method stub
		return new CustomEnvironment(this);
	}

}
