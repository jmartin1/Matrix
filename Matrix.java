package Matrix;
/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This class creates a matrix and contains methods to manipulate the matrix, including the print, plus, times, scalarTimesRow, switchRows, linearCombRows, rowreduce, and invert methods. A matrix is a two dimensional array of numbers; it has r rows and c columns, and each entry is a real number. 
 * 
 * @method print
 * 		Prints a matrix.
 * @method plus
 * 		Adds two matrices.
 * @method times
 * 		Multiplies two matrices.
 * @method scalarTimesRow
 * 		Multiplies a scalar times a row.
 * @method switchRows
		Switches two rows of a matrix.
 * @method linearCombRows
 * 		Adds a scalar multiple of the first row to the second row. 
 * @method rowreduce
 * 		Row reduces a matrix. 
 * @method invert
 * 		Inverts a matrix.
 */

public class Matrix {
	//declarations
	int rows; //declare rows, the number of rows
	int columns; //declare columns, the number of columns
	double [][] m; //declare m, the array that holds the matrix values
	double firstrowswitchvalue; //declare firstrowswitchvaleu, the value in first row to be switched with value in second row in the switchRows method
	double secondrowswitchvalue; //declare secondrowswitchvalue, the value in second row to be switched with value in first row in the switchRows method
	double rowcombvalue; //declare rowcombvalue, the value of the first row mulitplied by a scalar added to a second row in the linearCombRows method

	/**
	 * Constructor for matrix; initializes number of rows and columns.
	 * 
	 * @param r
	 * 		Number of rows.
	 * @param c
	 * 		Number of columns.
	 */
	public Matrix(int r, int c) {
		rows = r; //set rows equal to r
		columns = c; //set columns equal to c
		m = new double[r][c]; //set double array m to have r rows and c columns
	} //close constructor

	/**
	 * Sets the entry at a certain row and column of the matrix to a certain value.
	 * 
	 * @param r
	 * 		Row number.
	 * @param c
	 * 		Column number.
	 * @param d
	 * 		Value to be inserted in matrix at row r, column c.
	 */
	public void setEntry(int r, int c, double d) {
		// TODO Auto-generated method stub
		m[r][c] = d; //set entry at row r, column c to d
	} //close setEntry

	/**
	 * Prints matrix.
	 */
	public void print() {
		for (int i = 0; i < rows; i++) { //for loop from 0 to rows
			for (int j = 0; j < columns; j++) { //for loop from 0 to columns
				System.out.print("{" + m[i][j] + "}"); //print entry in the ith row and jth column
			} //close for loop
			System.out.println("\n"); //new line after every row
		} //close for loop
	} //close print

	/**
	 * Adds two matrices. To add two matrices, add the corresponding entries from each matrix. The two matrices must have the same dimensions (same number of rows by same number of columns) to be added.
	 * 
	 * @param that
	 * 		The matrix to be added to the given matrix.
	 * @return plusmatrix
	 * 		The sum of the matrices.
	 */
	public Matrix plus(Matrix that) {
		if (rows == that.rows && columns == that.columns) { //if the number of rows of given matrix equals number of rows of second matrix and the number of columns of given matrix equals the number of columns of that:
			Matrix plusmatrix = new Matrix(rows, columns); //create plusmatrix
			for (int i = 0; i < rows; i++) { //for loop from 0 to rows
				for (int j = 0; j < columns; j++) { //for loop from 0 to columns
					plusmatrix.m[i][j] = this.m[i][j] + that.m[i][j]; //set the value in the ith row and jth column of plusmatrix to the sum of the value in the ith row and jth column of given matrix to the value in the ith row and jth column of that
				} //close for loop
			} //close for loop
			return plusmatrix; //return plusmatrix
		} //close if
		else { //else:
			return null; //return null
		} //close else
	} //close plus

	/**
	 * Multiplies two matrices. To mulitply two matrices, multiply each entry of a row of the first matrix to each entry of a column of the second matrix; each of these individual products is then summed and entered into the product matrix at the row of the first matrix and column of the second matrix from which it was calculated. The dimensions of the product matrix must have the same number of rows in the first matrix and the same number of columns in the second matrix.
	 * 
	 * @param that
	 * 		The matrix to be multiplied to the given matrix.
	 * @return timesmatrix
	 * 		The product of the matrices.
	 */
	public Matrix times(Matrix that) {
		Matrix timesmatrix = new Matrix(this.rows, that.columns); //create timesmatrix
		if (this.columns == that.rows){ //if the number of columns of the given matrix equal the number of rows of that
			for (int i = 0; i < this.rows; i++) { //for loop from 0 rows of given matrix
				for (int j = 0; j < that.columns; j++) { //for loop from 0 to columns of that
					for (int k = 0; k < that.rows; k++) { //for loop from 0 to rows of that
						timesmatrix.m[i][j] += this.m[i][k] * that.m[k][j]; //add the product of the value of in the ith row and jth column of given matrix and the value in the ith row and jth column of that to the value in the ith row and jth column of timesmatrix
					} //close for loop
				} //close for loop
			} //close for loop
		return timesmatrix; //return timesmatrix
		} //close if
		else { //else:
			return null; //return null
		} //close else
	} //close times

