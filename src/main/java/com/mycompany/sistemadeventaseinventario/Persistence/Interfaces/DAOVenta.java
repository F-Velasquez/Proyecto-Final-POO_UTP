package com.mycompany.sistemadeventaseinventario.Persistence.Interfaces;

import com.mycompany.sistemadeventaseinventario.Logic.Clases.Venta;
import java.util.List;

public interface DAOVenta {

    public void registrar(Venta venta) throws Exception;

    public List<Object[]> listaDeVentas() throws Exception;

    public Object[] obtenerVentaConCliente(int idVenta) throws Exception;

    public List<Object[]> listarDetallesPorVenta(int idVenta) throws Exception;
    
    public List<Object[]> buscar(String criterio) throws Exception;

}
