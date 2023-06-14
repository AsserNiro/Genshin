package com.asser.controller;

import com.asser.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

//TODO-主页面
public class MainController {
    public Button btnDelete;

    public Button btnInsert;

    public Button btnUpdate;
    @FXML
    private void insertButton()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("insertOfDate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnInsert.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void deleteButton()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("deleteOfDate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnInsert.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void updateButton()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("updateOfDate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnInsert.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void queryButton()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("queryOfDate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnInsert.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void test(){
        System.out.println("按钮测试");
    }
}
