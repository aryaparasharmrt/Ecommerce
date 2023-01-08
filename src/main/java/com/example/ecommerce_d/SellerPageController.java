package com.example.ecommerce_d;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerPageController{

    @FXML
    TextField name;
    @FXML
    TextField price;
    @FXML
    TextField sellerId;

    public void AddProduct(MouseEvent e) throws SQLException{
        int productID=1;
        ResultSet response2=HelloApplication.connection.executeQuery("Select max(productID) as productId from product");
        if(response2.next()){
            productID=response2.getInt("productID")+1;
        }
        String query=String.format("Insert into Product values(%s,'%s',%s,'%s')",productID,name.getText(),price.getText(),sellerId.getText());
        int response=HelloApplication.connection.executeUpdate(query);
        if(response>0)
            System.out.println("New Product Added");
    }

}
