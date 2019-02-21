package repNumbers;


public interface ComplexNumber {

    /**
     * Return the module of an Complex Number
     * @return the module of an Complex
     */
    double module();

    /**
     * sum the complex number whit other
     * @param otherNumber - an rational number
     */
    ComplexNumber sum(RationalNumber otherNumber);

    /**
     * sum the complex number whit other
     * @param otherNumber
     */
    ComplexNumber sum(ComplexNumber otherNumber);

    /**
     * sum the complex number whit an Integer number
     * @param otherNumber - an Integer number
     */
    ComplexNumber sum(int otherNumber);

    /**
     * sum the complex number whit an Double number
     * @param otherNumber - an Double number
     */
    ComplexNumber sum(double otherNumber);

    /**
     * subtract number from this
     * @param number
     */
    ComplexNumber subtraction(RationalNumber number);

    /**
     * subtract number from this
     * @param number
     */
    ComplexNumber subtraction(ComplexNumber number);

    /**
     * subtract number from this
     * @param number
     */
    ComplexNumber subtraction(int number);

    /**
     * subtract number from this
     * @param number
     */
    ComplexNumber subtraction(double number);

    /**
     * multiplication of this by other number
     * @param number
     */
    ComplexNumber multiplication(RationalNumber number);

    /**
     * multiplication of this by other number
     * @param number
     */
    ComplexNumber multiplication(ComplexNumber number);

    /**
     * multiplication of this by other number
     * @param number
     */
    ComplexNumber multiplication(int number);

    /**
     * multiplication of this by other number
     * @param number
     */
    ComplexNumber multiplication(double number);

    /**
     * divide this by other number
     * @param number
     */
    ComplexNumber divide(RationalNumber number);

    /**
     * divide this by other number
     * @param number
     */
    ComplexNumber divide(int number);

    /**
     * divide this by other number
     * @param number
     */
    ComplexNumber divide(double number);

    /**
     * divide this by other number
     * @param number
     */
    ComplexNumber divide(ComplexNumber number);

    /**
     * return the real part of the complex
     * @return
     */
    double getRealPart();

    /**
     * Return the imaginary part of the complex
     * @return
     */
    double getImaginaryPart();
    
    /**
     * Return the Complex number power to the n power
     * @param power
     * @return
     */
    ComplexNumber pow(int power);

}
