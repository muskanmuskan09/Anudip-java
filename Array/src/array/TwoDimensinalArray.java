/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array;

import java.util.Arrays;

/**
 *
 * @author muska
 */
public class TwoDimensinalArray {

    public static void main(String[] args) {
        //Step 1: Create Reference of an array or declare
        int[][] arr;
        //Step 2: Instantiate
        arr = new int[2][2];
        //Step 3: Intialized
        arr[0][0] = 1;   // -----|
        arr[0][1] = 2;   //      |-----O(mn) Space complexity
        arr[1][0] = 3;   //      |
        arr[1][1] = 4;   // -----|

        System.out.println(Arrays.deepToString(arr)); // [[1, 2], [3, 4]] ---Output---
//Arrays.deepToString() is a static method provided by the Arrays class. It is used to convert a multidimensional array
//into a string that represents the array's contents, including nested arrays.

//We can do all the above 3 step into one step are as follows:---


        String[][] arr2 = {{"a", "b"}, {"c", "d"}};   //O(1)
        System.out.println(Arrays.deepToString(arr2)); // [[a, b], [c, d]] ---Output---

    }

}
