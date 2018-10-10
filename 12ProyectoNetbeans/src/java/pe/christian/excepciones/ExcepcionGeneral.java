/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.christian.excepciones;

/**
 *
 * @author Christian
 */
public class ExcepcionGeneral extends RuntimeException {

    public ExcepcionGeneral() {
    }

    public ExcepcionGeneral(String msg) {
        super(msg);
    }
    
}
