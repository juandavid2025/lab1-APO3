package model;

import java.util.Random;

public class World {

	
	public World() {
		
	}
	
	
	public int[] generateRandomPolynomial() {
		
		Random random = new Random();
		
		int grade = 1 + random.nextInt(11);
		
		int[] coefficients = new int[grade];
		
		
		for(int i=0;i<coefficients.length;i++) {
			
			coefficients[i]=1+random.nextInt(100);
			
		}
		
		
		return coefficients;
	}
	
}
