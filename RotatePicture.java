package Practice;

/* Program to rotate a picture matrix.
 * Given a matrix of integers with the number of rows and columns and a flag variable. 
 * If flag = 0, rotate the matrix left or Anti-Clockwise
 * If flag = 1, rotate the matrix right or Clockwise 
 */

public class RotatePicture {
	
	/*
	 * The below function rotates the provided picture matrix depending on the value of flag*/
	public static void rotatePictureMatrix(int[][] img, int rows, int columns, int flag){
		
		/* We create a transpose Array of the original Array img[][] 
		 * since the rows and columns are going to be inversed for flag = 0 or 1
		 * */
		
		int invRows = columns; // columns become rows for the transpose Array
		int invCols = rows; // rows become columns for the transpose Array
		
		int[][] newPictureM = new int[invRows][invCols]; // new Array to store the rotated Matrix
		
		if(flag == 0) {			
			newPictureM = rotateLeft(img,invRows,invCols);	// Call function rotateLeft() if flag = 0			
		} // end if
		
		if(flag == 1) {
			newPictureM = rotateRight(img,invRows,invCols);	// Call function rotateRight() if flag = 1			
		}// end if
					
	}// end rotatePictureMatrix method
	
	/* The below function rotates the provided picture matrix 90 degree to Left */
	static int[][] rotateLeft(int[][] img, int rows,int cols){
		int k = rows-1; // we use k to locate the last row item in the provided array
		
		int[][] temp = new int[rows][cols]; // Temporary array to store the result
			
		/* To rotate the array we iterate over the Array
		 *  and store the value of last column item to first one row by row*/
		
			for(int i=0;i<rows;i++) 
			{				
				for(int j = 0;j<cols;j++) {					
					temp[i][j] = img[j][k];	// e.g if rows = 3, temp[0][0] = img[0][2];					
				} // end inner for loop
				
				k--; // decrease k to iterate the next row
			} // end outer for loop	
			
			return temp; //return the result of the rotation
	}// end rotateLeft method
	
	/* The below function rotates the provided picture matrix 90 degree to Right */
	static int[][] rotateRight(int[][] img,int rows,int cols){
		
		int k; // we use k to locate the last column item in the provided array
		
		int[][] temp = new int[rows][cols]; // Temporary array to store the result
		
		/* To rotate the array we iterate over the Array
		 *  and store the value of last row item to first one column by column*/
		for(int i=0;i<rows;i++)
		{
			k = cols-1;			
			for(int j = 0;j<cols;j++) {					
				
				temp[i][j] = img[k][i];	 // e.g if rows = 3, temp[0][0] = img[2][0] providing the rotation;	
				
				k--;// decrease k to iterate the next column
			} // end inner for loop
			
		} // end outer for loop
		return temp; //return the result of the rotation		
	} // end rotateRight method

}// end class
