package com;

public final class SingletonClass {
	
	private static final SingletonClass singleObj = new SingletonClass();
	String name;
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		return singleObj;
	}
	public String getDetailOfClass() {
		return "This is SingletonClass";
	}
	@Override
	public String toString() {
		return this.name;
	}
}
