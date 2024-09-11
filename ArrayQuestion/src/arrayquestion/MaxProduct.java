/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayquestion;

/**
 *
 * @author muska
 */
public class MaxProduct {
    /**
     * Finds the pair of integers in the array whose product is the maximum
     * and returns the pair as a comma-separated string.
     *
     * @param intArray The array of integers to search through.
     * @return A string representing the pair of integers with the maximum product.
     */
    public String maxProduct(int[] intArray) {
        // Initialize variables to keep track of the maximum product and the pair of integers
        int maxProduct = Integer.MIN_VALUE; // Use the smallest possible value for comparison
        String pairs = "";

        // Iterate through the array to find the pair with the maximum product
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {  // Complexity:- O(N^2)
                // Calculate the product of the current pair
                int product = intArray[i] * intArray[j];
                
                // Update maxProduct and pairs if the current product is greater
                if (product > maxProduct) {
                    maxProduct = product;
                    pairs = intArray[i] + "," + intArray[j];
                }
            }
        }
        
        // Return the pair with the maximum product as a comma-separated string
        return pairs;
    }

    public static void main(String[] args) {
        MaxProduct obj = new MaxProduct();
        int[] numbers = {1, 2, 3, 4, 5};
        String result = obj.maxProduct(numbers);
        System.out.println("Pair with maximum product: " + result); // Expected output: "4,5"
    }
}
