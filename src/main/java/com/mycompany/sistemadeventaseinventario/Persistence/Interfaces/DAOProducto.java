package com.mycompany.sistemadeventaseinventario.Persistence.Interfaces;

import com.mycompany.sistemadeventaseinventario.Logic.Clases.Producto;
import com.mycompany.sistemadeventaseinventario.Logic.Clases.Proveedor;
import java.util.List;

public interface DAOProducto {

    public void registrar(Producto prodcut, Proveedor proveed) throws Exception;

    public void Editar(int id_producto, Producto product, Proveedor prov) throws Exception;

    public void desactivar(int id_producto) throws Exception;

    public List<Producto> listarProductos() throws Exception;

    public List<Producto> BuscarProductos(String nombre) throws Exception;

    public List<Object[]> listarBajoStock() throws Exception;

    public List<Object[]> listarMasVendidos() throws Exception;
}
