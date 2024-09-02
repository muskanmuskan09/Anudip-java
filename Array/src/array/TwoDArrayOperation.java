/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array;

/**
 *
 * @author muska
 */
public class TwoDArrayOperation {
    //Default Constructor
    public TwoDArrayOperation(){};
    int arr[][];
    //Initialized the values of an array
    public TwoDArrayOperation(int rows, int columns){
        this.arr = new int[rows][columns];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=Integer.MIN_VALUE;
            }
        }
    }
    public void insertValues(int row, int col, int value){
        try{
            if(this.arr[row][col]==Integer.MIN_VALUE){
                this.arr[row][col]=value;
                System.out.println("Successfully inserted into an Array");
            }else{
                System.out.println("Accessible index is already occupied");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index is not present");
            
        }
        
    }
    public void accessingValue(int col, int row){
        System.out.println("Accessing the element of Array");
        try{
            System.out.println("Index Value is: "+this.arr[col][row]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index is not present");
        }
        
    }
    public void traverse2DArray(){
        try{
            for(int i=0;i<arr.length;i++){  //O(mn)-> time complexity O(1)->space complexity 
            for(int j=0;j<arr[0].length;j++){
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
        }catch(Exception e){
            System.out.println("Something get wronged");
        }
        
        
    }
    public void searchOfElement(int element){
        
            for(int i=0;i<arr.length;i++){  //O(mn)-> time complexity O(1)->space complexity
                for(int j=0;j<arr[0].length;j++){
                    if(arr[i][j]==element){
                        System.out.println("Element present at the index of : ["+i+"]["+j+"]");
                        return;
                    }
                }
            }
        System.out.println("Element not found");
    }
    public void deletionOfElement(int row, int col){
        try{
            System.out.println("Successfully deleted the Elements "+ arr[row][col]);
           arr[row][col]=Integer.MIN_VALUE;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index is not present");
            
        }
    }
    
}
