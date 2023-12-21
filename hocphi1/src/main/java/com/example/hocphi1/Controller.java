package com.example.hocphi1;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ChoiceBox<String> mykhoa;
    @FXML
    private ChoiceBox<String> mynam;
    @FXML
    private ChoiceBox<String> mylop;
    @FXML
    private ChoiceBox<String>myhoc_ky;
    private String[] Khoa={"Công nghệ thông tin","Nội thất","Xây dựng"};
    private String [] Nam= {"2021","2022","2023"};
    private String [] HocKy={"1","2"};
    private String[] CNClasses = {"CN1", "CN2"};
    private String[] NTClasses = {"NT1", "NT2"};
    private String[] XDClasses = {"XD1", "XD2"};

    public void initialize (URL arg0, ResourceBundle arg1){
       mykhoa.getItems().addAll(Khoa);
       mynam.getItems().addAll(Nam);
       myhoc_ky.getItems().addAll(HocKy);
        mykhoa.setOnAction(event -> {
                    String selectedKhoa = mykhoa.getValue();
                    switch (selectedKhoa) {
                        case "Công nghệ thông tin":
                            mylop.getItems().setAll(CNClasses);
                            break;
                        case "Nội thất":
                            mylop.getItems().setAll(NTClasses);
                            break;
                        case "Xây dựng":
                            mylop.getItems().setAll(XDClasses);
                            break;
                        default:
                            break;
                    }
                    mylop.setVisible(mylop.getItems().size()>0);
        });
        }
//    public void getKhoa (ActionEvent event){
//        String khoa =mykhoa.getValue();
//    }
    }