	/**
	 * Multiplies a scalar times a row.
	 * 
	 * @param scalar
	 * 		The scalar to multiply the row by.
	 * @param rownumber
	 * 		The row number to multiply the scalar.
	 * @return scalartimesrowmatrix
	 * 		The modified matrix with one row mulitplied by scalar.
	 */
	public Matrix scalarTimesRow(double scalar, int rownumber) {
		Matrix scalartimesrowmatrix = new Matrix(rows, columns); //create scalartimesrowmatrix
		for (int i = 0; i < rows; i++) { //for loop from 0 to rows
			for (int j = 0; j < columns; j++) { //for loop from 0 to columns
				scalartimesrowmatrix.m[i][j] = this.m[i][j]; //fill up scalartimesrowmatrix, by setting the value in the ith row and jth column of scalartimesrowmatrix to the value in the ith row and jth column of the given matrix
			} //close for loop
		} //close for loop
		for (int j = 0; j < columns; j++) { //for loop from 0 to rows
			scalartimesrowmatrix.m[rownumber][j] = scalar*this.m[rownumber][j]; //set the value in the rownumberth row and jth column of scalartimesrowmatrix to the product of the scalar and the value in the ith row and jth column of the given matrix
		} //close for loop
		return scalartimesrowmatrix; //return scalartimesrowmatrix
	} //close scalarTimesRow

	/**
	 * Switches two rows of a matrix.
	 * 
	 * @param firstrow
	 * 		The first row used to switch.
	 * @param secondrow
	 * 		The second row used to switch.
	 * @return switchrowsmatrix
	 * 		The modified matrix with switched rows.
	 */
	public Matrix switchRows(int firstrow, int secondrow) {
		Matrix switchrowsmatrix = new Matrix(rows, columns); //create switchrowsmatrix
		for (int i = 0; i < rows; i++) { //for loop from 0 to rows
			for (int j = 0; j < columns; j++) { //for loop from 0 to columns
				switchrowsmatrix.m[i][j] = this.m[i][j]; //fill up switchrowsmatrix, by setting the value in the ith row and jth column of switchrowsmatrix to the value in the ith row and jth column of the given matrix
			} //close for loop
		} //close for loop
		for (int j = 0; j < columns; j++){ //for loop from 0 to columns
			firstrowswitchvalue = switchrowsmatrix.m[firstrow][j]; //set firstrowswitchvalue to the value in the firstrowth row and jth column of switchrows matrix
			secondrowswitchvalue = switchrowsmatrix.m[secondrow][j]; //set secondrowswitchvalue to the value in the secondrowth row and jth column of switchrows matrix
			switchrowsmatrix.m[firstrow][j] = secondrowswitchvalue; //set the firstrowth row and jth column of switchrows matrix to secondrowswitchvalue
			switchrowsmatrix.m[secondrow][j] = firstrowswitchvalue; //set the secondrowth row and jth column of switchrows matrix to firstrowswitchvalue
		} //close for loop
		return switchrowsmatrix; //return switchrowsmatrix
	} //close switchRows

	/**
	 * Adds a scalar multiple of the first row to the second row. 
	 * 
	 * @param scalar
	 * 		The scalar used to multiply the first row. 
	 * @param firstrow
	 * 		The row that is multiplied by a scalar and then added to another row.
	 * @param secondrow
	 * 		The row is added to a row already multiplied by a scalar.
	 * @return linearcombrowsmatrix
	 * 		The modified matrix with one row multiplied by a scalar and added to another row.
	 */
	public Matrix linearCombRows(double scalar, int firstrow, int secondrow) {
		Matrix linearcombrowsmatrix = new Matrix(rows, columns); //create linearcombrowsmatrix
		for (int i = 0; i < rows; i++) { //for loop from 0 to rows
			for (int j = 0; j < columns; j++) { //for loop from 0 to columns
				linearcombrowsmatrix.m[i][j] = this.m[i][j]; //fill up linearcombrowsmatrix, by setting the value in the ith row and jth column of linearcombrowsmatrix to the value in the ith row and jth column of the given matrix
			} //close for loop
		} //close for loop
		for (int j = 0; j < columns; j++){ //for loop from 0 to columns
			rowcombvalue = (linearcombrowsmatrix.m[firstrow][j] * scalar) + linearcombrowsmatrix.m[secondrow][j]; //set rowcombvalue to the sum of the product of the scalar and the value in the firstrowth row and jth column of linearcombrowsmatrix and the value in the secondrowth row and jth column of linearcombrowsmatrix
			linearcombrowsmatrix.m[secondrow][j] = rowcombvalue; //set the value in the secondrowth row and jth column of linearcombrowsmatrix to rowcombvalue
		} //close for loop
		return linearcombrowsmatrix; //return linearcombrowsmatrix
	} //close linearCombRows

