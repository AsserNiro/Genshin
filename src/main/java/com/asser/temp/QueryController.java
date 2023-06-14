//package com.asser.controller;
//
//import com.asser.entity.HolyRelic;
//import com.asser.entity.Role;
//import com.asser.entity.Weapon;
//import com.asser.Main;
//import com.asser.dao.HolyRelicDao;
//import com.asser.dao.RoleDao;
//import com.asser.dao.WeaponDao;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.security.InvalidParameterException;
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.List;
//
//public class QueryController {
//    public Button btnBack;
//    public RadioButton rbRole;
//    public RadioButton rbHolyRelic;
//    public RadioButton rbWeapon;
//    public TextField tfId;
//    public TextField tfName;
//    public TableView tableView;
//    private int type = -1;
//    private List<Role> roles;
//    private List<HolyRelic> holyRelics;
//    private List<Weapon> weapons;
//    private static final List<String> roleColumnHeader;
//    private static final List<String> roleFields;
//    private static final List<String> holyRelicColumnHeader;
//    private static final List<String> holyRelicFields;
//    private static final List<String> weaponColumnHeader ;
//    private static final List<String> weaponFields;
//    static {
//        roleColumnHeader= Arrays.asList("角色id","角色名","角色介绍","基础生命值","武器id","圣遗物id");
//        roleFields = Arrays.asList("id","name","introduce","baseHp","holyRelicId","weaponId");
//        holyRelicColumnHeader = Arrays.asList("圣遗物id","圣遗物名","圣遗物类型","提供生命值");
//        holyRelicFields = Arrays.asList("id","name","typeName","provideHp");
//        weaponColumnHeader = Arrays.asList("武器id","武器名","武器类型","提供生命值");
//        weaponFields = Arrays.asList("id","name","typeName","provideHp");
//    }
//    @FXML
//    private void back() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));//跳转对应界面
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//    @FXML
//    private void onQueryClicked() throws SQLException {
//        type = getQueryType();
//        if (type==-1) throw new InvalidParameterException("未知查询类型");
//        boolean isAdded = false;
//        StringBuilder sb = new StringBuilder();
//        String idText = tfId.getText();
//        if (idText.trim().length()!=0){
//            sb.append("id=").append(idText);
//            isAdded = true;
//        }
//        String nameText = tfName.getText();
//        if (nameText.trim().length()!=0){
//            if (isAdded)sb.append(" and ");
//            sb.append("name='").append(nameText).append("'");
//        }
//        ObservableList columns = tableView.getColumns();
//        columns.clear();
//
//        switch (type){
//            case 1:
//                if (sb.length()==0)roles = RoleDao.selectRoles();
//                else roles = RoleDao.selectRoles(sb.toString());
//                for (int i=0; i<roleColumnHeader.size();i++) {
//                    TableColumn column = new TableColumn(roleColumnHeader.get(i));
//                    column.setCellValueFactory(new PropertyValueFactory<>(roleFields.get(i)));
//                    column.setStyle( "-fx-alignment: CENTER;");
//                    columns.add(column);
//                }
//                tableView.setItems(FXCollections.observableArrayList(roles));
//                break;
//            case 2:
//                if (sb.length()==0)holyRelics = HolyRelicDao.selectHolyRelics();
//                else holyRelics = HolyRelicDao.selectHolyRelics(sb.toString());
//                for (int i=0; i<holyRelicColumnHeader.size();i++) {
//                    TableColumn column = new TableColumn(holyRelicColumnHeader.get(i));
//                    column.setCellValueFactory(new PropertyValueFactory<>(holyRelicFields.get(i)));
//                    column.setStyle( "-fx-alignment: CENTER;");
//                    columns.add(column);
//                }
//                tableView.setItems(FXCollections.observableArrayList(holyRelics));
//                break;
//            case 3:
//                if (sb.length()==0) weapons = WeaponDao.selectWeapons();
//                else weapons = WeaponDao.selectWeapons(sb.toString());
//                for (int i=0; i<weaponColumnHeader.size();i++) {
//                    TableColumn column = new TableColumn(weaponColumnHeader.get(i));
//                    column.setCellValueFactory(new PropertyValueFactory<>(weaponFields.get(i)));
//                    column.setStyle( "-fx-alignment: CENTER;");
//                    columns.add(column);
//                }tableView.setItems(FXCollections.observableArrayList(weapons));
//                break;
//        }
//
//    }
//    private int getQueryType(){
//        if (rbRole.isSelected())return 1;
//        else if (rbHolyRelic.isSelected())return 2;
//        else if (rbWeapon.isSelected()) return 3;
//        else return -1;
//    }
//}
