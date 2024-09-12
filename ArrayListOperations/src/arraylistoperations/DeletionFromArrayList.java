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
public class DeletionFromArrayList {
    public static void main(String[] args){
        ArrayList<Integer> obj=new ArrayList<>();
        obj.add(12);
        obj.add(10);
        obj.add(9);
        obj.add(13);
        obj.add(23);
        obj.add(19);
        System.out.println(obj);
        obj.remove(4);
        System.out.println(obj);
        
        
    }
}
