package br.com.rodrigo.pattern.chain;

import br.com.rodrigo.model.Model;
import lombok.Setter;

public abstract class Step<T extends Model> {
	@Setter
	private Step<T> next;
	
	protected abstract void check(final T model);
	
	protected void next(final T model) {
		if (next != null)
			next.check(model);
	}
}