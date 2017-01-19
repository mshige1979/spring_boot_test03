package com.example.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.example.component.Sample1Component;
import com.example.component.Sample2Component;
import com.example.entity.Sample1Entity;

public class Test1Base {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Mock
	protected Sample1Component sample1Component;
	
	@Mock
	protected Sample2Component sample2Component;
	
	protected void init() {
		//when(sample1Component.hoge2((Sample1Entity) anyObject())).thenReturn(200);
		//when(sample1Component.hoge2((Sample1Entity) any(Sample1Entity.class))).thenReturn(600);
		when(sample1Component.hoge2(anyObject(), any())).thenAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Sample1Entity a = (Sample1Entity)args[0];
				Sample1Entity x = new Sample1Entity();
				
				if (a.name.equals("111")) {
					x.name = "aaa";
					x.age = "20";
				} else {
					x.name = "bbb";
					x.age = "40";
				}
				
				return x;
			}
		});

	}
	
}
