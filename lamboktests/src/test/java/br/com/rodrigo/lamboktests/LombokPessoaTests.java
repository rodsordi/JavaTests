package br.com.rodrigo.lamboktests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.rodrigo.lamboktests.model.Pessoa;

public class LombokPessoaTests {
	
	@Test
	public void testGettersAndSetters() {
		Pessoa p = new Pessoa();
		p.setNome("Rodrigo");
		p.setIdade(29);
		p.setAtivo(true);
		
		assertNotNull(p);
		assertEquals("Rodrigo", p.getNome());
		assertEquals(new Integer(29), p.getIdade());
		assertTrue(p.isAtivo());
	}
}
