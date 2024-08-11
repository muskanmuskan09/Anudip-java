/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package block;

/**
 *
 * @author muska
 */


 class Variable {
    static int a=0; //class variable
    int b=1; // instance variable
    
    public void display(){
        System.out.println("Class Variable:"+a);
        System.out.println("Instance Variable:"+b); 
        
    }
    public static void main(String[] agrs){
        Variable obj=new Variable();
        obj.display();
    }
    
    
    
}

