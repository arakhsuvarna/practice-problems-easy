package Practice;

import java.util.Arrays;

/* This program finds the sum of 2 items from an array which is less than integer k. 
 * @pre The array intArr contains integers and size >=0
 * @post The largest sum less than k
 * @param intArr The array of integers
 * @param k The value to be compared against 
 * */

public class TwoSumLessThanK{
	
	/* This function sorts the array intArr 
	 * @pre The array intArr contains integers and size >=0
	 * @post The largest sum less than k
	 * @param intArr The array of integers
	 * @param k The value to be compared against 
	 * */
	
	public static int twoSumCheck(int[] intArr, int k) {
		
		Arrays.sort(intArr); // Sort the array
		
		if(intArr[0] >= 0) {
			int[] divideArr = splitPositiveArray(intArr,k); // Split the array to check only for numbers less than k
			
			return checkTwoSum(divideArr,k); // Function call to find the sum of two items. Returns the sum total of the two items less than k
			}
					
		if(intArr[0]<0) {	
			return checkTwoSum(intArr,k); // Function call to find the sum of two items. Returns the sum total of the two items less than k
		}
		
		return -1; // return -1 if no valid sum is found
		
	}
	
	/* This function splits the positive array into array of numbers less or equal to k
	 * @pre The array intArr is sorted and contains positive integers only and size >=0
	 * @post Array of integers smaller or equal to k
	 * @param sortedArray The sorted array of integers
	 * @param k The value to be compared against
	 *
	 * */
	public static int[] splitPositiveArray(int[] sortedArray, int k){
		
		int[] tempArr = new int[sortedArray.length]; // Temporary array to store the values less than k
		
		int i = 0,j=0;		
		int arrLength = sortedArray.length-1;
		
		for(i=0;sortedArray[i]<=k && i<=arrLength;i++){ // Iterate through the array and store the values less than k to temporary array
			
			tempArr[j]=sortedArray[i];
			
			j++;				
		}		
		return tempArr; // return the split array
	}
	
	/* This function calculates the sum of two values in the array and compares the value to k
	 * @pre The array sortedArray contains integers and size >=0
	 * @post The largest sum less than k
	 * @param sortedArray The sorted array of integers
	 * @param k The value to be compared against 
	 * */
	public static int checkTwoSum(int[] sortedArray, int k){
			
			int ans = 0;
			
			for(int i=0;i<sortedArray.length-1;i++) { 
				for(int j=i+1;j<sortedArray.length-1;j++) {
					ans = Math.max(ans, sortedArray[i]+sortedArray[j]);		// calculate the maximum sum of two entries			
				}
			}		
			ans =(ans < k)? ans: -1; // return the sum if it is less than k or else return -1
			
			return ans;
			
		}
	
	// Main function 
	public static void main(String[] args) {
		
		int[] checkSum = new int[] {5, 20, 10, 100, 10,3};
		int k = 85;
		
		System.out.printf("Sum for two entries less than sum total of %d is %d ",k,TwoSumLessThanK.twoSumCheck(checkSum, k));
		
	}
}
