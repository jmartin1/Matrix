package Matrix;
import Matrix.Matrix;
/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This class tests the print method.
 * 
 */

public class Print {
	public static void main(String[] args) {
		Matrix Test = new Matrix(5,5); //create Test
		for(int i=0; i<5; i++) { //for loop from 0 to 5 -- filling up Test
			for(int j=0; j<5; j++) { //for loop from 0 to 5 -- filling up Test
				Test.setEntry(i,j, .1+5*i+j); //set value in ith row and jth position of Test to .1+5*i+j
			} //close for loop
		} //close for loop

		Test.print(); //print Test

	} //close main
} //close class
