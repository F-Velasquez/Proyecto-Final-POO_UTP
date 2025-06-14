package com.mycompany.sistemadeventaseinventario.Persistence.DAO;

import com.mycompany.sistemadeventaseinventario.Logic.Clases.Proveedor;
import com.mycompany.sistemadeventaseinventario.Persistence.ConexionDB;
import com.mycompany.sistemadeventaseinventario.Persistence.Interfaces.DAOProveedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProveedoresImpl extends ConexionDB implements DAOProveedores {

    @Override
    public void registrar(Proveedor proveed) throws Exception {

        try {

        } catch (Exception e) {
        } finally {
        }

    }

    @Override
    public List<Proveedor> listarProveedores() throws Exception {
        List<Proveedor> listaProv = new ArrayList<>();

        try {

            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("select * from Proveedores");
            ResultSet resultado = st.executeQuery();

            while (resultado.next()) {
                Proveedor prov = new Proveedor();
                prov.setId_proveedor(resultado.getInt("id_proveedor"));
                prov.setEmpresa(resultado.getString("Empresa"));
                prov.setContacto(resultado.getString("Contacto"));
                prov.setTelefono(resultado.getString("Telefono"));
                prov.setEmail(resultado.getString("Email"));
                listaProv.add(prov);
            }
        } catch (SQLException e) {
        } finally {
            this.cerrarConexionDB();
        }

        return listaProv;
    }

    @Override
    public Proveedor traerProveedor(int id_proveedor) throws Exception {
        Proveedor proveed = new Proveedor();
        try {

            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement(" select * from Proveedores where Proveedores.id_proveedor = ?");
            st.setInt(1, id_proveedor);

            ResultSet RS = st.executeQuery();

            if (RS.next()) {
                proveed.setId_proveedor(RS.getInt("id_proveedor"));
                proveed.setEmpresa(RS.getString("Empresa"));
                proveed.setContacto(RS.getString("Contacto"));
                proveed.setContacto(RS.getString("Telefono"));
                proveed.setEmail(RS.getString("Email"));
            }

        } catch (SQLException e) {
            throw e;

        } finally {
            this.cerrarConexionDB();
        }
        return proveed;
    }
    
    @Override
    public List<String> obtenerNombresEmpresas() throws Exception {
        
        List<String> nombres = new ArrayList<>();
        List<Proveedor> lista = listarProveedores(); // Ya existente

        for (Proveedor p : lista) {
            nombres.add(p.getEmpresa());
        }

        return nombres;
    }

}
