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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class InsertController {

    public TextField tfHunterName;
    public TextField tfHunterSex;
    public TextArea taHunterRecommend;
    public Label hunterResult;

    public TextField tfMissionName;
    public TextField tfLastTime;
    public TextField tfRewardID;
    public TextField tfRewardCount;
    public TextArea taMissionRecommend;
    public Label missionResult;

    public TextField tfRewardName;
    public TextArea tfRewardRecommend;
    public Label rewardResult;

    public Button btnBack;
    @FXML
    private void back() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stu_0523.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void onInsertHunter(){
        Hunter hunter = new Hunter(tfHunterName.getText(),tfHunterSex.getText(),taHunterRecommend.getText());
        HunterDao hunterDao = new HunterDaoImpl();
        String UID = hunterDao.addHunter(hunter);
        hunterResult.setText("加入猎杀"+UID+"号猎人");
    }
    @FXML
    private void onInsertMission(){
        Mission mission = new Mission(tfMissionName.getText(),Integer.parseInt(tfLastTime.getText()),tfRewardID.getText(),
                Integer.parseInt(tfRewardCount.getText()),taMissionRecommend.getText());
        MissionDao missionDao = new MissionDaoImpl();
        String id = missionDao.addMission(mission);
        missionResult.setText("已被探知代号"+id);
    }
    @FXML
    private void onInsertReward(){
        Reward reward = new Reward(tfRewardName.getText(),tfRewardRecommend.getText());
        RewardDao rewardDao = new RewardDaoImpl();
        String id = rewardDao.addReward(reward);
        rewardResult.setText("新的物品代号"+id);
    }

}
