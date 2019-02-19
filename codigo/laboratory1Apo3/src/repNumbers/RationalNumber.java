package repNumbers;

public interface RationalNumber {
	
	/**
	 * transform the rational number in an real number
	 * @return - the rational number like a double
	 */
	double toReal();
	
	/**
	 * sum the rational number whit other and return the result
	 * @param otherNumber - an rational number
	 */
	void sum(RationalNumber otherNumber);
	
	/**
	 * sum the rational number whit an Integer number and return the result
	 * @param otherNumber - an Integer number
	 */
	void sum(int otherNumber);
	
	/**
	 * sum the rational number whit an Double number and return the result
	 * @param otherNumber - an Double number
	 */
	void sum(double otherNumber);
	
	/**
	 * subtract number from this
	 * @param number
	 */
	void subtraction(RationalNumber number);
	
	/**
	 * subtract number from this
	 * @param number
	 */
	void subtraction(int number);
	
	/**
	 * subtract number from this
	 * @param number
	 */
	void subtraction(double number);
	
	/**
	 * multiplication of this by other number
	 * @param number
	 */
	void multiplication(RationalNumber number);
	
	/**
	 * multiplication of this by other number
	 * @param number
	 */
	void multiplication(int number);
	
	/**
	 * multiplication of this by other number
	 * @param number
	 */
	void multiplication(double number);
	
	/**
	 * divide this by other number
	 * @param number
	 */
	void divide(RationalNumber number);
	
	/**
	 * divide this by other number
	 * @param number
	 */
	void divide(int number);
	
	/**
	 * divide this by other number
	 * @param number
	 */
	void divide(double number);
	
	/**
	 * 
	 * Return the numerator of the rational number
	 * @return
	 */
	int getNumerator();
	
	/**
	 * Return the denominator of the rational number
	 * @return
	 */
	int getDenominator();
	

}
