/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author muska
 */
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create Node
        SinglyLinkedList obj=new SinglyLinkedList();
        obj.createSinglyLinkedList(9);
        System.out.println(obj.head.value);
        
        //Insert node
        obj.insertNode(10, 0);
        System.out.println(obj.head.value);
        obj.insertNode(12, 2);
        System.out.println(obj.head.next.value);
        obj.insertNode(19, 3);
        System.out.println(obj.head.next.next.value);
        obj.insertNode(52, 2);
        System.out.println(obj.head.next.value);
        obj.searchNode(33);
        System.out.println();
        
        //Traverse node
        obj.traversalOfNode();
        System.out.println();
        
        //Search node 
        obj.searchNode(33);
        System.out.println();
        obj.searchNode(19);
        System.out.println();
        
        //Delete node
        obj.deletionOfNode(2);
        System.out.println();
        
        //Traverse node
        obj.traversalOfNode();
        System.out.println();
        
        
        //Delete Entire linked list
        obj.deleteEntireLL();
        System.out.println();
        
        //Traverse node
        obj.traversalOfNode();
        System.out.println();
        
    }
    
}
/*  
-------OUTPUT-------


run:
9
Insertion operation performed
Add node as first node
10
Insertion operation performed
Add node as last node 
9
Insertion operation performed
Add node as last node 
12
Insertion operation performed
Add node in between linked list
9
Search operation performed
Node does not exist

Traversal operation performed
10-->9-->52-->12-->19

Search operation performed
Node does not exist

Search operation performed
Found at index: 4

Deletion operation performed

Traversal operation performed
10-->9-->12-->19

Entire Deletion of linked list
Succesfully Deleted the Singly Linked list

Traversal operation performed
Singly Linked list does not exist


BUILD SUCCESSFUL (total time: 1 second)

*/