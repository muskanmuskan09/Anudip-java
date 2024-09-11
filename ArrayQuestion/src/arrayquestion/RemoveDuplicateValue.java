/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayquestion;

import java.util.Arrays;

/**
 *
 * @author muska
 */
public class RemoveDuplicateValue {

    public static int[] removeDuplicates(int[] array) {

        int n = array.length;
        int[] uniqueArray = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
           boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (array[i] == uniqueArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){
                uniqueArray[index++]=array[i];
            }

        }
        return Arrays.copyOf(uniqueArray, index);
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 4, 5};
        int[] uniqueArray = removeDuplicates(array);
        System.out.println(Arrays.toString(uniqueArray)); // Output: [1, 2, 3, 4, 5]
    }

}
/*
public static int[] removeDuplicates(int[] array) {
        int n = array.length;
        int[] uniqueArray = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            // Check in the already processed part of the array (from 0 to index)
            for (int j = 0; j < index; j++) {
                if (array[i] == uniqueArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueArray[index++] = array[i];
            }
        }

        // Return the array with only the unique elements
        return Arrays.copyOf(uniqueArray, index);
}
*/
