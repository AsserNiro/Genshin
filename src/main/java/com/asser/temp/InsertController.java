//package com.asser.controller;
//
//import com.asser.Main;
//import com.asser.dao.HolyRelicDao;
//import com.asser.dao.RoleDao;
//import com.asser.dao.WeaponDao;
//import com.asser.entity.HolyRelic;
//import com.asser.entity.Role;
//import com.asser.entity.Weapon;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class InsertController {
//
//
//    public TextField tfRoleName;
//    public TextField tfRoleBaseHp;
//    public TextArea taRoleIntroduce;
//    public Label roleResult;

//    public TextField tfHolyRelicName;
//    public TextField tfHolyRelicProvideHp;
//    public Label holyRelicResult
//    ;
//    public RadioButton rbFlower;
//    public ToggleGroup holyRelic;
//    public RadioButton rbFeather;
//    public RadioButton rbCrown;
//    public RadioButton rbSword;
//    public TextField tfWeaponName;
//    public TextField tfWeaponProvideHp;
//    public Label weaponResult;
//    public ToggleGroup weaponGroup;
//    public RadioButton rbBow;
//    public RadioButton rbMagic;
//    public Button btnBack;
//    @FXML
//    private void back() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));//跳转对应界面
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//    @FXML
//    private void onInsertRoleClicked() throws SQLException {
//        int id = RoleDao.insertRole(new Role(tfRoleName.getText(),taRoleIntroduce.getText(),Integer.parseInt(tfRoleBaseHp.getText())));
//        roleResult.setText("生成"+id+"号角色");
//    }
//    @FXML
//    private void onInsertHolyRelicClicked() throws SQLException {
//        int type = getHolyRelicType();
//        if (type==-1){
//            holyRelicResult.setText("请选择圣遗物类型");
//            return;
//        }
//        int id = HolyRelicDao.insertHolyRelic(new HolyRelic(tfHolyRelicName.getText(),type,Integer.parseInt(tfHolyRelicProvideHp.getText())));
//        holyRelicResult.setText("生成"+id+"号圣遗物");
//    }
//    @FXML
//    private void onInsertWeaponClicked() throws SQLException {
//        int type = getWeaponType();
//        if (type==-1){
//            weaponResult.setText("请选择武器类型");
//            return;
//        }
//        int id = WeaponDao.insertWeapon(new Weapon(tfWeaponName.getText(),type,Integer.parseInt(tfWeaponProvideHp.getText())));
//        weaponResult.setText("生成"+id+"号角色");
//    }
//    private int getHolyRelicType(){
//        if (rbFlower.isSelected())return 1;
//        else if (rbFlower.isSelected())return 2;
//        else if (rbCrown.isSelected()) return 3;
//        else return -1;
//    }
//    private int getWeaponType(){
//        if (rbSword.isSelected())return 1;
//        else if (rbBow.isSelected())return 2;
//        else if (rbMagic.isSelected()) return 3;
//        else return -1;
//    }
//}
