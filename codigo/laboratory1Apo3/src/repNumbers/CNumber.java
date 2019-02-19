package repNumbers;

import numbers.rational.RationalNumber;

public class CNumber implements ComplexNumber, Comparable<ComplexNumber> {

	/**
	 * Real part of the Complex number
	 */
	private double realPart;

	/**
	 * imaginary part of the number
	 */
	private double imaginaryPart;
	
	public CNumber(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public CNumber(ComplexNumber number) {
		realPart = number.getRealPart();
		imaginaryPart = number.getImaginaryPart();
	}

	@Override
	public double module() {
		return Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2));
	}

	@Override
	public ComplexNumber sum(RationalNumber otherNumber) {
		realPart += otherNumber.toReal();
		return this;
	}

	@Override
	public ComplexNumber sum(ComplexNumber otherNumber) {
		realPart += otherNumber.getRealPart();
		imaginaryPart += otherNumber.getImaginaryPart();
		return this;
	}

	@Override
	public ComplexNumber sum(int otherNumber) {
		realPart += otherNumber;
		return this;
	}

	@Override
	public ComplexNumber sum(double otherNumber) {
		realPart += otherNumber;
		return this;
	}

	@Override
	public ComplexNumber subtraction(RationalNumber number) {
		realPart -= number.toReal();
		return this;
	}

	@Override
	public ComplexNumber subtraction(ComplexNumber number) {
		realPart -= number.getRealPart();
		imaginaryPart -= number.getImaginaryPart();
		return this;
	}

	@Override
	public ComplexNumber subtraction(int number) {
		realPart -= number;
		return this;
	}

	@Override
	public ComplexNumber subtraction(double number) {
		realPart -= number;
		return this;
	}

	@Override
	public ComplexNumber multiplication(RationalNumber number) {
		multiplication(number.toReal());
		return this;
	}

	@Override
	public ComplexNumber multiplication(ComplexNumber number) {
		// rp = real part
		// ip = imaginary part
		// (rp1 + ip1) * (rp2 + ip2) = (rp1 * rp2 - ip1 * ip2) + (rp1 * ip2 + ip1 * rp2)i
		double rp = realPart * number.getRealPart() - imaginaryPart * number.getImaginaryPart();
		double ip = realPart * number.getImaginaryPart() + imaginaryPart * number.getRealPart();
		realPart = rp;
		imaginaryPart = ip;
		return this;
	}

	@Override
	public ComplexNumber multiplication(int number) {
		double rp = realPart * number - imaginaryPart * 0;
		double ip = realPart * 0 + imaginaryPart * number;
		realPart = rp;
		imaginaryPart = ip;
		return this;
	}

	@Override
	public ComplexNumber multiplication(double number) {
		// rp = real part
		// ip = imaginary part
		// (rp1 + ip1) * (rp2 + ip2) = (rp1 * rp2 - ip1 * ip2) + (rp1 * ip2 + ip1 * rp2)i
		double rp = realPart * number - imaginaryPart * 0;
		double ip = realPart * 0 + imaginaryPart * number;
		realPart = rp;
		imaginaryPart = ip;
		return this;
	}

	@Override
	public ComplexNumber divide(RationalNumber number) {
		return divide(number.toReal());
	}

	@Override
	public ComplexNumber divide(int number) {
		double a,b,c,d;
		a = realPart;
		b = imaginaryPart;
		c = number;
		d = 0;
		realPart = (a*c + b*d) / (c*c + d*d);
		imaginaryPart = (b*c - a*d) / (c*c + d*d);
		return this;
	}

	@Override
	public ComplexNumber divide(double number) {
		double a,b,c,d;
		a = realPart;
		b = imaginaryPart;
		c = number;
		d = 0;
		realPart = (a*c + b*d) / (c*c + d*d);
		imaginaryPart = (b*c - a*d) / (c*c + d*d);
		return this;
	}

	@Override
	public ComplexNumber divide(ComplexNumber number) {
		double a,b,c,d;
		a = realPart;
		b = imaginaryPart;
		c = number.getRealPart();
		d = number.getImaginaryPart();
		realPart = (a*c + b*d) / (c*c + d*d);
		imaginaryPart = (b*c - a*d) / (c*c + d*d);
		return this;
	}

	@Override
	public double getRealPart() {
		return realPart;
	}

	@Override
	public double getImaginaryPart() {
		return imaginaryPart;
	}

	@Override
	public ComplexNumber pow(int power) {
		if (power == 0) {
			return new CNumber(1,0);
		}
		ComplexNumber a = new CNumber(this);
		for (int i = 1; i < power; i++) {
			a.multiplication(this);
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(new CNumber(0,2).pow(-1));
	}

	@Override
	public int compareTo(ComplexNumber o) {
		if (o == null) {
			return 1;
		}
		return (int) Math.round(module() - o.module());
	}

	@Override
	public String toString() {
		String realPart = String.valueOf( this.realPart );
		String imaginaryPart = this.imaginaryPart < 0? " " + this.imaginaryPart + "i": " + " + this.imaginaryPart + "i";
		imaginaryPart = this.imaginaryPart == 0? "":imaginaryPart;
		realPart = this.realPart == 0? "0": realPart;
		return realPart + imaginaryPart;
	}
	
}
