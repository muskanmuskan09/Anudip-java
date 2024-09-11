/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayquestion;

/**
 *
 * @author muska
 */
public class IsUnique {
    /**
     * Checks if all elements in the given array are unique.
     *
     * @param intArray The array of integers to check.
     * @return true if all elements are unique, false otherwise.
     */
    public boolean isUnique(int[] intArray) {
        // Iterate through each element of the array
        for (int i = 0; i < intArray.length; i++) {   // Complexity:- O(N^2)
            // Compare the current element with the rest of the elements
            for (int j = i + 1; j < intArray.length; j++) {
                // If a duplicate is found, return false
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        // If no duplicates were found, return true
        return true;
    }

    public static void main(String[] args) {
        IsUnique exercise = new IsUnique();
        int[] numbers1 = {1, 2, 3, 4, 5}; // All elements are unique
        int[] numbers2 = {1, 2, 2, 4, 5}; // Duplicate element 2
        
        System.out.println("Are all elements unique in numbers1? " + exercise.isUnique(numbers1)); // Expected output: true
        System.out.println("Are all elements unique in numbers2? " + exercise.isUnique(numbers2)); // Expected output: false
    }
}
