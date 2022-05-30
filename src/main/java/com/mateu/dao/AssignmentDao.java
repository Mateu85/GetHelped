package com.mateu.dao;

import com.mateu.domain.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssignmentDao {

    private Connection connection;

    public AssignmentDao(Connection connection) {

        this.connection = connection;
    }

    public void add(Assignment assignment) {
        String sql = "INSERT INTO assignment (Name, Description, Postcode) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, assignment.getName());
            statement.setString(2, assignment.getDescription());
            statement.setString(3, assignment.getPostcode());
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    }


    public boolean delete(String name) {
        String sql = "DELETE FROM assignment WHERE name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            int rows = statement.executeUpdate();

            return rows == 1;
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }

        return false;
    }


    public boolean modify(String Name, Assignment assignment) {
        String sql = "UPDATE assignment SET Name = ?, Description = ?, Postcode = ? WHERE Name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, assignment.getName());
            statement.setString(2, assignment.getDescription());
            statement.setString(3, assignment.getPostcode());
            statement.setString(4, Name);
            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }

        return false;
    }


    public Assignment findByTitle(String Name) {

        String sql = "SELECT * FROM assignment WHERE Name = ?";
        Assignment assignment = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                assignment = new Assignment();
                assignment.setName(resultSet.getString("Name"));
                assignment.setDescription(resultSet.getString("Description"));
                assignment.setPostcode(resultSet.getString("Postcode"));
            }
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }

        return assignment;
    }


    public ArrayList<Assignment> findAll() {
        String sql = "SELECT * FROM assignment ORDER BY Name";
        ArrayList<Assignment> assignments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Assignment assignment = new Assignment();
                assignment.setName(resultSet.getString("Name"));
                assignment.setDescription(resultSet.getString("Description"));
                assignment.setPostcode(resultSet.getString("Postcode"));
                assignments.add(assignment);
            }
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }

        return assignments;
    }
}



