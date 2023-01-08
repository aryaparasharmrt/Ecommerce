package com.example.ecommerce_d;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Order {

    void placeOrder(String productID) throws SQLException {
        ResultSet res=HelloApplication.connection.executeQuery("Select max(orderID) as OrderID from orders");
        int orderID=1;
        if(res.next()){
            orderID=res.getInt("orderID")+1;
        }
        Date date=new Date(Calendar.getInstance().getTime().getTime());
        Timestamp ts=new Timestamp(Calendar.getInstance().getTime().getTime());
//        System.out.println(date.toString());
        System.out.println(ts.toString());
        String query=String.format("Insert Into Orders values(%s,%s,'%s','%s')",orderID,productID,HelloApplication.emailId,ts);

        int response=HelloApplication.connection.executeUpdate(query);
        if(response>0)
            System.out.println("The Order is Placed");
        else
            System.out.println("Order is not Placed");
    }
}