	/**
	 * Row reduces a matrix.
	 * 
	 * @return rowreducematrix
	 * 		The fully rowreduced matrix.
	 */
	public Matrix rowreduce() {
		Matrix rowreducematrix = new Matrix(rows, columns); //create rowreducematrix
		for (int i = 0; i < rows; i++) { //for loop from 0 to rows
			for (int j = 0; j < columns; j++) { //for loop from 0 to columns
				rowreducematrix.m[i][j] = this.m[i][j]; //fill up rowreducematrix, by setting the value in the ith row and jth column of rowreducematrix to the value in the ith row and jth column of the given matrix
			} //close for loop
		} //close for loop
		for (int c = 0; c < rows; c++) { //for loop from 0 to rows
			for (int i = c; i < rows; i++) { //for loop from c to rows
				if (rowreducematrix.m[i][c] != 0) { //if the value in the ith row and cth column of rowreducematrix is not equal to zero
					rowreducematrix = rowreducematrix.switchRows(i, c); //switch the ith row and cth row (to get it in upper triangular form)
					rowreducematrix = rowreducematrix.scalarTimesRow(1/rowreducematrix.m[c][c], c); //multiply the cth row by the reciprocal of the value in the cth row and cth column of rowreducematrix (to get it to equal one) 
					for (int j = 0; j < rows; j++) { //for loop from 0 to rows
						if (j != c) { //if j (row number) does not equal c (column number)
							rowreducematrix = rowreducematrix.linearCombRows(-rowreducematrix.m[j][c], i, j); //mulitply the ith row by the negative value in the jth column and cth row of rowreducematrix and add it to the jth row
						} //close if
					} //close for loop
				} //close if
			} //close for loop
		} //close for loop
		return rowreducematrix; //return rowreducematrix
	}

	/**
	 * Inverts a matrix. The invert method appends the identity matrix to the right hand side of original matrix, row reduces the whole augmented matrix, and then returns a matrix created from the right hand side of the augmented matrix.
	 * 
	 * @return inverse matrix
	 * 		The inverse matrix.
	 */
	public Matrix invert() {
		Matrix originalmatrix = new Matrix(rows, columns); //creates originalmatrix
		for (int i = 0; i < rows; i++) { //for loop from 0 to rows
			for (int j = 0; j < columns; j++) { //for loop from 0 to columns
				originalmatrix.m[i][j] = this.m[i][j]; //fill up originalmatrix, by setting the value in the ith row and jth column of originalmatrix to the value in the ith row and jth column of the given matrix
			} //close for loop
		} //close for loop
		Matrix identity = new Matrix(rows, columns); //creates identity
		if (originalmatrix.m.length == originalmatrix.m[0].length) { //if the number of rows in original matrix equals the number of columns in original matrix (if it is a square matrix)
			for (int i = 0; i < rows; i++) { //for loop from 0 to rows
				for (int j = 0; j < columns; j++) { //for loop from 0 to columns
					if (i == j) { //if row number equals column number
						identity.m[i][j] = 1; //set the value in the ith row and jth column of identity to 1
					} //close if
					else { //if row number does not equal column number
						identity.m[i][j] = 0; //set the value in the ith row and jth column of identity to 0
					} //close else
				} //close for loop
			} //close for loop
		} //close for loop
		else { //else
			System.out.println("This matrix is not invertable."); //print system isn't invertable
		} //close else
		Matrix augmentedmatrix =  new Matrix(rows, 2*columns); //create augmented matrix, which has twice as many columns as originalmatrix and identity
		if (originalmatrix.m.length == originalmatrix.m[0].length) { 
			for (int i = 0; i < rows; i++) { //for loop from 0 to rows
				for (int j = 0; j < columns; j++) { //for loop from 0 to columns
					augmentedmatrix.m[i][j] = originalmatrix.m[i][j]; //set the value in the ith row and jth column of augmentedmatrix to the value in the ith row and jth column of originalmatrix
				} //end for loop
			} //end for loop
			for (int i = 0; i < rows; i++) { //for loop from 0 to rows
				for (int j = columns; j < 2*columns; j++) { //for loop from 0 to two times columns
					if (i == j-columns) { //if row number equals the corresponding column number on the right hand side of the augmentedmatrix
						augmentedmatrix.m[i][j] = 1; //set the value in the ith row and jth column of augmentedmatrix to 1
					} //close if
					else { //if row number does not equal corresponding column number on the right hand side of the augmentedmatrix
						augmentedmatrix.m[i][j] = 0; //set the value in the ith row and jth column of augmentedmatrix to 0 
					} //close else
				} //close for loop
			} //close for loop
			augmentedmatrix = augmentedmatrix.rowreduce(); //rowreduce augmentedmatrix
		}//close if
		else { //else
		} //close else
		Matrix inversematrix = new Matrix(rows, columns); //create inversematrix
		for (int i = 0; i < rows; i++) { //for loop from 0 to rows
			for (int j = 0; j < columns; j++) { //for loop from 0 to columns
				inversematrix.m[i][j] = augmentedmatrix.m[i][j+columns]; //set the value in the ith row and jth position of inversematrix to the value in the corresponding entry in augmentedmatrix
			} //close for loop
		} //close for loop
		return inversematrix; //return inversematrix
	}//close invert
} //close class
