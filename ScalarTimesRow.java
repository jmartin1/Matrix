package Matrix;
import Matrix.Matrix;
/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This class tests the scalarTimesRow method.
 * 
 */

public class ScalarTimesRow {
	public static void main(String[] args) {
            Matrix trixie = new Matrix (4,4); //create trixie
            
            for(int i=0; i<4; i++) { //for loop from 0 to 4 -- filling trixie
                    for(int j=0; j<4; j++) { //for loop from 0 to 4 -- filling trixie
                            if(i+j==2) //if sum of row number and column number equal 2
                                    trixie.setEntry(i, j, i+1); //set value in ith row and jth column of trixie to i+1
                            else //if sum of row number and column number does not equal 2
                                    trixie.setEntry(i, j, 0); //set value in ith row and jth column of trixie to 0
                    } //close for loop
            } //close for loop
            
            trixie.setEntry(3,3, 4); //set value in third row and third column of trixie to 4
            
            trixie.print(); //printing trixie
            
            System.out.println("\n"); //new line
            
            trixie.scalarTimesRow(1.5,2).print(); //printing the Matrix which results when row 3 of trixie is multiplied by 1.5
            
            System.out.println("\n"); //new line
            
            trixie.print(); //printing trixie again!
    } //close main
} //close class
