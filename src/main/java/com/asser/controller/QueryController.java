package com.asser.controller;

import com.asser.Main;
import com.asser.dao.HunterDao;
import com.asser.dao.Impl.HunterDaoImpl;
import com.asser.dao.Impl.MissionDaoImpl;
import com.asser.dao.Impl.RewardDaoImpl;
import com.asser.dao.MissionDao;
import com.asser.dao.RewardDao;
import com.asser.entity.Hunter;
import com.asser.entity.Mission;
import com.asser.entity.Reward;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryController {
    public Button btnBack;

    public RadioButton rbHunter;
    public RadioButton rbMission;
    public RadioButton rbReward;
    private int type = -1;
    private List<Hunter> hunters;
    private List<Mission> missions;
    private List<Reward> rewards;
    private static final List<String> hunterColumnHeader;
    private static final List<String> hunterFields;
    private static final List<String> missionColumnHeader;
    private static final List<String> missionFields;
    private static final List<String> rewardColumnHeader;
    private static final List<String> rewardFields;

    public TextField tfId;
    public TableView tableView;
    static {
        hunterColumnHeader = Arrays.asList("猎人id","猎人姓名","猎人性别","猎人完成任务数","猎人介绍");
        hunterFields = Arrays.asList("UID","name","sex","count","recommend");
        missionColumnHeader = Arrays.asList("任务id","任务名称","持续时间","任务奖励id","奖励数量","介绍");
        missionFields = Arrays.asList("MID","name","time","RID","count","recommend");
        rewardColumnHeader = Arrays.asList("物品id","物品名","物品介绍");
        rewardFields = Arrays.asList("RID","name","r_recommend");
    }

    @FXML
    private void back()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stu_0523.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int getType(){
        if(rbHunter.isSelected())return 1;
        else if(rbMission.isSelected())return 2;
        else if(rbReward.isSelected())return 3;
        return -1;
    }

    @FXML
    private void onQueryClick()throws SQLException {
        type = getType();
        if(type == -1){
            throw new InvalidParameterException("未知查询类型");
        }
        boolean isAdded = false;
        StringBuffer sb = new StringBuffer();
        String idText = tfId.getText();
        if(idText.trim().length() != 0){
            sb.append("id=").append(idText);
            isAdded = true;
        }
        ObservableList columns = tableView.getColumns();
        columns.clear();
        switch(type){
            case 1:
                process(hunterColumnHeader,hunterFields,sb.toString());break;
            case 2:
                process(missionColumnHeader,missionFields,sb.toString());break;
            case 3:
                process(rewardColumnHeader,rewardFields,sb.toString());break;

        }
    }

    private void process(List<String> header,List<String> fields,String id){
        HunterDao hunterDao = null;
        MissionDao missionDao = null;
        RewardDao rewardDao = null;
        if(id.length() > 0){
            id = id.substring(3);
        }
        System.out.println("id is " + id);
        if(type == 1){
            hunterDao = new HunterDaoImpl();
            hunters = new ArrayList<>();
            if(id.length() == 0)hunters = hunterDao.findAll();
            else hunters.add(hunterDao.findHunter(id));
            System.out.println("已查询到的"+hunters);
        }else if(type == 2){
            missionDao = new MissionDaoImpl();
            missions = new ArrayList<>();
            if(id.length() == 0)missions = missionDao.findAll();
            else missions.add(missionDao.findMission(id));
            System.out.println("已查询到的"+missions);
        }else if(type == 3){
            rewardDao = new RewardDaoImpl();
            rewards = new ArrayList<>();
            if(id.length() == 0)rewards = rewardDao.findAll();
            else rewards.add(rewardDao.findReward(id));
            System.out.println("已查询到的"+rewards);
        }
        ObservableList columns = tableView.getColumns();
        columns.clear();
        for(int i = 0; i < header.size(); i++){
            TableColumn column = new TableColumn(header.get(i));
            column.setCellValueFactory(new PropertyValueFactory<>(fields.get(i)));
            column.setStyle("-fx-alignment: CENTER;");
            columns.add(column);
        }
        if(type == 1)
            tableView.setItems(FXCollections.observableArrayList(hunters));
        else if(type == 2)
            tableView.setItems(FXCollections.observableArrayList(missions));
        else
            tableView.setItems(FXCollections.observableArrayList(rewards));

    }
}
