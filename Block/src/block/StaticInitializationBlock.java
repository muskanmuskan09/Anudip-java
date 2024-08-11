/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package block;

/**
 *
 * @author muska
 */
class A
{
    static int i;
 
    static
    {
        System.out.println(1);
 
        i = 100;
    }
}
 
 class StaticInitializationBlock
{
    static
    {
        System.out.println(2);
    }
 
    public static void main(String[] args)
    {
        System.out.println(3);
 
        System.out.println(A.i);
    }
}