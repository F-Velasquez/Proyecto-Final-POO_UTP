package com.mycompany.sistemadeventaseinventario.Persistence.Interfaces;

import com.mycompany.sistemadeventaseinventario.Logic.Clases.Producto;
import com.mycompany.sistemadeventaseinventario.Logic.Clases.Proveedor;
import java.util.List;

public interface DAOProducto {

    public void registrar(Producto prodcut, Proveedor proveed) throws Exception;

    public void Editar(int id_producto, Producto product,  Proveedor prov) throws Exception;

    public void Eliminar(int product_id) throws Exception;

    public List<Producto> listarProductos() throws Exception;

    public List<Producto> BuscarProductos(String nombre) throws Exception;

}
