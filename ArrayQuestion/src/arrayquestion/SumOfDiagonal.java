/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayquestion;

/**
 *
 * @author muska
 */
public class SumOfDiagonal {
    public static int sumDiagonalElements(int[][] array){
        int sum=0;
        int size=array.length;
        for(int i=0;i<size;i++){
            sum+=array[i][i];
        }
        
        return sum;
        
    }
    public static void main(String[] args){
    int[][] myArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Calculate and print the sum of diagonal elements
        int sum = sumDiagonalElements(myArray);
        System.out.println("Sum of diagonal elements: " + sum);
        
    }
}
