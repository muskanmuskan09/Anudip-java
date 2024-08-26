/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexities;
// O(n^2): number of operations is n multiplied by n.
/**
 *
 * @author muska
 */
public class Complexity2 {

    public static void numberPrint(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }

        }

    }
    public static void main(String[] args) {
        numberPrint(20);
    }
}
