package com.mysql;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {

    private static String url = "jdbc:mysql://localhost:3306/usersdb?user=root&serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "Egor@12345678";//jdbc:mysql://localhost/productdb?serverTimezone=Europe/Moscow&useSSL=false

    public static ArrayList<User> select() {

        ArrayList<User> users = new ArrayList<User>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String firstname = resultSet.getString(2);
                    String lastname = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    User User = new User(id, firstname, lastname, age);
                    users.add(User);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }
    public static ArrayList<User> searchByLastname(String lastname) {

        ArrayList<User> users = new ArrayList<User>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM users WHERE lastname=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, lastname);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int idFrom = resultSet.getInt(1);
                        String firstname = resultSet.getString(2);
                        String lastnameDB = resultSet.getString(3);
                        int age = resultSet.getInt(4);
                        User User = new User(idFrom, firstname, lastnameDB, age);
                        users.add(User);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }
    public static User selectOne(int id) {

        User user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM users WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int idFrom = resultSet.getInt(1);
                        String firstname = resultSet.getString(2);
                        String lastname = resultSet.getString(3);
                        int age = resultSet.getInt(4);
                        user = new User(idFrom, firstname, lastname, age);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user;
    }
    public static int insert(User user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO users (id, firstname, lastname, age) Values (?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, user.getId());
                    preparedStatement.setString(2, user.getFirstname());
                    preparedStatement.setString(3, user.getLastname());
                    preparedStatement.setInt(4, user.getAge());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(User user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE users SET firstname = ?, lastname = ?, age = ? WHERE id = ? ";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getFirstname());
                    preparedStatement.setString(2, user.getLastname());
                    preparedStatement.setInt(3, user.getAge());
                    preparedStatement.setInt(4, user.getId());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM users WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}