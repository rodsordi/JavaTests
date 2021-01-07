package br.com.rodrigo.pattern.chain.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.rodrigo.model.ExtendedModel;
import br.com.rodrigo.pattern.chain.Result;

public class ExtendedChainOfResponsibilityTests {
	
	@Test
	public void test_check_0() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		//When
		Result actual = new ExtendedChainOfResponsibility().check(mock);
		//Then
		assertEquals(0, actual.getQtd());
	}
	
	@Test
	public void test_check_1() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setName("AB");
		//When
		Result actual = new ExtendedChainOfResponsibility().check(mock);
		//Then
		assertEquals(1, actual.getQtd());
	}
	
	@Test
	public void test_check_2() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setName("A");
		//When
		Result actual = new ExtendedChainOfResponsibility().check(mock);
		//Then
		assertEquals(2, actual.getQtd());
	}
	
	@Test
	public void test_check_3() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setName("B");
		//When
		Result actual = new ExtendedChainOfResponsibility().check(mock);
		//Then
		assertEquals(3, actual.getQtd());
	}
	
	@Test
	public void test_check_4() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setName("B");
		mock.setId(12);
		//When
		Result actual = new ExtendedChainOfResponsibility().check(mock);
		//Then
		assertEquals(4, actual.getQtd());
	}
	
	@Test
	public void test_check_5() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setName("B");
		mock.setId(13);
		//When
		Result actual = new ExtendedChainOfResponsibility().check(mock);
		//Then
		assertEquals(5, actual.getQtd());
	}
	
	@Test
	public void test_check_6() {
		//Given
		ExtendedModel mock = new ExtendedModel();
		mock.setName("B");
		mock.setId(15);
		//When
		Result actual = new ExtendedChainOfResponsibility().check(mock);
		//Then
		assertEquals(6, actual.getQtd());
	}
	
}
