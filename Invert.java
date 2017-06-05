package Matrix;
import Matrix.Matrix;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This class tests the invert method.
 * 
 */

public class Invert {
	public static void main(String[] args) {
		Matrix matt = new Matrix (3,3); //create matt; matt is invertible
		int counter = 0; //set counter to 0
		for(int i=0; i<3; i++) {//for loop from 0 to 3 -- filling matt			
			for(int j=0; j<3; j++) {//for loop from 0 to 3 --filling matt
				counter++; //increment counter by 1
				matt.setEntry(i, j, counter); //set the value in the ith row and jth column of matt to counter
			} //close for loop
		} //close for loop

		matt.setEntry(2, 2, 10); //set the value in the second row and second column of matt to 10
		matt.print(); //printing matt
		System.out.println("\n"); //new line
		matt.invert().print(); //printing the inverse of matt
		System.out.println("\n"); //new line
		matt.times(matt.invert()).print(); //printing the product of matt and his inverse
		System.out.println("\n"); //new line

		Matrix trixie = new Matrix (4,4); //create trixie; trixie is invertible
		for(int i=0; i<4; i++) { //for loop from 0 to 4 -- filling trixie
			for(int j=0; j<4; j++) { //for loop from 0 to 4 -- filling trixie
				if(i+j==2) //if sum of row number and column number equal 2
					trixie.setEntry(i, j, i+1); //set value in ith row and jth column of trixie to i+1
				else //if sum of row number and column number does not equal 2
					trixie.setEntry(i, j, 0); //set value in ith row and jth column of trixie to 0
			} //close for loop
		} //close for loop

		trixie.setEntry(3, 3, 4); //set value in third row and third column of trixie to 4
		trixie.print(); //printing trixie
		System.out.println("\n"); //new line
		trixie.invert().print(); //printing the inverse of trixie
		System.out.println("\n"); //new line
		trixie.times(trixie.invert()).print(); //printing the product of trixie and her inverse
	} //close main
} //close class

