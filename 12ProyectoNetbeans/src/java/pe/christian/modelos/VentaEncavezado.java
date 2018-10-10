/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.christian.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class VentaEncavezado {
    private int id;
    private LocalDate fecha;
    private String nombre;
    private String direccion;
    private List<VentaDetalle> detalle = new ArrayList<>();

    public VentaEncavezado() {
    }
    
    public VentaEncavezado(int id, LocalDate fecha, String nombre, String direccion) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<VentaDetalle> getDetalle() {
        return detalle;
    }

    // Se llama -> ventaEncabezado.setDetalle().add(objeto1)
//    public void setDetalle(List<VentaDetalle> detalle) {
//        this.detalle = detalle;
//    }
    
    // Se llama -> ventaDetalle.add(objeto1)
    public void addDetalle(VentaDetalle item){
        detalle.add(item);
    }
}
