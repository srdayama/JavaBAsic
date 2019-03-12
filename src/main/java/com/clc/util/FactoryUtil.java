package com.clc.util;

import org.springframework.stereotype.Component;

@Component
public class FactoryUtil {

	static {
		System.out.println("inside factory util static block...");
	}

	public FactoryUtil() {
		super();
		System.out.println("inside factory util constructor.....");
	}

}
