/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array;
import java.util.Arrays;

/**
 *
 * @author muska
 */
public class Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        CREATION OF AN ARRAY
        int[] arr=new int[5]; //O(1)
        arr[0]=3;//O(1)
        arr[1]=23;//O(1)
        arr[2]=21;//O(1)
        arr[3]=34;//O(1)
        arr[4]=3;//O(1)
        
        System.out.println(Arrays.toString(arr));
        
        String[] sArray={"dq","sdq","qwdqw","qwdqw","wqe3","e3rdq   "};//O(1)
        System.out.println(Arrays.toString(sArray));
    //The toString() method is defined in the Object class and is meant to return a string representation of an object.

    }
    
}
