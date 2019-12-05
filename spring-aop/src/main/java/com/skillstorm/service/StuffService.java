package com.skillstorm.service;

import org.springframework.stereotype.Service;

@Service
public class StuffService {
	public void stuff() {
		System.out.println("stuff()");
	}
	public void doSomething() {
		System.out.println("doSomething()");
	}
	public String doSomething(int x, String str) {
		System.out.println("doSomething(int x, String str)");
		return str + x;
	}
	public int doSomething(int x) {
		System.out.println("doSomething(int x)");
		return x;
	}
	public void doSomethingElse() {
		System.out.println("doSomethingElse()");
	}
	public void doWork() {
		System.out.println("doWork()");
	}
}
