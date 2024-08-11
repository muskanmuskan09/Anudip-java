/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package block;

/**
 *
 * @author muska
 */
class OuterClass {
    private class InnerClass {
        void display() {
            System.out.println("This is the private inner class.");
        }
    }

    void outerMethod() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}

public class Main1c {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}

/*
Can we declare a class as private?
We can’t declare an outer class as private. But, we can declare an inner class (class as a member of another class) as private.

*/
