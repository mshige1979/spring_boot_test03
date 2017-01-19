package com.example.component;

import org.springframework.stereotype.Component;

@Component
public class Sample2Component {
	
	public int foo1(int a) {
		return a * 100;
	}
	
	public <T> T foo2(T a, Class<T> b) throws InstantiationException, IllegalAccessException {
		
		T res;
		Class<T> result = b.getClass().newInstance();
		
		return null;
		
	}
}
