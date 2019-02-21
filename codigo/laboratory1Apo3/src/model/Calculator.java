package model;

import java.util.Random;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.type.Complex;

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
	
	public void isComplex(String function, String[] function1, double pZero) {
		boolean complexB = false;
		int n = 0;
		int r = function1.length;
		for (int i = 0; i < function.length(); i++) {
			if (function.charAt(i) == 'i') {
				complexB = true;
				n++;
				r--;
			}
		}

		if (complexB == true) {
			newton_Raphson_complex(function1, pZero, n, r);
		} else {
			newton_Raphson(function, pZero);
		}		
	}
	
	/*
	 * This method calculate the roots of a polynomial with three figures of precision.
	 * 
	 * @param -function: is the polynomial to be evaluated.
	 * 
	 * @param -pZero: it is the initial point of approach to the root.
	 * 
	 * @pre: el String function It must not be empty.
	 * 
	 * @return the root of the polynomial.
	 **/

	public double newton_Raphson(String function, double pZero) {
		DJep Function = new DJep();
		double root = 0;
		boolean cont = false;
		double dx = 0;
		double fx = 0;
		double p = 0;
		String derivative = "";
		int iMax = 100;
		int n = 0;
		double Es = 0.5 - (int)(Math.pow(10, 3));

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

		while (cont == false && n < iMax ) {

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

			if (error <= Es) {
				root = p;
				cont = true;
			} else {
				pZero = p;
			}
			n++;
		}

		return root;
	}
	
	/*
	 * This method calculate the roots of a polynomial when it has complex numbers with three figures of precision.
	 * 
	 * @param -function: is the polynomial to be evaluated.
	 * 
	 * @param -pZero: it is the initial point of approach to the root.
	 * 
	 * @pre: el String function It must not be empty.
	 * 
	 * @return the root of the polynomial.
	 **/
	
	public double newton_Raphson_complex(String[] function1, double pZero, int n, int r) {
		double root = 0;
		Complex[] complexN = new Complex[n];
		String[] x = new String[n];
		String[] n_Complex = new String[n];
		String[] fxR = new String[r];
		int v = 0;
		Complex total = new Complex(0, 0);
		Complex totalD = new Complex(0, 0);
		int max = 250;
		boolean cont = true;
		double p = 0;
		double Es = 0.5 - (int) (Math.pow(10, 3));

		// este recorrido guarda los complejos en un arreglo
		for (int i = 0; i < function1.length; i++) {
			for (int j = 0; j < function1[i].length(); j++) {
				if (function1[i].charAt(j) == 'i') {
					n_Complex[v] = function1[i];
					v++;
				}
			}
		}

		// guarda los elemntos del arreglo function1 que no son complejos
		for (int i = 0; i < function1.length; i++) {
			for (int j = 0; j < n; j++) {
				if (function1[i].equals(n_Complex[j]) == false) {
					fxR[v] = function1[i];
				}
			}
		}

		// este recorrido guarda las x en un arreglo
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n_Complex[i].length(); j++) {
				if (n_Complex[i].charAt(j) == 'x') {
					x[i] = n_Complex[i].substring(j);
					n_Complex[i] = n_Complex[i].substring(1, j - 2);// con esto elimino los parentesis que estaran el
																	// posicion 0( y j-1)
				}
			}

			// los numeros complejos se escriben de la forma a+bi siempre con un mas
			double re, im = 0;
			n_Complex[i].substring(0, n_Complex[i].length() - 1);// se elimina la i de la cadena
			String[] c = n_Complex[i].split("\\+");
			re = Double.parseDouble(c[0]);
			im = Double.parseDouble(c[1]);
			complexN[i] = new Complex(re, im);// se agrega el numero imaginario al arreglo
		}

		// si la ultima posicion de las x's es null se pondra un 1 en esta
		if (x[n - 1] == " ") {
			x[n - 1] = "1";
		}

		DJep Function = new DJep();
		Function.addStandardFunctions();
		Function.addStandardConstants();
		Function.addComplex();
		Function.setAllowUndeclared(true);
		Function.setAllowAssignment(true);
		Function.setImplicitMul(true);
		Function.addStandardDiffRules();

		int y = 0;
		Complex[] dComplex = complexN.clone();
		while (cont == true && y <= max) {

			for (int i = 0; i < n; i++) {
				try {
					Node node = Function.parse(x[i]);
					Node diff = Function.differentiate(node, "x");
					Node sim = Function.simplify(diff);

					Function.addVariable("x", pZero);
					Node z = Function.parse(x[i]);

					if (Function.evaluate(z) != null) {
						double fx = Double.valueOf(Function.evaluate(z).toString());
						complexN[i] = complexN[i].mul(fx);
						//System.out.println(complexN[i]);
					}

					if (Function.evaluate(sim) != null) {

						double dx = Double.valueOf(Function.evaluate(sim).toString());
						
						if(dComplex[i] != null) {
							dComplex[i] = dComplex[i].mul(dx);
							
						}
						
						//System.out.println(dComplex[i]);
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				double t = complexN[i].re() + total.re();
				double s = complexN[i].im() + total.im();
				totalD.set(t, s);
			}

			double f = 0;
			double fd = 0;

			for (int i = 0; i < fxR.length; i++) {
				try {
					Function.addVariable("x", pZero);
					if(fxR[i] != null) {
						Node node = Function.parse(fxR[i]);
						Node diff = Function.differentiate(node, "x");
						Node sim = Function.simplify(diff);
						Node z = Function.parse(fxR[i]);
						double fx = Double.valueOf(Function.evaluate(z).toString());
						f += fx; // suma el resultado de la funcion	
						double dx = Double.valueOf(Function.evaluate(sim).toString());
						fd += dx;
					}
				
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			f += total.re(); // obtengo la solucion de la funcion en reales
			fd += totalD.re();// obtengo la solucion de la derivada en reales

			p = pZero - (f / fd);
			double error = (p - pZero) / p;
			System.out.println(p);

			if (error <= Es) {
				root = p;
				cont = false;
			} else {
				pZero = p;
				
			}
			y++;
			
		}

		return root;
	}

	
}
