package config;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DataBaseConn {
    Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Driver not found");
        }

        String coonectionString = "jdbc:mysql://" + Config.HOST + ":" + Config.PORT + "/" + Config.DBNAME + "?serverTimezone=UTC";

        try {
            connection = DriverManager.getConnection(coonectionString, Config.USER, Config.PASS);
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return connection;
    }

    public void addDatabase(User user) {
        String insert = "INSERT INTO " + Config.DBTABLE + " (name, email, text)  VALUES  (?,?,?)";

        try {
            PreparedStatement prST = getConnection().prepareStatement(insert);
            prST.setString(1, user.getName());
            prST.setString(2, user.getEmail());
            prST.setString(3, user.getText());
            prST.addBatch();
            prST.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

     public User selectBase(User user) {
         User newUser = new User();
         ResultSet resultSet = null;
         String select = "SELECT * FROM " + Config.DBTABLE + " WHERE name =?";
         try {
             PreparedStatement psSt = getConnection().prepareStatement(select);
             psSt.setString(1, user.getName());
             resultSet = psSt.executeQuery();
             while (resultSet.next()) {
                 newUser.setId(resultSet.getLong(1));
                 newUser.setName(resultSet.getString(2));
                 newUser.setEmail(resultSet.getString(3));
                 newUser.setText(resultSet.getString(4));
             }


         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         return newUser;
     }

    public List<User> listBase() {
        List<User> list = new ArrayList<>();
        String s = "SELECT * FROM " + Config.DBTABLE;
        try {
            PreparedStatement psSt = getConnection().prepareStatement(s);
            ResultSet resultSet = psSt.executeQuery();

            while (resultSet.next()) {
               User user = new User();
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setText(resultSet.getString(4));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
