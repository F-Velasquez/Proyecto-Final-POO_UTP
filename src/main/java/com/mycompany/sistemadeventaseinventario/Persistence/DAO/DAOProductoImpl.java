package com.mycompany.sistemadeventaseinventario.Persistence.DAO;

import com.mycompany.sistemadeventaseinventario.Logic.Clases.Producto;
import com.mycompany.sistemadeventaseinventario.Logic.Clases.Proveedor;
import com.mycompany.sistemadeventaseinventario.Persistence.ConexionDB;
import com.mycompany.sistemadeventaseinventario.Persistence.Interfaces.DAOProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProductoImpl extends ConexionDB implements DAOProducto {

    @Override
    public void registrar(Producto product, Proveedor proveed) throws Exception {

        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("INSERT INTO Productos(Nombre,Marca,Stock,Precio,Proveedor,Observacion,id_proveedor) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, product.getNombre());
            st.setString(2, product.getMarca());
            st.setInt(3, product.getStock());
            st.setDouble(4, product.getPrecio());
            st.setString(5, proveed.getEmpresa());
            st.setString(6, product.getObservacion());
            st.setInt(7, proveed.getId_proveedor());
            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {

            this.cerrarConexionDB();
        }

    }

    @Override
    public void Editar(int id_producto, Producto product, Proveedor prov) throws Exception {

        try {

            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("update Productos set Nombre = ? , Marca = ?,Stock = ?, Precio = ?,Proveedor = ?, Observacion = ?,id_proveedor = ? WHERE Id_producto = " + id_producto);
            st.setString(1, product.getNombre());
            st.setString(2, product.getMarca());
            st.setInt(3, product.getStock());
            st.setDouble(4, product.getPrecio());
            st.setString(5, product.getNameProveedor());
            st.setString(6, product.getObservacion());
            st.setInt(7, prov.getId_proveedor());
            st.executeUpdate();
        } catch (SQLException e) {
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public void Eliminar(int product_id) throws Exception {
        try {

            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("DELETE FROM Productos WHERE Id_producto = ? ");
            st.setInt(1, product_id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public List<Producto> listarProductos() throws Exception {

        List<Producto> listaDeProductos = new ArrayList<>();

        try {
            this.establecerConexionDB();

            PreparedStatement st = this.conectar.prepareStatement("SELECT * FROM Productos");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Producto prod = new Producto();
                prod.setId_producto(rs.getInt("Id_producto"));
                prod.setNombre(rs.getString("Nombre"));
                prod.setMarca(rs.getString("Marca"));
                prod.setStock(rs.getInt("Stock"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setNameProveedor(rs.getString("Proveedor"));
                prod.setObservacion(rs.getString("Observacion"));

                Proveedor prov = new Proveedor();

                prov.setId_proveedor(rs.getInt("id_proveedor"));

                prod.setId_proovedor(prov);

                listaDeProductos.add(prod);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaDeProductos;

    }

    @Override
    public List<Producto> BuscarProductos(String nombre) throws Exception {

        List<Producto> listaBDeProductos = new ArrayList<>();

        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("select * from Productos WHERE Nombre LIKE '%" + nombre + "%'");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Producto prod = new Producto();
                prod.setId_producto(rs.getInt("Id_producto"));
                prod.setNombre(rs.getString("Nombre"));
                prod.setMarca(rs.getString("Marca"));
                prod.setStock(rs.getInt("Stock"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setNameProveedor(rs.getString("Proveedor"));
                prod.setObservacion(rs.getString("Observacion"));

                Proveedor prov = new Proveedor();

                prov.setId_proveedor(rs.getInt("id_proveedor"));

                prod.setId_proovedor(prov);

                listaBDeProductos.add(prod);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaBDeProductos;

    }
}
