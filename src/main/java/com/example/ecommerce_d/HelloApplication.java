package com.example.ecommerce_d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {
    static DatabaseConnection connection;
    public static Group root;
    public static  String emailId;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        emailId="";
        connection=new DatabaseConnection();
        root=new Group();
        FxmlController header=new FxmlController();
        ProductPage pp=new ProductPage(); //
        AnchorPane ap=new AnchorPane();
        pp.products().prefWidth(200);
        ap.getChildren().add(pp.products());
        ap.setLayoutX(50);
        ap.setLayoutY(50);

        root.getChildren().addAll(header.root,ap);


        Scene scene = new Scene(root, 600, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e->{
            try {
                connection.con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Connection is Closed");
        });
    }

    public static void main(String[] args) {
        launch();
    }
}