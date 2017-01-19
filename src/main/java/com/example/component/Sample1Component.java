package com.example.component;

import org.springframework.stereotype.Component;

import com.example.entity.Sample1Entity;

@Component
public class Sample1Component {
	
	public int hoge1(int a) {
		int b = 0;
		
		if (a == 1) {
			b= 100;
		} else {
			b = 200;
		}
		
		return b;
	}
	
	public <T> T hoge2(T entity, Class<T> className) {
		return entity;
	}
	
}
