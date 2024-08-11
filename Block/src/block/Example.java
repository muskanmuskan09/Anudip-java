/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package block;

/**
 *
 * @author muska
 */
class Example {
    static int staticVariable;
    int instanceVariable;

    // Static initializer block
    static {
        System.out.println("Static initializer executed");
        staticVariable = 100;  // Initializing the static variable
    }

    // Instance initializer block
    {
        System.out.println("Instance initializer executed");
        instanceVariable = 20;  // Initializing the instance variable
    }

    // Constructor
    public Example() {
        System.out.println("Constructor executed");
        System.out.println("staticVariable = " + staticVariable);
        System.out.println("instanceVariable = " + instanceVariable);
    }

    public static void main(String[] args) {
        System.out.println("Creating the first instance of Example...");
        Example example1 = new Example();

        System.out.println("\nCreating the second instance of Example...");
        Example example2 = new Example();
    }
}
/* -------Output----------  
Static initializer executed
Creating the first instance of Example...
Instance initializer executed
Constructor executed
staticVariable = 100
instanceVariable = 20

Creating the second instance of Example...
Instance initializer executed
Constructor executed
staticVariable = 100
instanceVariable = 20
BUILD SUCCESSFUL (total time: 1 second)
S
*/