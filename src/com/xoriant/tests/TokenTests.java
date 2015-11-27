package com.xoriant.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xoriant.dao.Token;

public class TokenTests {

	@Test
	public void Eqaulity_Check() {
		Token rahulin=new Token("rahul");
		Token rahulex=new Token("rahul");
		assertEquals(rahulin, rahulex);
	}
	
	@Test
	public void InEqaulityCheck(){
		Token rahulin=new Token("rahul");
		Token rahulex=new Token("ravi");
		assertNotEquals(rahulin, rahulex);
	}
	
	@Test
	public void withPasswordCheck(){
		Token rahulin=new Token("rahul"+"password");
		Token rahulex=new Token("ravi"+"password");
		assertNotEquals(rahulin, rahulex);
	}
}
