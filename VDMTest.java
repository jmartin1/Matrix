package Matrix;

import polyfun.Polynomial;
/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This class tests the methods within the VDM class, namely slopeAtPoint and slopeFunction.
 * 
 */
public class VDMTest {
	public static void main(String[] args) { //main
		VDM vdm = new VDM(); //creating an instance of VDM
		Polynomial poly = new Polynomial(new double[] {0,3,1,1}); //create new polynomial x^3 + x^2 + 3x
		
		System.out.println("m = " + vdm.slopeAtPoint(poly, 3)); //print m
		vdm.slopeFunction(poly); //graph the derivative
		
    } //close main
} //close class
