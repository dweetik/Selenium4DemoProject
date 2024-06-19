package org.qa.demo.javaprograms;

public class TestClass {

	
	
	public static void main(String[] args) {
		
		int[] num = {1, 5, 3, 9, 7};
		int max=num[0];
		int smax=num[0];
		for(int i=0;i<num.length;i++) {
			if(num[i]>max) {
				smax=max;
				max=num[i];
			
			}
			else if(num[i]>smax && num[i]!=max) {
				smax=num[i];
			}
		}
		
		System.out.println("Second Max is"+smax);
				}
		
	}	

	


