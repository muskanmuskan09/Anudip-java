/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author muska
 */
public class SinglyLinkedList {

    public Node head;
    public Node tail;
    public int size;
    
    // Creation of node into Singly linked list
    public Node createSinglyLinkedList(int value) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = value;
        head = node;            // Overall the complexity in this is O(1)
        tail = node;
        size = 1;
        return head;

    }

//     Insertion of node into Singly linked list
    public void insertNode(int value, int location) {
        System.out.println("Insertion operation performed");
        Node node = new Node();
        node.value = value;
        if (head == null) {
            createSinglyLinkedList(value);   // O(1)
            return;
        } else if (location == 0) {
            System.out.println("Add node as first node");  // O(1)
            node.next = head;
            head = node;
        } else if (location >= size) {
            System.out.println("Add node as last node ");
            node.next = null;                        // O(1)
            tail.next = node;
            tail = node;
        } else {
            System.out.println("Add node in between linked list");    // O(1)
             Node tempNode = head;
      int index = 0;
      while (index < location - 1) {
        tempNode = tempNode.next;
        index++;
      }
      Node nextNode = tempNode.next;
      tempNode.next = node;
      node.next = nextNode;
    }
    size++;
       // So this means that the Time complexity - O(N) and the space Complexity is O(1)
    }
    
    public void traversalOfNode(){
        System.out.println("Traversal operation performed");
        if(head==null){                                 //O(1)
            System.out.println("Singly Linked list does not exist");
        }else {
            Node tempNode=head;
            for(int i=0;i<size;i++){    
                System.out.print(tempNode.value);// O(n)
                if(i!=size-1){
                    System.out.print("-->");
                }
                tempNode=tempNode.next;
            }
        }
                System.out.println();
        // So this means that the Time complexity - O(N) and the space Complexity is O(1)


    }
    
    //Searching of a node into Linked List 
    public boolean searchNode(int value){
        System.out.println("Search operation performed");
        Node tempNode=head;
        if(head==null){                                 //O(1)
            System.out.println("SLL does not exist");
        }else{
            for(int i=0;i<size;i++){                    //O(N)
                if(value==tempNode.value){
                    System.out.println("Found at index: "+i);
                    return true;
                }
                tempNode=tempNode.next;             //O(1)
            }
        }
        System.out.println("Node does not exist");    
        return false;                           
        
        // So the time complexity of this method is O(N) and the space complexity is O(1) 
    }
    
    public void deletionOfNode(int location) {
        System.out.println("Deletion operation performed");
    if (head == null) {
      System.out.println("The SLL does not exist");     //O(1)
      return;
    } else if (location == 0) {
      head = head.next;
      size--;
      if (size == 0) {
        tail = null;
      }
    } else if (location >= size) {
      Node tempNode = head;
      for (int i = 0; i < size - 1; i++) {
        tempNode = tempNode.next;
      }
      if (tempNode == head) {
        tail = head = null;                   //O(1)
        size--;
        return;
      }
      tempNode.next = null;
      tail = tempNode;
      size--;
    } else {
      Node tempNode = head;
      for (int i = 0; i <location-1; i++) { //O(N)
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      size--;
    }
  }
    public void deleteEntireLL(){
        System.out.println("Entire Deletion of linked list");

        head=null;
        tail=null;
        System.out.println("Succesfully Deleted the Singly Linked list");
    }
}
