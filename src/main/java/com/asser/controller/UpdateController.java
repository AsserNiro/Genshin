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
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateController {
    public TextField tfHunterId;
    public TextField tfHunterName;
    public TextField tfHunterSex;
    public TextArea taHunterRecommend;
    public Label hunterResult;

    public TextField tfMissionId;
    public TextField tfMissionName;
    public TextField tfLastTime;
    public TextField tfRewardIDInMission;
    public TextField tfRewardCount;
    public TextArea taMissionRecommend;
    public Label missionResult;

    public TextField tfRewardId;
    public TextField tfRewardName;
    public TextArea tfRewardRecommend;
    public Label rewardResult;

    public Button btnBack;


    @FXML
    private void back() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stu_0523.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void onUpdateHunter(){
        Hunter hunter = new Hunter(tfHunterId.getText(),tfHunterName.getText(),tfHunterSex.getText(),taHunterRecommend.getText());
        HunterDao hunterDao = new HunterDaoImpl();
        boolean flag = hunterDao.updateHunter(hunter);
        if(flag)
            hunterResult.setText(tfHunterId.getText()+"号已更新");
        else
            hunterResult.setText("更新失败");
    }
    @FXML
    private void onUpdateMission(){
        Mission mission = new Mission(tfMissionId.getText(),tfMissionName.getText(),taMissionRecommend.getText(),Integer.parseInt(tfLastTime.getText()),tfRewardIDInMission.getText(),
                Integer.parseInt(tfRewardCount.getText()));
        MissionDao missionDao = new MissionDaoImpl();
        boolean flag = missionDao.updateMission(mission);
        if(flag)
            missionResult.setText("更新任务代号"+tfMissionId.getText());
        else
            missionResult.setText("更新失败");
    }
    @FXML
    private void onUpdateReward(){

        Reward reward = new Reward(tfRewardId.getText(),tfRewardName.getText(),tfRewardRecommend.getText());
        System.out.println("asssssss   "+reward);
        RewardDao rewardDao = new RewardDaoImpl();
        boolean flag = rewardDao.updateReward(reward);
        if(flag)
            rewardResult.setText("更新物品代号"+tfRewardId.getText());
        else
            rewardResult.setText("更新失败");
    }
}
