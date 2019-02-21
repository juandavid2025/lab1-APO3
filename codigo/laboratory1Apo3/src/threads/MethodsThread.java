/**
 * 
 */
package threads;

import controller.MainWindowViewController;
import model.Polynomial;

/**
 * @author HP
 *
 */
public class MethodsThread extends Thread{

	private int method;
	private Polynomial polynomial;
	private MainWindowViewController controller;
	
	public MethodsThread(int method,Polynomial polynomial,MainWindowViewController controller) {
		this.method=method;
		this.polynomial=polynomial;
		this.controller=controller;
	}
	
	public void run() {
		System.out.println("llegue al hilo");
	if(method==1) {
	
	controller.setTextArea(polynomial.getRootsNewton());
	
	}else {
		
		controller.setTextArea(polynomial.getRoots());
		
	   }	
	
	}
	
}
