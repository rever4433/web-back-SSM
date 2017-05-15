package com.nine.back.util;

import java.math.BigDecimal;

public class test2 {
	public static void main(String[] args) {
		for (BigDecimal a = new BigDecimal("0"); 
				a.compareTo(new BigDecimal("10")) != 1; 
				a = a.add(new BigDecimal("0.1"))) {
			for (BigDecimal b = new BigDecimal("0"); 
					b.compareTo(new BigDecimal("10")) != 1; 
					b = b.add(new BigDecimal("0.1"))) {
				for (BigDecimal c = new BigDecimal("0"); 
						c.compareTo(new BigDecimal("10")) != 1;
						c = c.add(new BigDecimal("0.1"))) {
					for (BigDecimal d = new BigDecimal("0"); 
							d.compareTo(new BigDecimal("10")) != 1; 
							d = d.add(new BigDecimal("0.1"))) {
						if ((a.add(b)).equals(new BigDecimal("9.0"))
								&& b.add(d).equals(new BigDecimal("10.0"))
								&& a.add(c).equals(new BigDecimal("10.0"))
								&& c.subtract(d).equals(new BigDecimal("6.0")) ) 
							System.out.println(a + "| " + b + " |  " + c + " | " + d);
					}
				}
			}
		}
		
	}
}
