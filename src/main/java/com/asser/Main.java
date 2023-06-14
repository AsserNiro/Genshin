package com.asser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stu_0523.fxml"));
        StackPane root = new StackPane();
        root.setStyle("-fx-background-image:url(img/xueyuan.jpg); ");
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("img/xueyuan.jpg")));//设置应用左上角图标（选加）
        primaryStage.setTitle("猎人赏金栏");//设置应用上方标题
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
