package br.com.rodrigo.pattern.chain.impl;

import br.com.rodrigo.model.ExtendedModel;
import br.com.rodrigo.pattern.chain.Step;
import br.com.rodrigo.pattern.chain.extended.ExtendedChain;

public class ExtendedChainOfResponsibility extends ExtendedChain<ExtendedModel> {
	
	public ExtendedChainOfResponsibility() {
		this
		.link(new A())
		.link(new B())
		.link(new C());
	}
	
	public class A extends Step<ExtendedModel> {
		protected void check(final ExtendedModel model) {
			if (model.getId() > 10) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
	public class B extends Step<ExtendedModel> {
		protected void check(final ExtendedModel model) {
			if (model.getId() % 2 == 1) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
	public class C extends Step<ExtendedModel> {
		protected void check(final ExtendedModel model) {
			if (model.getId() == 15) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
}
