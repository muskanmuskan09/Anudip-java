/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankapplication;

import service.MenuDriven;

/**
 *
 * @author muska
 */
public class Main {
    public static void main(String[] args) {
        MenuDriven menuDriven = (MenuDriven) MenuDriven.getInstance();
        menuDriven.displayMenu();
    }
}
