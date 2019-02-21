package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Calculator;

class CalculatorTest {

	Calculator calculator;
	String polynomial10;
	String polynomial9;
	String polynomial8;
	String polynomial7;
	String polynomial6;
	String polynomial5;
	String polynomial4;
	String polynomial3;
	String polynomial2;
	String polynomial1;
	String polynomial0;
	
	
	@Test
	void scenario1() {
		calculator = new Calculator();
		polynomial10="10x^10+9x^9+8x^8+7x^7+6x^6+5x^5+4x^4+3x^3+2x^2+x+10";
		polynomial9="9x^9+8x^8+7x^7+6x^6+5x^5+4x^4+3x^3+2x^2+x+10";
		polynomial8="8x^8+7x^7+6x^6+5x^5+4x^4+3x^3+2x^2+x+10";
		polynomial7="7x^7+6x^6+5x^5+4x^4+3x^3+2x^2+x+10";
		polynomial6="6x^6+5x^5+4x^4+3x^3+2x^2+x+10";
		polynomial5="5x^5+4x^4+3x^3+2x^2+x+10";
		polynomial4="4x^4+3x^3+2x^2+x+10";
		polynomial3="3x^3+2x^2+x+10";
		polynomial2="2x^2+x+10";
		polynomial1="x+10";
		polynomial0="10";
	}

	
	
}
