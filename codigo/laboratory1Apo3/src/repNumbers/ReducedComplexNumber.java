package repNumbers;

import numbers.rational.RationalNumber;
import numbers.rational.ReducedRationalNumber;

public class ReducedComplexNumber implements ComplexNumber,Comparable<ComplexNumber>{

	private ReducedRationalNumber realPart;
	private ReducedRationalNumber imaginaryPart;

	public ReducedComplexNumber(int realPart, int imaginaryPart){
		this.realPart = new ReducedRationalNumber(realPart);
		this.imaginaryPart = new ReducedRationalNumber(imaginaryPart);
	}

	public ReducedComplexNumber(double realPart, double imaginaryPart){
		this.realPart = new ReducedRationalNumber(realPart);
		this.imaginaryPart = new ReducedRationalNumber(imaginaryPart);
	}

	public ReducedComplexNumber(RationalNumber realPart, RationalNumber imaginaryPart){
		this.realPart = new ReducedRationalNumber(realPart);
		this.imaginaryPart = new ReducedRationalNumber(imaginaryPart);
	}

	public ReducedComplexNumber(ReducedComplexNumber reducedComplexNumber) {
		realPart = reducedComplexNumber.realPart.copy();
		imaginaryPart = reducedComplexNumber.imaginaryPart.copy();
	}

	@Override
	public double module() {
		return Math.sqrt(Math.pow(realPart.doubleValue(),2) + Math.pow(imaginaryPart.doubleValue(),2));
	}

	@Override
	public ComplexNumber sum(RationalNumber otherNumber) {
		sum(new ReducedComplexNumber(otherNumber, new ReducedRationalNumber(0)));
		return this;
	}

	@Override
	public ComplexNumber sum(ComplexNumber otherNumber) {
		realPart.sum(otherNumber.getRealPart());
		imaginaryPart.sum(otherNumber.getImaginaryPart());
		return this;
	}

	@Override
	public ComplexNumber sum(int otherNumber) {
		sum(new ReducedComplexNumber(otherNumber,0));
		return this;
	}

	@Override
	public ComplexNumber sum(double otherNumber) {
		sum(new ReducedComplexNumber(otherNumber,0));
		return this;
	}

	@Override
	public ComplexNumber subtraction(RationalNumber otherNumber) {
		subtraction(new ReducedComplexNumber(otherNumber, new ReducedRationalNumber(0)));
		return this;
	}

	@Override
	public ComplexNumber subtraction(ComplexNumber otherNumber) {
		realPart.subtraction(otherNumber.getRealPart());
		imaginaryPart.subtraction(otherNumber.getImaginaryPart());
		return this;
	}

	@Override
	public ComplexNumber subtraction(int otherNumber) {
		subtraction(new ReducedComplexNumber(otherNumber,0));
		return this;
	}

	@Override
	public ComplexNumber subtraction(double otherNumber) {
		subtraction(new ReducedComplexNumber(otherNumber,0));
		return this;
	}

	@Override
	public ComplexNumber multiplication(RationalNumber number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number);
		ReducedRationalNumber d = new ReducedRationalNumber(0);

		return multiplication(a,b,c,d);
	}

	@Override
	public ComplexNumber multiplication(ComplexNumber number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number.getRealPart());
		ReducedRationalNumber d = new ReducedRationalNumber(number.getImaginaryPart());

		return multiplication(a,b,c,d);
	}

	@Override
	public ComplexNumber multiplication(int number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number);
		ReducedRationalNumber d = new ReducedRationalNumber(0);

		return multiplication(a,b,c,d);
	}

	@Override
	public ComplexNumber multiplication(double number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number);
		ReducedRationalNumber d = new ReducedRationalNumber(0);

		return multiplication(a,b,c,d);
	}

	private ComplexNumber multiplication(ReducedRationalNumber a, ReducedRationalNumber b, ReducedRationalNumber c, ReducedRationalNumber d) {
		realPart = new ReducedRationalNumber(
				ReducedRationalNumber.subtraction( ReducedRationalNumber.multiplication(a,c),
						ReducedRationalNumber.multiplication(b,d)));

		imaginaryPart = new ReducedRationalNumber(
				ReducedRationalNumber.sum(
						ReducedRationalNumber.multiplication(a,d),
						ReducedRationalNumber.multiplication(b,c)
						)
				);
		return this;
	}

	@Override
	public ComplexNumber divide(RationalNumber number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number);
		ReducedRationalNumber d = new ReducedRationalNumber(0);

		return divide(a,b,c,d);
	}

	@Override
	public ComplexNumber divide(int number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number);
		ReducedRationalNumber d = new ReducedRationalNumber(0);

		return divide(a,b,c,d);
	}

	@Override
	public ComplexNumber divide(double number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number);
		ReducedRationalNumber d = new ReducedRationalNumber(0);

		return divide(a,b,c,d);
	}

	@Override
	public ComplexNumber divide(ComplexNumber number) {
		ReducedRationalNumber a = realPart;
		ReducedRationalNumber b = imaginaryPart;
		ReducedRationalNumber c = new ReducedRationalNumber(number.getRealPart());
		ReducedRationalNumber d = new ReducedRationalNumber(number.getImaginaryPart());

		return divide(a,b,c,d);
	}

	private ComplexNumber divide(RationalNumber a, RationalNumber b, RationalNumber c, RationalNumber d){

		RationalNumber denominator = ReducedRationalNumber.sum(
				ReducedRationalNumber.multiplication(c,c),
				ReducedRationalNumber.multiplication(d,d));

		realPart = new ReducedRationalNumber(
				ReducedRationalNumber.sum(
						ReducedRationalNumber.multiplication(a,c),
						ReducedRationalNumber.multiplication(b,d)));
		realPart.divide(denominator);

		imaginaryPart = new ReducedRationalNumber(
				ReducedRationalNumber.subtraction(
						ReducedRationalNumber.multiplication(b,c),
						ReducedRationalNumber.multiplication(a,d)
						));
		imaginaryPart.divide(denominator);
		return this;
	}

	@Override
	public double getRealPart() {
		return realPart.toReal();
	}

	@Override
	public double getImaginaryPart() {
		return imaginaryPart.toReal();
	}

	@Override
	public String toString(){
		return realPart + (imaginaryPart.getNumerator()<0?" - (":" + (" )+ Math.abs(imaginaryPart.getNumerator())
		+ (imaginaryPart.getDenominator() == 1 ? "" : "/" + imaginaryPart.getDenominator()) + ")i";
	}

	@Override
	public int compareTo(ComplexNumber o) {
		if (o == null){
			return 1;
		}
		return (int) ((module() - module())*10);
	}

	@Override
	public ComplexNumber pow(int power) {
		if(power == 0) {
			return 	new ReducedComplexNumber(0,1);
		}else {
			ComplexNumber c = new ReducedComplexNumber(this);
			ComplexNumber p = new ReducedComplexNumber(this);
			for (int i = 1; i < power; i++) {
				c.multiplication(p);
			}
			return c;

		}
	}
}
