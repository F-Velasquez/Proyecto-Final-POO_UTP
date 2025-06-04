package com.mycompany.sistemadeventaseinventario.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Frank
 */
public class ConexionDB {

    protected Connection conectar = null;
    String user = "fvelasquezl";
    String pasword = "root123";
    String ip = "localhost";
    String puerto = "1433";
    String database = "DbSistemaDeVentas";
    String url = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + database + ";encrypt=true;trustServerCertificate=true;";

    public Connection establecerConexionDB() {

        try {

            conectar = DriverManager.getConnection(url, user, pasword);
            System.out.println("Conexion con la base de datos establecida");

        } catch (SQLException e) {

            System.out.println("Fallo la conexion con la base de datos" + e.toString());
        }

        return conectar;

    }

    public void cerrarConexionDB() throws SQLException {

        if (conectar != null) {
            if (!conectar.isClosed()) {
                conectar.close();
            }
        }

    }

}
