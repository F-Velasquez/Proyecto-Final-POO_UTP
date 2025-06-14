package com.mycompany.sistemadeventaseinventario.Logic.Clases;

/**
 *
 * @author Frank
 */
public class Producto {

    private int Id_producto;
    private String Nombre;
    private String Marca;
    private int Stock;
    private double Precio;
    private String NameProveedor;
    private String Observacion;
    private Proveedor id_proovedor;

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getNameProveedor() {
        return NameProveedor;
    }

    public void setNameProveedor(String NameProveedor) {
        this.NameProveedor = NameProveedor;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public Proveedor getId_proovedor() {
        return id_proovedor;
    }

    public void setId_proovedor(Proveedor id_proovedor) {
        this.id_proovedor = id_proovedor;
    }

}
