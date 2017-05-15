package com.nine.back.test;

public class test{
	 public test(){
		 System.out.println("test");
	 }
	 static{
		 System.out.println("test class");
	 }
	 
	
		 
		 public static void main(String[] args) {
		test a1=new test();
		System.out.println("-------------------");
		test a2=new B();
		System.out.println("-------------------");
		test a3=new C();
		}
	 }
	
	 class B extends test{
		 public B(){
			 System.out.println("B");
			 
		 }
		 static{
			 System.out.println("B class");
		 }
	 }
	 
	 class C extends B{
		 public C(){
			 System.out.println("C");
			 
		 }
	 }