package com.example.ecommerce_d;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FxmlController {
    public AnchorPane root;
//    ProductPage pp;

    FxmlController() throws IOException {
        root= FXMLLoader.load(getClass().getResource("header.fxml"));

    }
}
