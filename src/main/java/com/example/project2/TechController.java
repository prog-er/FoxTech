package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;



public class TechController implements Initializable {

    @FXML
    private Button business;

    @FXML
    private Button contact_us;

    @FXML
    private Button economy;

    @FXML
    private ImageView news_logo;

    @FXML
    private ImageView img1;

    @FXML
    private Button log_out_btn;

    @FXML
    private Button sports;

    @FXML
    private Button technology;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem AI;

    @FXML
    void initialize(ActionEvent event) {

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

    public void openFxmlFile(MouseEvent e, String name_fxml) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name_fxml)))));
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File piz5File = new File("img/news_logo.png");
        Image piz5Image = new Image(piz5File.toURI().toString());
        news_logo.setImage(piz5Image);

        File piz1File = new File("img/tech_news.jpg");
        Image piz1Image = new Image(piz1File.toURI().toString());
        img1.setImage(piz1Image);
    }
    @FXML
    void init() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Artificial Intelligence (AI) is a branch of \n computer science that deals with the creation \n of intelligent machines that can perform tasks \n that typically require human intelligence. ");
        alert.setTitle("AI");
        alert.showAndWait();
        AI.setOnAction(e -> new TechController().openFxmlFile(e, "AIpg.fxml"));
    }
    @FXML
    void init1() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "For example, one application of biotechnology is the \n directed use of microorganisms for the manufacture of\n organic products (examples include beer and milk products). ");
        alert.setTitle("Biotechnology");
        alert.showAndWait();
        AI.setOnAction(e -> new TechController().openFxmlFile(e, "AIpg.fxml"));
    }
    @FXML
    void init2() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "The internet is set up with the help of physical \n optical fiber data transmission cables or copper wires \n and various other networking mediums like LAN, WAN, MAN, etc.");
        alert.setTitle("Internet");
        alert.showAndWait();
        AI.setOnAction(e -> new TechController().openFxmlFile(e, "AIpg.fxml"));
    }
}

