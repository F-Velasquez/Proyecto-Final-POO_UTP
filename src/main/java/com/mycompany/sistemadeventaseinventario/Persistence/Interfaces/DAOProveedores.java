package com.mycompany.sistemadeventaseinventario.Persistence.Interfaces;

import com.mycompany.sistemadeventaseinventario.Logic.Clases.Proveedor;
import java.util.List;

public interface DAOProveedores {

    public void registrar(Proveedor proveed) throws Exception;

    public List<Proveedor> listarProveedores() throws Exception;

    public Proveedor traerProveedor(int id_proveedor) throws Exception;
    
    public List<String> obtenerNombresEmpresas() throws Exception;

}
