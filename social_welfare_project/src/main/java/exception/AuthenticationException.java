/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author muska
 */

public class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message); // Call the parent constructor (Exception) with the message
    }
}
