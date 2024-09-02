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
public class MainTwoDArrayOperation {
    public static void main(String[] args){
        TwoDArrayOperation obj=new TwoDArrayOperation(2,2);
        obj.insertValues(0, 0, 22);
        obj.insertValues(0, 5, 22);
        obj.insertValues(0, 0, 222);
        obj.insertValues(0, 1, 23);
        obj.insertValues(1, 0, 9);
        obj.insertValues(1, 1, 10);
        
        System.out.println(Arrays.deepToString(obj.arr));
//----------Output------------
/*
            Successfully inserted into an Array
            Index is not present
            Accessible index is already occupied
            Accessible index is already occupied
            Successfully inserted into an Array
            Successfully inserted into an Array
            Successfully inserted into an Array
            [[22, 23], [9, 10]]
*/
obj.accessingValue(1, 0);   //O(1) time & space complexity
obj.accessingValue(0, 0);
obj.accessingValue(1, 20);
//----OUTPUT------
/*
Accessing the element of Array
Index Value is: 22
Accessing the element of Array
Index is not present
*/
System.out.println("Traversal of an  Array");
obj.traverse2DArray();  //O(mn)-> time complexity O(1)->space complexity 
//----Output----
/*
Traversal of an  Array
 22 23
 9 10
*/
obj.searchOfElement(9);
obj.deletionOfElement(0, 0);
System.out.println(Arrays.deepToString(obj.arr));


    }
    
}
