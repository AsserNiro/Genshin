package com.asser.controller;

import com.asser.Main;
import com.asser.dao.HunterDao;
import com.asser.dao.Impl.HunterDaoImpl;
import com.asser.dao.Impl.MissionDaoImpl;
import com.asser.dao.Impl.RewardDaoImpl;
import com.asser.dao.MissionDao;
import com.asser.dao.RewardDao;
import com.asser.entity.Mission;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteController {
    public Label hunterResult;
    public Label missionResult;
    public Label rewardResult;
    public Button btnBack;
    public TextField tfHunter;
    public TextField tfMission;
    public TextField tfReward;

    @FXML
    private void back()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stu_0523.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void onDeleteHunter(){
        HunterDao hunterDao = new HunterDaoImpl();
        boolean flag = hunterDao.deleteHunter(tfHunter.getText());
        if(flag)
            hunterResult.setText("已删除"+tfHunter.getText()+"号猎人");
        else
            hunterResult.setText("删除失败");
    }

    @FXML
    private void onDeleteMission(){
        MissionDao missionDao = new MissionDaoImpl();
        boolean flag = missionDao.deleteMission(tfMission.getText());
        if(flag)
        missionResult.setText("已删除"+tfMission.getText()+"号任务");
        else
            missionResult.setText("删除失败");
    }

    @FXML
    private void onDeleteReward(){
        RewardDao rewardDao = new RewardDaoImpl();
        boolean flag = rewardDao.deleteReward(tfReward.getText());
        if(flag)
            rewardResult.setText("已删除"+tfReward.getText()+"号物品");
        else
            rewardResult.setText("删除失败");

    }
}
