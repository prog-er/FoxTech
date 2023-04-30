package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AfterLogin implements Initializable {

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView news_logo;
    @FXML
    private Button log_out_btn;

    @FXML
    private Button sports;

    @FXML
    private Button technology;

    @FXML
    void initialize(ActionEvent event) {
        log_out_btn.setOnAction(e -> new LoginController().openFxmlFile(e, "loginPage.fxml"));
        technology.setOnAction(e -> new TechController().openFxmlFile(e, "TechPg.fxml"));
//        bt1.setOnAction(e -> infoMessage(news1));
//        bt2.setOnAction(e -> infoMessage(news2));
//        bt3.setOnAction(e -> infoMessage(news3));
//        bt4.setOnAction(e -> infoMessage(news4));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File piz1File = new File("img/tech_news.jpg");
        Image piz1Image = new Image(piz1File.toURI().toString());
        img1.setImage(piz1Image);

        File piz2File = new File("img/sport's_news.jpg");
        Image piz2Image = new Image(piz2File.toURI().toString());
        img2.setImage(piz2Image);

        File piz3File = new File("img/business_news.png");
        Image piz3Image = new Image(piz3File.toURI().toString());
        img3.setImage(piz3Image);

        File piz4File = new File("img/economy_news.jpg");
        Image piz4Image = new Image(piz4File.toURI().toString());
        img4.setImage(piz4Image);

        File piz5File = new File("img/news_logo.png");
        Image piz5Image = new Image(piz5File.toURI().toString());
        news_logo.setImage(piz5Image);
    }

    void infoMessage(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, s);
        alert.setTitle("Information");
        alert.showAndWait();
    }

}
