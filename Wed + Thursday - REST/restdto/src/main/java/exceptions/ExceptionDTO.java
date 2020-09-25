/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author mattg
 */
public class ExceptionDTO {

    private int code;
    private String message;

    public ExceptionDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
