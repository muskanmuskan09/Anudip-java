/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexities;
// O(n) Linear Time complexity: because it performs upto n times
/**
 *
 * @author muska
 */
public class Complexity1 {
    public static int totalSum(int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args){
       System.out.println(totalSum(20));
    }
    
}
