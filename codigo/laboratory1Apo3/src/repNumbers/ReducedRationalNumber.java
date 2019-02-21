package repNumbers;

public class ReducedRationalNumber extends Number implements RationalNumber, Comparable<RationalNumber> {

	/**
	 * serial Version UID
	 */
	private static final long serialVersionUID = 7950423865167924360L;
	
	private static final int CERTAIN = 8;
	
	/**
	 * the numerator of the rational number
	 */
	private int numerator;
	/**
	 * the denominator of the rational number always is positive
	 */
	private int denominator;
	
	public ReducedRationalNumber(double num) {
		double div = Math.pow(10, CERTAIN);
		denominator = (int) div ;
		numerator = (int) (num*div);
		
		int MCD = MCD_Euclides(numerator, denominator);
		
		numerator = numerator/MCD;
		denominator = denominator/MCD;
	}

	public ReducedRationalNumber(RationalNumber num){
		numerator = num.getNumerator();
		denominator = num.getDenominator();

		if(!(num instanceof ReducedRationalNumber)){
			int MCD = MCD_Euclides(numerator, denominator);
			numerator = numerator/MCD;
			denominator = denominator/MCD;
		}
	}
	
	public ReducedRationalNumber(int num) {
		numerator = num;
		denominator = 1;
	}
	
	public ReducedRationalNumber(int numerator, int denominator) {
		
		if (numerator < 0  && denominator < 0) {
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		}else if(numerator < 0  || denominator < 0) {
			numerator = -Math.abs(numerator);
			denominator = Math.abs(denominator);
		}
		
		int MCD = MCD_Euclides(numerator, denominator);
		
		this.numerator = numerator/MCD;
		this.denominator = denominator/MCD;
	}
	
	private int MCD_Euclides(int a, int b){
		a = Math.abs(a);
		b = Math.abs(b);
	    while(b != 0){
	         int t = b;
	         b = a % b;
	         a = t;
	    }
	    return a;
	}

	@Override
	public double toReal() {
		return (double)numerator/(double)denominator;
	}

	/**
	 * sum two rational numbers and return the result
	 * @param num1 - an rational number
	 * @param num2 - an rational number	
	 * @return - the sum of two specific rational numbers
	 */
	public static RationalNumber sum(RationalNumber num1, RationalNumber num2) {
		return new ReducedRationalNumber(
				num1.getNumerator() * num2.getDenominator() + num2.getNumerator() * num1.getDenominator()
				, num1.getDenominator()*num2.getDenominator());
	}

	/**
	 * sum one rational number whit an integer rational numbers and return the result
	 * @param num1 - an integer number
	 * @param num2 - an rational number	
	 * @return - the sum of two specific rational numbers
	 */
	public static RationalNumber sum(int num1, RationalNumber num2) {
		return sum(new ReducedRationalNumber(num1), num2);
	}

	/**
	 * subtract num2 from num1
	 * @param num1 - an rational number
	 * @param num2 - an rational number
	 * @return the rational that result of subtract num2 from num1
	 */
	public static RationalNumber subtraction(RationalNumber num1, RationalNumber num2) {
		return new ReducedRationalNumber(
				num1.getNumerator() * num2.getDenominator() - num2.getNumerator() * num1.getDenominator()
				, num1.getDenominator()*num2.getDenominator());
	}

	/**
	 * subtract num2 from num1
	 * @param num1 - an integer number
	 * @param num2 - an rational number
	 * @return the rational that result of subtract num2 from num1
	 */
	public static RationalNumber subtraction(int num1, RationalNumber num2) {
		return subtraction(new ReducedRationalNumber(num1), num2);
	}

	/**
	 * subtract num2 from num1
	 * @param num2 - an integer number
	 * @param num1 - an rational number
	 * @return the rational that result of subtract num2 from num1
	 */
	public static RationalNumber subtraction(RationalNumber num1, int num2) {
		return subtraction(num1, new ReducedRationalNumber(num2));
	}

	/**
	 * multiplication between two rational numbers and return the result
	 * @param num1 - an rational number
	 * @param num2 - an rational number	
	 * @return - the multiplication of two specific rational numbers
	 */
	public static RationalNumber multiplication(RationalNumber num1, RationalNumber num2) {
		return new ReducedRationalNumber(
				num1.getNumerator() * num2.getNumerator(), 
				num1.getDenominator() * num2.getDenominator());
	}

	/**
	 * multiplication between one rational number whit an integer rational numbers and return the result
	 * @param num1 - an integer number
	 * @param num2 - an rational number	
	 * @return - the multiplication of two specific rational numbers
	 */
	public static RationalNumber multiplication(int num1, RationalNumber num2) {
		return multiplication(new ReducedRationalNumber(num1), num2);
	}

