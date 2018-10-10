/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.christian.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import pe.christian.utilidades.Utilidades;

/**
 *
 * @author Christian
 */
public class PSQLConexion {
    Connection conectar(){
        Connection conexion = null;
        Properties propiedades = Utilidades.getInstancia().getConfiguracionBaseDeDatos();
        String url = "jdbc:postgresql://" +
                propiedades.getProperty("servidor ") + ":" +
                propiedades.getProperty("puerto") + "/" +
                propiedades.getProperty("basededatso");
        String user = propiedades.getProperty("usuariobd");
        String pass = propiedades.getProperty("passwordbd");
        
        try {
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return conexion;
    }
}
