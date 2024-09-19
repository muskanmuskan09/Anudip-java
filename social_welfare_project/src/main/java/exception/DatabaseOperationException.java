/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Maninder Singh
 */
public class DatabaseOperationException extends RuntimeException {
      public DatabaseOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
