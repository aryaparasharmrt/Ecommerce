package com.example.ecommerce_d;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPage  {
    ListView<HBox> products;

    ListView<HBox> products() throws SQLException{
        products=new ListView<>();
        products.prefWidth(400);
        ObservableList<HBox> productList= FXCollections.observableArrayList(); //

        ResultSet res=HelloApplication.connection.executeQuery("Select*from product");
        while(res.next()){
            Label name=new Label();
            Label productId=new Label();
            Label price=new Label();
            Button buy=new Button();
            HBox productDetails=new HBox();

            name.setMinWidth(60);
            productId.setMinWidth(60);
            price.setMinWidth(60);
            buy.setText("Buy");

            buy.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(HelloApplication.emailId.equals("")){
                        System.out.println("Please Login First");
                    }
                    else{
                        System.out.println("You have logged in with "+HelloApplication.emailId);
                        Order order=new Order();
                        try {
                            order.placeOrder(productId.getText());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        ;
                    }
                    System.out.println("Buy Button is Clicked");
                }
            });
            name.setText(res.getString("productName"));
            price.setText(String.valueOf(res.getInt("price")));
            productId.setText(res.getString("productID" ));
            productDetails.getChildren().addAll(productId,name,price,buy);
            productList.add(productDetails);
        }
        products.setItems(productList);
        return products;
    }

}
