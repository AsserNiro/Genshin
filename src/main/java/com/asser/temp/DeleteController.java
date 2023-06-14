//package com.asser.controller;
//
//import com.asser.dao.RoleDao;
//import com.asser.dao.WeaponDao;
//import com.asser.entity.HolyRelic;
//import com.asser.entity.Role;
//import com.asser.entity.Weapon;
//import com.asser.Main;
//import com.asser.dao.HolyRelicDao;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class DeleteController {
//
//    public Label roleResult;
//    public Label holyRelicResult;
//    public Label weaponResult;
//    public Button btnBack;
//    public TextField tfRoleId;
//    public TextField tfHolyRelicId;
//    public TextField tfWeaponId;
//
//    @FXML
//    private void back() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));//跳转对应界面
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//    @FXML
//    private void onDeleteRoleClicked() throws SQLException {
//        int id = Integer.parseInt(tfRoleId.getText());
//        RoleDao.deleteRole(new Role(Integer.parseInt(tfRoleId.getText())));
//        roleResult.setText("删除"+id+"号角色");
//    }
//    @FXML
//    private void onDeleteHolyRelicClicked() throws SQLException {
//        int id = HolyRelicDao.deleteHolyRelic(new HolyRelic(Integer.parseInt(tfHolyRelicId.getText())));
//        holyRelicResult.setText("删除"+id+"号圣遗物");
//    }
//    @FXML
//    private void onDeleteWeaponClicked() throws SQLException {
//        int id = WeaponDao.deleteWeapon(new Weapon(Integer.parseInt(tfWeaponId.getText())));
//        weaponResult.setText("删除"+id+"号角色");
//    }
//
//}
