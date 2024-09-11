///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
package arrayquestion;
import java.util.Arrays; // Import Arrays class for toString

//Write a function called middle that takes an array and returns a new array that contains all but the first and last elements.
//myArray = [1, 2, 3, 4]
//middle(myArray)  # [2,3]. 
//*/

///**
// *
// * @author muska

public class ArrayQuestion {

    public int[] middle(int[] array1) {
        if (array1.length <= 2) {
            return new int[0]; // Return an empty array if the input array has 2 or fewer elements
        }
        
        int[] middleArray = new int[array1.length - 2]; // Declare an array to hold the middle elements
        
        for (int i = 1; i < array1.length - 1; i++) {
            middleArray[i - 1] = array1[i]; // Copy elements to the new array
        }
        
        return middleArray; // Return the new array
    }

    public static void main(String[] args) {
        ArrayQuestion arrayQuestion = new ArrayQuestion();
        int[] myArray = {1, 2, 3, 4};
        int[] middle = arrayQuestion.middle(myArray);

        // Print the result array using Arrays.toString
        System.out.println(Arrays.toString(middle));

    }
}
