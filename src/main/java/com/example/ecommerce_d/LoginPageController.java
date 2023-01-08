package com.example.ecommerce_d;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;

public class LoginPageController {

    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @FXML
    public void login_in(MouseEvent e) throws Exception{
        String query=String.format("Select * from user where emailID='%s' AND pass='%s'",email.getText(),password.getText());
        ResultSet res=HelloApplication.connection.executeQuery(query);

        if(res.next()){
            String userType=res.getString("usertype");
            if(userType.equals("Seller")){
                AnchorPane sellerPage= FXMLLoader.load(getClass().getResource("Seller.fxml"));
                HelloApplication.root.getChildren().add(sellerPage);
            }
            else
            {
                HelloApplication.emailId=res.getString("emailID"); //to get the buyer emailid
                System.out.println("We are logged in as Buyer");
                ProductPage productPage=new ProductPage();

                FxmlController header=new FxmlController(); //To load header
                AnchorPane productPane= new AnchorPane();
                productPane.getChildren().add(productPage.products());
                productPane.setLayoutX(150);
                productPane.setLayoutY(100);
                HelloApplication.root.getChildren().clear();
                HelloApplication.root.getChildren().addAll(header.root,productPane);
            }
            System.out.println("The User is Present in the User Table");
        }else
            System.out.println("The user is not present");
    }
}
