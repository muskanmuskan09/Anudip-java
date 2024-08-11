/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package block;

/**
 *
 * @author muska
 */
public class Person {
    String name;
    int age;
    String address;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.address = "Not Provided";
    }

    // Constructor with one parameter
    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.address = "Not Provided";
    }

    // Constructor with two parameters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "Not Provided";
    }

    // Constructor with all parameters
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Method to display person details
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public static void main(String[] args) {
        // Using different constructors with Indian names
        Person person1 = new Person(); // Calls default constructor
        Person person2 = new Person("Muskan"); // Calls constructor with one parameter
        Person person3 = new Person("Komal", 25); // Calls constructor with two parameters
        Person person4 = new Person("Manorma", 30, "456 Elm Street, Delhi"); // Calls constructor with all parameters

        // Display information
        System.out.println("Person 1:");
        person1.displayInfo();
        System.out.println("Person 2:");
        person2.displayInfo();
        System.out.println("Person 3:");
        person3.displayInfo();
        System.out.println("Person 4:");
        person4.displayInfo();
    }
}
/*--Output--
Person 1:
Name: Unknown
Age: 0
Address: Not Provided
Person 2:
Name: Muskan
Age: 0
Address: Not Provided
Person 3:
Name: Komal
Age: 25
Address: Not Provided
Person 4:
Name: Manorma
Age: 30
Address: 456 Elm Street, Delhi
BUILD SUCCESSFUL (total time: 1 second)

*/