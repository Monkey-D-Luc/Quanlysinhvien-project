package com.example.demo;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DiemThiController extends MainController{
    private final String[] sceneNames = {
            "Điểm cá nhân",
            "Danh sách điểm"
    };

    @FXML
    private ChoiceBox<String> selectSceneChoiceBox;

    @Override
    public void DiemThi(ActionEvent e) throws Exception {
        System.out.println("Trang hien tai la Diem Thi");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        //selectSceneChoiceBox.getItems().addAll(sceneNames);
        selectSceneChoiceBox.setItems(FXCollections.observableArrayList(sceneNames));
        selectSceneChoiceBox.setValue(sceneNames[0]);
        selectSceneChoiceBox.setTooltip(new Tooltip("Select"));
        selectSceneChoiceBox.setOnAction(event -> {
            try{
                LoadScene(event);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        });

    }
    public void LoadScene(ActionEvent event) throws IOException {
        Scene scene = ((Node)event.getSource()).getScene();
        String value = selectSceneChoiceBox.getValue();
        //Parent root = null;
        switch (value) {
            case "Điểm cá nhân" -> {
                Parent root = FXMLLoader.load(getClass().getResource("DiemThi.fxml"));
                scene.setRoot(root);
            }
            case "Danh sách điểm" -> {
                Parent root2 = FXMLLoader.load(getClass().getResource("DiemThi2.fxml"));
                scene.setRoot(root2);
            }
        }

    }
}
