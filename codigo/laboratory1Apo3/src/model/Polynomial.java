package model;
import repNumbers.ComplexNumber;
import repNumbers.CNumber;

/**
 * class Polynomial
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Polynomial {
	private int grade;
    private double[] constants;

    /**
     * constructor of Polynomial
     * @param grade - the grade of the polynomial
     * @param constants - the coefficients of the polynomial
     */
    public Polynomial(int grade, double ...constants){
        this.grade = grade;
        this.constants = constants;
    }

    /**
     * this method return the int grade 
     * @return grade - the variable grade
     */
    public int getGrade(){
        return grade;
    }
   

    /**
     * this method 
     * @param number
     * @return value - 
     */
    
    //SOLUCION NEWTON
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
    
    public String getRootsNewton() {
    	String roots = "";
    	Set<ComplexNumber> set = new HashSet<>();
        while (set.size() < grade){
            set.add(newtonComplexMethod());
        }
        for (ComplexNumber c: set ) {
            //System.out.println("x = " +c);
        	roots += "x = " + c +"\n";
        }
        return roots;
    	
    }

    
    //SOLUCION POR DIVISION SINTETICA
    
    public String getRoots(){
        String roots = "";
        int[] independent = exactDivisors(constants[0]);
        int[] majorTerm = exactDivisors(constants[constants.length-1]);
        for (int i = 0; i < independent.length; i++) {
            for (int j = 0; j < majorTerm.length; j++) {
                if (sinteticDivision((double)independent[i]/(double)majorTerm[j]) < 0.00000000001){
                    roots += "x = " + independent[i] + "/" + majorTerm[j]+"\n";
                }
            }
        }
        return roots;
    }
    
    private double sinteticDivision(double num){
        double temp = constants[constants.length-1];
        for (int i = constants.length-2; i >= 0; i--) {
            temp = num * temp + constants[i];
        }
        return temp;
    }

    public int[] exactDivisors(double num){
        String divisors = "";
        for (int i = -((int)num+1); i < num+1; i++) {
            if (num % i == 0){
                divisors +=i;
                if (i<num){
                    divisors+=",";
                }
            }
        }
        String[] divisorsCut = divisors.split(",");
        int[] divisorsReturn = new int[divisorsCut.length];
        for (int i = 0; i < divisorsCut.length; i++) {
            divisorsReturn[i] = Integer.parseInt(divisorsCut[i]);
        }
        return divisorsReturn;
    }
    
}
