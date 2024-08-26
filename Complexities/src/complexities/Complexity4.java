/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexities;

/**
 *
 * @author muska
 */
public class Complexity4 {

    public static int sum(int n) {
        return n + n;
    }

    public static void numberPrint(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(i);

        }
    }
                                         // O(n)
    public static void main(String[] args) {
        System.out.println(sum(5));
        numberPrint(20);

    }

}
