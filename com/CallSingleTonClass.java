package com;

public class CallSingleTonClass {

	public static void main(String[] args) {
		SingletonClass s1 = SingletonClass.getInstance();
		s1.name="RKS";
		SingletonClass s2 = SingletonClass.getInstance();
		
		System.out.println(s1);
		System.out.println(s1.toString());
		System.out.println(s1.name);
		System.out.println(s2.name);
		System.out.println(s2.getDetailOfClass());
	}

}
