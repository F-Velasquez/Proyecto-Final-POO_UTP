package com.mycompany.sistemadeventaseinventario.Persistence.DAO;

import com.mycompany.sistemadeventaseinventario.Logic.Clases.Usuario;
import com.mycompany.sistemadeventaseinventario.Persistence.ConexionDB;
import com.mycompany.sistemadeventaseinventario.Persistence.Interfaces.DAOUsuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Frank
 */
public class DAOUsuariosImpl extends ConexionDB implements DAOUsuarios {
    
    @Override
    public void registrar(Usuario user) throws Exception {
        
        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("INSERT INTO Usuarios(Nombres,primer_apellido,segundo_apellido,dni,Correo,Contrasenia,Rol) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, user.getNombres());
            st.setString(2, user.getPrimer_apellido());
            st.setString(3, user.getSegundo_apellido());
            st.setString(4, user.getDNI());
            st.setString(5, user.getCorreo());
            st.setString(6, user.getContrasenia());
            st.setString(7, user.getRol());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        
    }
    
    @Override
    public void editar(Usuario user) throws Exception {
        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("UPDATE usuarios SET Nombres = ?, primer_apellido = ?, segundo_apellido = ?, correo = ? WHERE dni = ?");
            st.setString(1, user.getNombres());
            st.setString(2, user.getPrimer_apellido());
            st.setString(3, user.getSegundo_apellido());
            st.setString(4, user.getCorreo());
            st.setString(5, user.getDNI());
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
    }
    
    @Override
    public Usuario validarUsuario(String correo, String contrasenia) throws Exception {
        
        Usuario user = null;
        
        try {
            
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("select * from Usuarios Where Correo = ? And Contrasenia = ? ");
            st.setString(1, correo);
            st.setString(2, contrasenia);
            ResultSet resultado = st.executeQuery();
            
            if (resultado.next()) { //si hay al menos una fila en el resultado el usuario existe

                user = new Usuario();
                user.setNombres(resultado.getString("Nombres"));
                user.setPrimer_apellido(resultado.getString("primer_apellido"));
                user.setSegundo_apellido(resultado.getString("segundo_apellido"));
                user.setDNI(resultado.getString("dni"));
                user.setCorreo(resultado.getString("Correo"));
                user.setContrasenia(resultado.getString("Contrasenia"));
                user.setRol(resultado.getString("Rol"));
            }
            st.close();
            resultado.close();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return user;
        
    }
    
    @Override
    public List<Usuario> ListarUsuarios() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void actualizar_password(Usuario user, String nueva) throws Exception {
        try {
            this.establecerConexionDB();
            user.setContrasenia(nueva);
            PreparedStatement st = this.conectar.prepareStatement("update Usuarios set Contrasenia =? where dni =?");
            st.setString(1, nueva);
            st.setString(2, user.getDNI());
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
    }
    
}
