package com.example.ecommerce_d;
import java.sql.*;

public class DatabaseConnection {
    Connection con=null;
    String SQLURL="jdbc:mysql://localhost:3306/Ecommerce?useSSL=false";
    String userName="root";
    String password="Arya123@#123";

    DatabaseConnection() throws SQLException {
        con= DriverManager.getConnection(SQLURL,userName,password);
        if(con!=null)
            System.out.println("Connection is Stablise with our Sql database");
    }

    public ResultSet executeQuery(String query) throws SQLException{

        Statement statement=con.createStatement();     //Not Understood
        ResultSet result=statement.executeQuery(query);
        return result;
    }

    public int executeUpdate(String query) throws SQLException{
        int row=0;
        Statement statement=con.createStatement();     //Not Understood
        row=statement.executeUpdate(query);
        return row;
    }
}

