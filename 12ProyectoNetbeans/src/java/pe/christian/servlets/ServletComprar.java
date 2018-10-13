/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.christian.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.christian.dao.PSQLProducto;
import pe.christian.dao.PSQLTalla;
import pe.christian.modelos.Producto;
import pe.christian.modelos.Talla;
import pe.christian.utilidades.Utilidades;

/**
 *
 * @author Christian
 */
@WebServlet(name = "ServletComprar", urlPatterns = {"/agregar-producto"})
public class ServletComprar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtenemos la sesion que esta actualmente
        // Informacion del cliente que esta trabajando (lo que esta comprando) independiente
        HttpSession sesion = request.getSession();
        
        String sId = request.getParameter("idproducto");
        String sTalla = request.getParameter("talla");
        
        short idProducto, idTalla;
        try {
            idProducto = Short.parseShort(sId);
            idTalla = Short.parseShort(sTalla);
        } catch (NumberFormatException nfe) {
            idProducto = 0;
            idTalla = 0;
        }
        
        PSQLProducto daoProducto = new PSQLProducto();
        PSQLTalla daoTalla = new PSQLTalla();
        
        Producto producto = daoProducto.obtenerPorId(idProducto);
        Talla talla = daoTalla.obtenerPorId(idTalla);
        producto.setTalla(talla);
        
        // Obtiene la lista de productos que esta en la sesion con el atributo "carro"
        List<Producto> carro = (List) sesion.getAttribute("carro");
        
        // Es nulo porque es la primera vez que ingresa
        // O es nulo porque termino su compra anterior
        if (carro == null) {
            carro = new ArrayList<>();
        }
        
        carro.add(producto);
        sesion.setAttribute("carro", carro);
        Utilidades.getInstancia().irAPagina(request, response, getServletContext(), "/carro.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
