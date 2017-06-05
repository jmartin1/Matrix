package Matrix;
import Matrix.Matrix;
/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This class tests the times method.
 * 
 */

public class Times {

	public static void main(String[] args) {

		Matrix trixie  = new Matrix(3,4); //The matrix on the left

		Matrix alice = new Matrix(4, 5); //The matrix on the right

		for(int i=0; i<3; i++) { //for loop from 0 to 3 -- filling the left matrix
			for(int j=0; j<4; j++) { //for loop from 0 to 4 -- filling the left matrix
				trixie.setEntry(i,j, i+j); //set value in the ith row and jth column of trixie to i+j
			} //close for loop
		} //close for loop

		for(int i=0; i<4; i++) { //for loop from 0 to 4 -- filling the right matrix
			for(int j=0; j<5; j++) { //for loop from 0 to 5 -- filling the right matrix
				alice.setEntry(i,j, i-j); //set value in the ith row and jth column of alice to i-j
			} //close for loop
		} //close for loop

		trixie.times(alice).print(); //The product of the two matrices

	} //close main

} //close class
