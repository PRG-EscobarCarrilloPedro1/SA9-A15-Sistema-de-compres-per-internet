package sa9.a15.sistema.de.compres.per.internet.Exceptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author batoi
 */
public class NotExistEnoughItemException extends RuntimeException{
    
    public NotExistEnoughItemException(String missatge) {
        super(missatge);
    }
    
}
