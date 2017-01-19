package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.component.Sample1Component;
import com.example.component.Sample2Component;
import com.example.entity.Sample1Entity;
import com.example.exception.AppException;

@Service
public class Sample1Service {
	
	@Autowired
	private Sample1Component sample1Component;
	
	@Autowired
	private Sample2Component sample2Component;
	
	public int test1() {
		int a = 0;
		a += sample1Component.hoge1(1);
		a += sample2Component.foo1(1);
		
		return a;
	}
	
	public void test2(int a) throws AppException {
		if (a == 0) {
			throw new AppException();
		}
	}
	
	public <T> T test3(String text) {
		Sample1Entity a = new Sample1Entity();
		a.name = text;
		return (T) sample1Component.hoge2(a, Sample1Entity.class);
	}
	
	
	
}
