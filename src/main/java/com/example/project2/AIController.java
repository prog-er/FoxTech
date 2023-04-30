package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AIController implements Initializable {

    @FXML
    private Button business;

    @FXML
    private Button contact_us;

    @FXML
    private Button economy;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private Button log_out_btn;

    @FXML
    private ImageView news_logo;

    @FXML
    private Button sports;

    @FXML
    private Button technology;

    @FXML
    void initialize(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File piz1File = new File("img/AI.jpg");
        Image piz1Image = new Image(piz1File.toURI().toString());
        img1.setImage(piz1Image);

        File piz2File = new File("img/AI1.png");
        Image piz2Image = new Image(piz2File.toURI().toString());
        img2.setImage(piz2Image);

        File piz3File = new File("img/AI2.png");
        Image piz3Image = new Image(piz3File.toURI().toString());
        img3.setImage(piz3Image);

        File piz4File = new File("img/AI3.png");
        Image piz4Image = new Image(piz4File.toURI().toString());
        img4.setImage(piz4Image);

        File piz5File = new File("img/news_logo.png");
        Image piz5Image = new Image(piz5File.toURI().toString());
        news_logo.setImage(piz5Image);
    }

    public void openFxmlFile(ActionEvent e, String name_fxml) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name_fxml)))));
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

