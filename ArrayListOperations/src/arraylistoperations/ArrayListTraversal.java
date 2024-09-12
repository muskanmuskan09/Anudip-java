/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraylistoperations;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author muska
 * Note : In all cases the complexities are :- O(n)
 * 
 */
public class ArrayListTraversal {
    public static void main(String[] args){
        ArrayList<Integer> obj=new ArrayList<>();
        obj.add(12);
        obj.add(10);
        obj.add(9);
        obj.add(13);
        obj.add(23);
        obj.add(19);
        //This is the first approach
        System.out.println("This is the first approach");
        for(int i=0;i<obj.size();i++){
            int letter=obj.get(i);
            System.out.println(letter);
        }
        //This is the Second approach
        System.out.println("This is the Second approach");
        for(int letter:obj){
            System.out.println(letter);
        }
        
        // This is the 3rd approach 
        System.out.println("This is the 3rd approach");
       Iterator<Integer> iterator1=obj.iterator();
        while(iterator1.hasNext()){
            int letter=iterator1.next();
            System.out.println(letter);
        }
        
        
    }
}
