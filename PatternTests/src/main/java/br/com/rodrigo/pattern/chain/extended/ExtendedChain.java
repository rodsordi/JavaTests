package br.com.rodrigo.pattern.chain.extended;

import br.com.rodrigo.model.ExtendedModel;
import br.com.rodrigo.pattern.chain.Chain;
import br.com.rodrigo.pattern.chain.Result;
import br.com.rodrigo.pattern.chain.Step;

public class ExtendedChain<T extends ExtendedModel> extends Chain<T> {
	
	public ExtendedChain() {
		this
		.link(new A1())
		.link(new B2())
		.link(new C3());
	}
	
	public Result check(final T model) {
		return super.check(model);
	}
	
	public class A1 extends Step<T> {
		protected void check(final T model) {
			if (model.getName() != null) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
	public class B2 extends Step<T> {
		protected void check(final T model) {
			if (model.getName().length() == 1) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
	public class C3 extends Step<T> {
		protected void check(final T model) {
			if (model.getName().equals("B")) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
}
