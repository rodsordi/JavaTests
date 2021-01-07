package br.com.rodrigo.pattern.chain.impl;

import br.com.rodrigo.model.Model;
import br.com.rodrigo.pattern.chain.Chain;
import br.com.rodrigo.pattern.chain.Step;

public class ChainOfResponsibility extends Chain<Model> {
	
	public ChainOfResponsibility() {
		this
		.link(new A())
		.link(new B())
		.link(new C());
	}
	
	public class A extends Step<Model> {
		protected void check(final Model model) {
			if (model.getId() > 10) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
	public class B extends Step<Model> {
		protected void check(final Model model) {
			if (model.getId() % 2 == 1) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
	public class C extends Step<Model> {
		protected void check(final Model model) {
			if (model.getId() == 15) {
				result.setQtd(result.getQtd() + 1);
				next(model);
			}
		}
	}
	
}
