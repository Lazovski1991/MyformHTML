package config;

import model.User;

import java.sql.*;


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

   /* public ResultSet selectBase(Ship ship) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Config.DBTABLE + " WHERE name =?";
        try {
            PreparedStatement psSt = getConnection().prepareStatement(select);
            psSt.setString(1, ship.getName());
            resultSet = psSt.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public List<Ship> listBase() {
        List<Ship> shipList = new ArrayList<>();
        String s = "SELECT * FROM " + Config.DBTABLE;
        try {
            PreparedStatement psSt = getConnection().prepareStatement(s);
            ResultSet resultSet = psSt.executeQuery();

            while (resultSet.next()) {
                Ship ship = new Ship();
                ship.setId((long) resultSet.getInt(1));
                ship.setName(resultSet.getString(2));
                ship.setPlanet(resultSet.getString(3));
                ship.setShipType(ShipType.valueOf(resultSet.getString(4)));
                ship.setProdDate(resultSet.getDate(5));
                ship.setUsed(resultSet.getBoolean(6));
                ship.setSpeed(resultSet.getDouble(7));
                ship.setCrewSize(resultSet.getInt(8));
                ship.setRating(resultSet.getDouble(9));
                shipList.add(ship);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shipList;
    }*/
    }
}
