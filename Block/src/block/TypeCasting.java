/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package block;

/**
 *
 * @author muska
 */
class Vegetable {
    void showType() {
        System.out.println("This is a vegetable.");
    }
}

class Carrot extends Vegetable {
    @Override
    void showType() {
        System.out.println("This is a carrot.");
    }

    void showColor() {
        System.out.println("Carrots are orange.");
    }
}

public class TypeCasting {
    public static void main(String[] args) {
        // Auto-widening example
        int num = 100;
        double wideNum = num; // int to double (auto-widening)
        System.out.println("Auto-widening: " + wideNum);

        // Explicit narrowing example
        double bigNum = 99.99;
        int narrowNum = (int) bigNum; // double to int (explicit narrowing)
        System.out.println("Explicit narrowing: " + narrowNum);

        // Auto-up casting example
        Carrot carrot = new Carrot();
        Vegetable veg = carrot; // Carrot to Vegetable (auto-up casting)
        veg.showType();

        // Explicit down casting example
        Vegetable veg2 = new Carrot(); // Auto-up casting
        Carrot carrot2 = (Carrot) veg2; // Vegetable to Carrot (explicit down casting)
        carrot2.showType();
        carrot2.showColor(); // Now we can access Carrot-specific methods
    }
}
