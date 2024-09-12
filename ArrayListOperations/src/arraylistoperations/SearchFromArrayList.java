/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraylistoperations;

import java.util.ArrayList;

/**
 *
 * @author muska
 */
public class SearchFromArrayList {
    public static void main(String[] args){
        ArrayList<Integer> obj=new ArrayList<>();
        obj.add(12);
        obj.add(10);
        obj.add(9);
        obj.add(13);
        obj.add(23);
        obj.add(19);
        
        for(int digit:obj){
            if(digit==9){
                System.out.println("It is found");
            }
        }
        int index=obj.indexOf(9);
        System.out.println(index);
    }
    
}
