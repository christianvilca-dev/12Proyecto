/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.christian.utilidades;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public final class Utilidades {
    
    private static final Utilidades instancia = new Utilidades();
    
    private Properties propiedadesBD; 

    public Utilidades() {}
    
    public static Utilidades getInstancia() {
        return instancia;
    }

    // Se guardan los parametros del archivo web.xml
    public void configuraBaseDeDatos(Properties propiedades){
        this.propiedadesBD = propiedades;
    }
    
    // Se obtienen los parametros del archivo web.xml
    public Properties getConfiguracionBaseDeDatos(){
        return this.propiedadesBD;
    }
    
    // Reeenvia la informacion de una servlet a un JSP
    public void irAPagina(
            HttpServletRequest request, 
            HttpServletResponse response, 
            ServletContext contexto, 
            String url) 
            throws ServletException, IOException {
        RequestDispatcher despachador = contexto.getRequestDispatcher(url);
        despachador.forward(request, response);
    }
}
