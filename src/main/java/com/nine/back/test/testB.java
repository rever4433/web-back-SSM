package com.nine.back.test;

public class testB {
	static int var=666;
	static int getVar(){
		return var;
	}
	public static void main(String[] args) {
		stu s1=new stu("aac", 20, 33);
		System.out.println(s1.name+"  "+s1.age+" "+s1.score);
	}
}
class stu{
	String name;
	int age;
	int score=80;
	stu(String a,int b,int c){
		name=a;
		age=c;
		score=b;
	}
}
