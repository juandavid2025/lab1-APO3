package model;

import java.util.Random;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 * clase Calculator
 */


public class Calculator {

	private Polynomial polynomial;
	
	public Calculator() {
		
	}
	
	
	
	/**
	 * this method generate random coefficients in an random array size beetwen one to 10 grade 
	 * @return coefficients - the array of random grade with random coefficients
	 */
	public int[] generateRandomPolynomial() {
		
		Random random = new Random();
		
		int grade = 1 + random.nextInt(11);
		
		int[] coefficients = new int[grade];
		
		
		for(int i=0;i<coefficients.length;i++) {
			
			coefficients[i]=1+random.nextInt(Integer.MAX_VALUE);
			
		}
		
		
		return coefficients;
	}
	
	/*
	 * iThis method calculate the roots of a polynomial.
	 * 
	 * @param -function: is the polynomial to be evaluated.
	 * 
	 * @param -pZero: it is the initial point of approach to the root.
	 * 
	 * @pre: el String function It must not be empty.
	 * 
	 * @return the root of the polynomial.
	 **/

	public double newthon_Raphson(String function, double pZero) {
		DJep Function = new DJep();
		double raiz = 0;
		boolean cont = false;
		double dx = 0;
		double fx = 0;
		double p = 0;
		String derivative = "";

		Function.addStandardFunctions();
		Function.addStandardConstants();
		Function.addComplex();
		Function.setAllowUndeclared(true);
		Function.setAllowAssignment(true);
		Function.setImplicitMul(true);
		Function.addStandardDiffRules();

		try {

			// Derivadade la funcion
			Node node = Function.parse(function);
			Node diff = Function.differentiate(node, "x");
			Node sim = Function.simplify(diff);
			derivative = Function.toString(sim);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		while (cont == false) {

			try {
				// Solucion de la derivada
				Function.addVariable("x", pZero);
				Node x = Function.parse(derivative);
				Node f = Function.parse(function);

				if (Function.evaluate(f) != null) {
					fx = Double.valueOf(Function.evaluate(f).toString());
					dx = Double.valueOf(Function.evaluate(x).toString());
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			p = pZero - (fx / dx);
			double error = (p - pZero) / p;

			if (error <= 0.05) {
				raiz = p;
				cont = true;
			} else {
				pZero = p;
			}
		}

		return raiz;
	}

	
}
