package br.com.rodrigo.pattern.chain;

import br.com.rodrigo.model.Model;

public class Chain<T extends Model> {
	protected Step<T> first;
	protected Step<T> previous;
	protected Result result = new Result();
	
	public Chain<T> link(final Step<T> step) {
		if (previous != null)
			previous.setNext(step);
		else
			first = step;
		previous = step;
		return this;
	}
	
	public Result check(final T model) {
		if (first != null)
			first.check(model);
		return result;
	}
}
