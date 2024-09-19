/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Maninder Singh
 */
public class DonationNotFoundException extends RuntimeException {
      public DonationNotFoundException(String message) {
        super(message);
    }
}
