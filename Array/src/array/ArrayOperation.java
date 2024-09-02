/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array;

/**
 *
 * @author muska
 */
class ArrayOperation {

    int arr[] = null;

    public ArrayOperation() {
    }

    public ArrayOperation(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
            System.out.println(arr[i]);  //In this step all the array values are initialised with this value
            // becoz it is the small integer value -2147483648 
        }
    }
//  FOR INSERTION INTO ARRAY
    public void insertElements(int location, int valueToBeStored) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToBeStored;
                System.out.println("Successfully inserted into Array");
            } else {
                System.out.println("Already occupied ");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array! ");

        }
        
        
    }
    
    // FOR ARRAY TRAVERSAL
    public void arrayTraversal(){
        try{
           for(int i=0;i<arr.length;i++){
               System.out.println(arr[i]);
           } 
        }catch(Exception e){
            
        }
            
        }
    public void searchElement(int element){
       for(int i=0;i<arr.length;i++){
           if(arr[i]==element){
               System.out.println("Element found at index :"+i);
               return;
           }
       }
       System.out.println(element+ " is not found ");
    }
    public void deleteElement(int valueToDelete){
        try{
            arr[valueToDelete]=Integer.MIN_VALUE;
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The value that is provided is not in the range of array");
        }
        
    }

    public static void main(String[] args) {
        ArrayOperation obj = new ArrayOperation(10);  //---OUTPUT----

        obj.insertElements(2, 44);            // Successfully inserted into Array    
        obj.insertElements(1, 22);           //Successfully inserted into Array
        obj.insertElements(1, 22);           //Already occupied 
        obj.insertElements(3, 223);          //  Successfully inserted into Array
        obj.insertElements(12, 22);        // Invalid index to access array! 
        
        obj.arrayTraversal();
    //---OUTPUT----
        /*
        -2147483648
        22
        44
        223
        -2147483648
        -2147483648
        -2147483648
        -2147483648
        -2147483648
        -2147483648
        */
        obj.searchElement(22); //Element found at index :1
        obj.searchElement(982); //982 is not found 
        
        obj.deleteElement(1);
        System.out.println(obj.arr[1]); //-2147483648
    }

}
