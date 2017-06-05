package Matrix;
import Matrix.Matrix;
/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This class tests the row reduce method.
 * 
 */

public class RowReduce {
	public static void main(String[] args) {
            Matrix alice = new Matrix (3,5); //create alice
            for(int i=0; i<3; i++) { //for loop from 0 to 3 -- filling up alice
                    for(int j=0; j<5; j++) { //for loop from 0 to 5 -- filling up alice
                            if(i+j==2) //if sum of row number and column number equal 2
                                    alice.setEntry(i, j, i+1); //set value in ith row and jth column of alice to i+1
                            else if(i+j==4) //if sum of row number and column number equal 4
                                    alice.setEntry(i, j, j+1); //set value in ith row and jth column of alice to j+1
                            else //if sum of row number and column number does not equal 2 or 4
                                    alice.setEntry(i, j, 0); //set value in ith row and jth column of alice to 0
                    } //close for loop
            } //close for loop
            
            alice.setEntry(2,4, 7); //set value in second row and fourth column of alice to 7
            
            alice.print(); //printing alice
            
            System.out.println("\n"); //new line
            
            alice.rowreduce().print(); //printing the Matrix which results when alice is row reduced
            
            System.out.println("\n"); //new line
            
            alice.print(); //printing alice again!
    } //close main
} //close class
