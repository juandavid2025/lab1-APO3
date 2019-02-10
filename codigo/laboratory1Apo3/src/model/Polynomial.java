package model;
import numbers.imaginary.CNumber;
import numbers.imaginary.ComplexNumber;

import java.util.Arrays;
public class Polynomial {
	private int grade;
    private double[] constants;

    public Polynomial(int grade, double ...constants){
        this.grade = grade;
        this.constants = constants;
    }

    public int getGrade(){
        return grade;
    }

    public double realEvaluation(double number){
        double value = 0;
        for (int i = 0; i < constants.length; i++) {
            value += constants[i] * Math.pow(number,i);
        }
        return value;
    }

    public ComplexNumber complexEvaluation(ComplexNumber number){
        ComplexNumber value = new CNumber(0,0);
        for (int i = 0; i < constants.length;i++){
            value.sum(number.pow(i).multiplication(constants[i]));
        }
        return value;
    }

    public ComplexNumber complexDerivatedEvaluation(ComplexNumber number){
        ComplexNumber value = new CNumber(0,0);
        for (int i = 1; i < constants.length;i++){
            value.sum(number.pow(i-1).multiplication(constants[i]*i));
        }
        return value;
    }

    public double RealDerivatedEvaluation(double number){
        double value = 0;
        for (int i = 1; i < constants.length;i++){
            value += (Math.pow(number,i-1) * constants[i]*i);
        }
        return value;
    }

    public ComplexNumber newtonComplexMethod(){
        ComplexNumber root = new CNumber(Math.random()*10000,Math.random()*10000);
        for (int i = 0; i < 70; i++) {
            root = root.subtraction(complexEvaluation(root).divide(complexDerivatedEvaluation(root)));
        }
        return root;
    }

    public Polynomial multiplication(Polynomial p){
        double[] newPolynomial = new double[grade + p.grade + 1];
        for(int i = 0; i < p.constants.length;i++){
            for (int j = 0; j < constants.length; j++) {
                newPolynomial[i+j] += p.constants[i] * constants[j];
            }
        }
        return new Polynomial(grade + p.grade, newPolynomial);
    }

    private int determinateGrade(double[] polynomial){
        int i;
        for (i = polynomial.length - 1; i >= 0 ; i++) {
            if (polynomial[i] != 0)
                break;
        }
        return i;
    }

    public Polynomial substraction(Polynomial p){
        int size = Math.min(grade,p.grade)+1;
        double[] newPolynomial = p.grade > grade? p.constants.clone(): constants.clone();
        int i;
        for (i = 0; i < size; i++) {
            newPolynomial[i] = constants[i] - p.constants[i];
        }
        int newGrade = determinateGrade(newPolynomial);
        return new Polynomial(newGrade, Arrays.copyOfRange(newPolynomial,0,newGrade+1));
    }

    @Override
    public String toString() {
        String polynomial = "";
        for (int i = grade; i > 0; i--) {
            if(constants[i] != 0)
                polynomial += (Math.abs(constants[i]) != 1?(Math.floor(constants[i]*1000)/1000):"") + " X^" + i + " " + (constants[i-1]<=0? (constants[i-1] == -1?" - ":""):" + ");
        }
        polynomial += (Math.floor(constants[0]*1000)/1000);
        return polynomial;
    }

    public static void main(String ...args){
        Polynomial p1 = new Polynomial(2,3,0,1);
        Polynomial p2 = new Polynomial(1,-3,1);
        Polynomial p3 = new Polynomial(1,3,1);
        System.out.println("("+ p1 + ") * (" + p2 + ") - (" + p3 + ") = " + p1.multiplication(p2).substraction(p3));
        System.out.println(p1.multiplication(p2).newtonComplexMethod());
    }
}
