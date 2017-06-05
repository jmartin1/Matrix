package Matrix;
import org.opensourcephysics.display.Trail;
import org.opensourcephysics.frames.PlotFrame;
import java.awt.BasicStroke;
import java.awt.Color;

import polyfun.Polynomial;
/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: The VDM class contains the methods to calculate and graph the derivative (slope function) of a polynomial, namely the slopeAtPoint and slopeFunction methods, respectively. The slopeAtPoint method specifically splits the polynomial into (x-a)^2 and some Q(x), expands the polynomial, sums the coefficients of the terms of the same degree, enters each sum into the matrix (later factoring in m and b), and then uses the rowreduce method to solve for m. The slopeFunction method specifically graphs m.  
 * 
 * @method slopeAtPoint
 * 		Calculates the slope of the line tangent to the graph of the given polynomial at the given point, given a polynomial and an x-coordinate.
 * @method slopeFunction
 * 		Plots the derivative of a given polynomial.
 */

public class VDM { 
	/**
	 * Calculates the slope of the line tangent to the graph of the given polynomial at the given point, given a polynomial and an x-coordinate.
	 * 
	 * @param poly
	 * 		Polynomial used to calculate the slope at an x-coordinate.  
	 * @param x
	 * 		X-coordinate to calculate slope at.
	 * @return m
	 * 		Slope of the line tangent to the graph of the given polynomial at the given point.
	 */
	public double slopeAtPoint (Polynomial poly, double x){ 
		int q_degree = poly.getDegree() - 2; //degree of Q(x), in order to split poly into (x-a)^2 Q(x)
		Polynomial p_x = new Polynomial(new double[] {Math.pow(x,2),-2*x, 1}); //create P(x) = (x-a)^2, in order to split poly into (x-a)^2 Q(x)
		int[] q_degs = new int[q_degree+1]; //create array that has a length of degree of Q(x) plus one, which will later be used to fill VDM matrix
		int[] p_degs = new int[p_x.getDegree()+1]; //create an array that his a length of degree of P(x) + 1 (i.e. has a length of three), which will later be used to fill VDM matrix
		
		for (int i = 0; i < q_degs.length; i++) {  //for loop from 0 to the degree of Q(x)
			q_degs[i] = q_degree-i; //creates array that contains every integral value 0 to the degree of P(x) in decreasing order
		} //close for loop
		for (int i = 0; i < q_degs.length; i++) { //for loop from 0 to the degree of Q(x)
			p_degs[i] = p_x.getDegree()-i; //creates array that contains every integral value 0 to the degree of P(x) in decreasing order
		} //close for loop
		
		double [][] arraymatrix = new double[poly.getDegree()+ 1][poly.getDegree()+2]; //create double array arraymatrix
		Matrix vdmmatrix = new Matrix (arraymatrix.length, arraymatrix[0].length); //create vdmmatrix
		for(int i = 0; i <= poly.getDegree(); i++){ //for loop from 0 to the degree of polynomial poly
			for (int j = 0; j < p_degs.length; j++) { //for loop from 0 the degree of polynomial P(x)
				for (int k = 0; k < q_degs.length; k ++) { //for loop through 0 the degree of polynomial Q(x)
					if (p_degs[j] + q_degs[k] == i) {//assembles the coefficients of terms of like degrees into matrix if the terms add to the proper degree
						double coefficient = p_x.getCoefficient(p_degs[j]).getTerms()[0].getTermDouble(); //find coefficient
						arraymatrix[i][q_degs[k]+2] = arraymatrix[i][q_degs[k]+2] + coefficient; //add coefficient to arraymatrix when the degree of the terms add to the right degree
					} //close if
				} //close for
			} //close for
		} //close for
		for (int i = 0; i < arraymatrix.length; i++){ //for loop from 0 to the length of the arraymatrix
			arraymatrix[i][arraymatrix.length] = poly.getCoefficients()[i].getTerms()[0].getTermDouble(); //adds constants to matrix
		} //close for
		arraymatrix[0][0] = arraymatrix[0][0] + 1; //adding b
		arraymatrix[1][1] = arraymatrix[1][1] + 1; //adding m
		vdmmatrix.m = arraymatrix; //turns double array arraymatrix into a matrix
		vdmmatrix = vdmmatrix.rowreduce(); //row reduce matrix
		return vdmmatrix.m[1][vdmmatrix.m[0].length-1]; //return m, the slope
	} //close slopeAtPoint

	/**
	 * Plots the derivative of a given polynomial.
	 * 
	 * @param poly
	 * 		The polynomial to graph the slope function of. 
	 */
	public void slopeFunction (Polynomial poly) {
		PlotFrame frame = new PlotFrame("x", "y", "Derivative Graph"); //create new frame
		Trail trail = new Trail(); //create new trail
		for (double i = -20; i < 20; i += .1) { //for loop from -20 to 20
			double m = this.slopeAtPoint(poly, i); //set double m to the slope of poly at i
			trail.addPoint(i, m); //add point to trail
			frame.addDrawable(trail); //adds trail to frame
		} //close for
		frame.setPreferredMinMax(-50, 50, -5, 105);
		frame.setVisible(true); //make window appear on screen
	} //close slopeFunction
} //close class

