package com.example.login;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuariocontroller {
    public static boolean verificarCredenciales(String username, String password) {
        Connection connection = connectionDb.getConnection();

        // Log para verificar que se obtuvo conexión
        if (connection != null) {
            Log.d("MiApp", "Conexión establecida con la base de datos");
        } else {
            Log.d("MiApp", "No se pudo establecer la conexión con la base de datos");
            return false; // Termina la ejecución si no hay conexión
        }
        try {
            String query = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            // Log para verificar que se está realizando la consulta
            Log.d("MiApp", "Realizando consulta a la base de datos");

            ResultSet resultSet = statement.executeQuery();
            boolean resultado = resultSet.next();

            // Log para verificar el resultado de la consulta
            Log.d("MiApp", "Resultado de la consulta: " + resultado);
            resultSet.close();
            statement.close();
            connection.close();
            return resultado;

        } catch (SQLException e) {
            // Log para registrar el error
            Log.e("MiApp", "Error al realizar la consulta", e);
            e.printStackTrace();
        }
        return false;
    }

    public static String obtenerRol(String username) {
        Connection connection = connectionDb.getConnection();
        if (connection != null) {
            try {
                String query = "SELECT rol FROM usuarios WHERE nombre = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String rol = resultSet.getString("rol");
                    resultSet.close();
                    statement.close();
                    connection.close();
                    return rol;
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
