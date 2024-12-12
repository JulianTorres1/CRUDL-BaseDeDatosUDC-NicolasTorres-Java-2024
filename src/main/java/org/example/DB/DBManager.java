package org.example.DB;

import java.sql.*;

public class DBManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/Concesionarios";
    private static final String USER = "root";
    private static final String PASSWORD = "Delfin23";



    public boolean testConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                return true;
            } else {
                System.out.println("Failed to make connection!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return false;
    }

    // ----- List records -----

    public void listRecords(String tableName) {
        String query = "SELECT * FROM " + tableName;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    // ----- Insert record -----

    public void insertRecord(String tableName, String query) {
        String fullQuery = "INSERT INTO " + tableName + " " + query;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(fullQuery);
            System.out.println("Record inserted successfully into table " + tableName + "!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    // ----- Update record -----
    public void updateRecord(String tableName, String query) {
        String fullQuery = "UPDATE " + tableName + " SET " + query;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(fullQuery);
            System.out.println("Record updated successfully in table " + tableName + "!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    // ----- Delete record -----

    public void deleteRecord(String tableName, String num_bastidor_id) {
        String query = "DELETE FROM " + tableName + " WHERE num_bastidor = '" + num_bastidor_id + "'";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Record deleted successfully from table " + tableName + "!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    // --- filter records by price  DESC ---

    public void filterRecordsByPriceDESC(String tableName) {
        String query = "SELECT * FROM " + tableName + " ORDER BY precio DESC";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    // --- filter records by price ASC ---
    public void filterRecordsByPriceASC(String tableName) {
        String query = "SELECT * FROM " + tableName + " ORDER BY precio ASC";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}



