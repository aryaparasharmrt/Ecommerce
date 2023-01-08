package com.example.ecommerce_d;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HeaderController {

    @FXML
    Label email;

    @FXML
    public  void initialize(){
        if(!HelloApplication.emailId.equals("")){
            loginButton.setOpacity(0);
            email.setText(HelloApplication.emailId);
        }

    }
    @FXML
    Button loginButton;

    @FXML
    public void login(MouseEvent e) throws IOException{
        AnchorPane loginpage= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        HelloApplication.root.getChildren().add(loginpage);
    }
}