	/**
	 * num1 divided num2
	 * @param num1 - an rational number
	 * @param num2 - an rational number
	 * @return the rational that result of num1 divided num2
	 */
	public static RationalNumber division(RationalNumber num1, RationalNumber num2) {
		return new ReducedRationalNumber(
				num1.getNumerator() * num2.getDenominator(), 
				num1.getDenominator() * num2.getNumerator());
	}

	/**
	 * num1 divided num2
	 * @param num1 - an integer number
	 * @param num2 - an rational number
	 * @return the rational that result of num1 divided num2
	 */
	public static RationalNumber division(int num1, RationalNumber num2) {
		return division(new ReducedRationalNumber(num1), num2);
	}

	/**
	 * num1 divided num2
	 * @param num2 - an integer number
	 * @param num1 - an rational number
	 * @return the rational that result of num1 divided num2
	 */
	public static RationalNumber division(RationalNumber num1, int num2) {
		return division(num1, new ReducedRationalNumber(num2));
	}

	@Override
	public int getNumerator() {
		return numerator;
	}

	@Override
	public int getDenominator() {
		return denominator;
	}

	@Override
	public double doubleValue() {
		return (double)numerator/(double)denominator;
	}

	@Override
	public float floatValue() {
		return (float)numerator/(float)denominator;
	}

	@Override
	public int intValue() {
		return Math.round(floatValue());
	}

	@Override
	public long longValue() {
		return Math.round(doubleValue());
	}

	@Override
	public int compareTo(RationalNumber num2) {
		int num = 0;
		if (toReal() > num2.toReal()) {
			num = 1;
		}else if (toReal() < num2.toReal()) {
			num = -1;
		}
		return num;
	}

	@Override
	public void sum(RationalNumber otherNumber) {
		numerator = numerator * otherNumber.getDenominator() + otherNumber.getNumerator() * denominator;
		denominator = denominator * otherNumber.getDenominator();
		int MCD = MCD_Euclides(numerator, denominator);
		numerator /=MCD;
		denominator /=MCD;
	}

	@Override
	public void sum(int otherNumber) {
		sum(new ReducedRationalNumber(otherNumber));
	}

	@Override
	public void subtraction(RationalNumber number) {
		numerator = numerator * number.getDenominator() - number.getNumerator() * denominator;
		denominator = denominator * number.getDenominator();
		int MCD = MCD_Euclides(numerator, denominator);
		numerator /=MCD;
		denominator /=MCD;
	}

	@Override
	public void subtraction(int number) {
		subtraction(new ReducedRationalNumber(number));
	}

	@Override
	public void sum(double otherNumber) {
		sum(new ReducedRationalNumber(otherNumber));
	}

	@Override
	public void subtraction(double number) {
		subtraction(new ReducedRationalNumber(number));
	}

	@Override
	public void multiplication(RationalNumber number) {
		numerator *= number.getNumerator();
		denominator *= number.getDenominator();
		int MCD = MCD_Euclides(numerator, denominator);
		numerator /=MCD;
		denominator /=MCD;
	}

	@Override
	public void multiplication(int number) {
		multiplication(new ReducedRationalNumber(number));
	}

	@Override
	public void multiplication(double number) {
		multiplication(new ReducedRationalNumber(number));
	}

	@Override
	public void divide(RationalNumber number) {
		numerator *= number.getDenominator();
		denominator *= number.getNumerator();
		int MCD = MCD_Euclides(numerator, denominator);
		numerator /=MCD;
		denominator /=MCD;
	}

	@Override
	public void divide(int number) {
		divide(new ReducedRationalNumber(number));
	}

	@Override
	public void divide(double number) {
		divide(new ReducedRationalNumber(number));
	}
	
	@Override
	public String toString() {
		return denominator != 1? numerator+"/"+denominator : numerator + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null){
			return false;
		}
		boolean equals = false;
		if (obj instanceof RationalNumber) {
			RationalNumber o = (RationalNumber) obj;
			ReducedRationalNumber a = new ReducedRationalNumber(o.getNumerator(), o.getDenominator());
			equals = numerator == a.getNumerator() && denominator == a.getDenominator();
		}
		return equals;
	}
	
	public static void main(String[] args) {
		ReducedRationalNumber a = new ReducedRationalNumber(8,3);
		ReducedRationalNumber b = new ReducedRationalNumber(3, 5);
		a.sum(b);
		System.out.println(a.toReal());
	}

	public ReducedRationalNumber copy() {
		return new ReducedRationalNumber(this);
	}

}
