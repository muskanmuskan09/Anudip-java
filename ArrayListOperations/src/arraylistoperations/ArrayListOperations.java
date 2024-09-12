/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraylistoperations;
import java.util.ArrayList;
/**
 *
 * @author muska
 */
public class ArrayListOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2,6); //Time complexity for this will : O(n) as it have to iterate the 
//                                          rest of values for fixing given value into given index
        System.out.println(arrayList);
        
//        ArrayList<String> arrayListOfStringType=new ArrayList<String>();
//        arrayListOfStringType.add("Hello");
//        arrayListOfStringType.add("Muskan");
//        arrayListOfStringType.add("How");
//        arrayListOfStringType.add("are");
//        arrayListOfStringType.add("you?");
//        System.out.println(arrayListOfStringType);  

        // Accessing the element
        
        System.out.println(arrayList.get(0)); // Using get method in Arraylist we can access the index value 
        System.out.println(arrayList.get(1)); // Complexity O(1)
        

    }
    
}
