package com.example.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.component.Sample1Component;
import com.example.component.Sample2Component;
import com.example.entity.Sample1Entity;
import com.example.exception.AppException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Sample1ServiceTest extends Test1Base {
	
	@InjectMocks
	private Sample1Service sample1Service;
	
	@Test
    public void throwsNullPointerException() {
            thrown.expect(AppException.class);
            throw new AppException();
    }
	
	@Test
	public void test1() throws Exception {
		
		when(sample1Component.hoge1(anyInt())).thenReturn(5);
		when(sample2Component.foo1(anyInt())).thenReturn(100);
		int res = sample1Service.test1();
		assertEquals(res, 105);
	}
	
	@Test
	public void test1_b() throws Exception {
		
		when(sample1Component.hoge1(1)).thenReturn(200);
		when(sample2Component.foo1(1)).thenReturn(150);
		int res = sample1Service.test1();
		assertEquals(res, 350);
	}
	
	@Test
	public void test2() throws Exception {
		int a = 0;
		thrown.expect(AppException.class);
		sample1Service.test2(a);
	}
	
	@Test
	public void test2_b() {
		int a = 1;
		sample1Service.test2(a);
	}
	
	@Test
	public <T> void test3_1() {
		Sample1Entity a = new Sample1Entity();
		a.name = "111";
		Sample1Entity b = new Sample1Entity();
		b.name = "222";
		
		init();
		
		Sample1Entity res1 = sample1Service.test3("111");
		Sample1Entity res2 = sample1Service.test3("222");
		
		System.out.println(res1.name);
		System.out.println(res2.name);
	}
}
