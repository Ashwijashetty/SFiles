package com.cg.demo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.demo.TestDemo1;

public class TestDemo1Test {
TestDemo1 testdemo=null;
	@Before
	public void setUp() throws Exception {
		testdemo=new TestDemo1();
	}

	@After
	public void tearDown() throws Exception {
	testdemo=null;
	}

	@Test
	public void testMethod1() {
	int r=testdemo.method1(10,2);
	assertEquals(20, r);
	
	}
	

	@Test
	public void testMethod2() {
		boolean y=testdemo.method2("abc","abc");
		assertEquals(true, y);

	}

}
