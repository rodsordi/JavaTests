package br.com.rodrigo.pattern.chain.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.rodrigo.model.ExtendedModel;
import br.com.rodrigo.pattern.chain.Result;
import br.com.rodrigo.pattern.chain.impl.ChainOfResponsibility;

public class ChainOfResponsibilityTests {

	@Test
	public void test_check_0() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setId(9);
		//When
		Result actual = new ChainOfResponsibility().check(mock);
		//Then
		assertEquals(0, actual.getQtd());
	}
	
	@Test
	public void test_check_1() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setId(12);
		//When
		Result actual = new ChainOfResponsibility().check(mock);
		//Then
		assertEquals(1, actual.getQtd());
	}
	
	@Test
	public void test_check_2() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setId(13);
		//When
		Result actual = new ChainOfResponsibility().check(mock);
		//Then
		assertEquals(2, actual.getQtd());
	}
	
	@Test
	public void test_check_3() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setId(15);
		//When
		Result actual = new ChainOfResponsibility().check(mock);
		//Then
		assertEquals(3, actual.getQtd());
	}
	
}
