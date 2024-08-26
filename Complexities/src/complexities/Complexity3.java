/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexities;

/**
 *
 * @author muska
 */
public class Complexity3 {

    public static void numberPrint(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j *= 2) {
                System.out.println(i + " " + j);   // O(n*log n)
            }

        }

    }

    public static void main(String[] args) {
        numberPrint(20);
    }

}
