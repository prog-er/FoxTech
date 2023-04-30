package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.prefs.Preferences;

public class LoginController implements Initializable {

    public LoginController() {

    }
    @FXML
    private ImageView logo_img;
    @FXML
    private ImageView account_img;
    @FXML
    private Button logInBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private Label wrongLog;
    @FXML
    private TextField userName_txtField;

    @FXML
    private PasswordField psw_txtField;

    @FXML
    private Label lbl_admin;

    @FXML
    private Label lbl_forgot_psw;

    @FXML
    private CheckBox remember_check;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("img/foxtechlogo.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        logo_img.setImage(brandingImage);

        File accountFile = new File("img/login.png");
        Image accountImage = new Image(accountFile.toURI().toString());
        account_img.setImage(accountImage);
    }

//    Preferences preference;
//    boolean rememberPreference;
//
//    public void rememberMe(){
//        preference = Preferences.userNodeForPackage();
//        rememberPreference = preference.getBoolean("rememberMe",Boolean.valueOf(""));
//
//        if(rememberPreference){
//            userName_txtField.setText(preference.get("name",""));
//            psw_txtField.setText(preference.get("password",""));
//        }
//    }
    
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

    @FXML
    void initialize() {
        signUpBtn.setOnAction(e -> openFxmlFile(e, "SignUpPage.fxml"));
        lbl_admin.setOnMouseClicked(e -> openFxmlFile(e, "AdminPg.fxml"));
        lbl_admin.setOnMouseMoved(e -> lbl_admin.setTextFill(Color.ORANGE));
        lbl_admin.setOnMouseExited(e -> lbl_admin.setTextFill(Color.LIGHTGREY));
        lbl_forgot_psw.setOnMouseMoved(e -> lbl_forgot_psw.setTextFill(Color.ORANGE));
        lbl_forgot_psw.setOnMouseExited(e -> lbl_forgot_psw.setTextFill(Color.LIGHTGREY));
        logInBtn.setOnAction(e -> openFxmlFile(e, "afterLogin.fxml"));
        logInBtn.setOnMouseMoved(e -> logInBtn.setStyle("-fx-background-color: #ff9b30; "));
        logInBtn.setOnMouseExited(e -> logInBtn.setStyle("-fx-background-color: #ff5d1e; "));
        signUpBtn.setOnMouseMoved(e -> signUpBtn.setStyle("-fx-background-color: #ff5d1e;"));
        signUpBtn.setOnMouseExited(e -> signUpBtn.setStyle("-fx-background-color: transparent; -fx-border-radius: 20;-fx-border-color: #ff5d1e;"));
        remember_check.setOnMouseMoved(e -> remember_check.setTextFill(Color.LIGHTSKYBLUE));
        remember_check.setOnMouseExited(e -> remember_check.setTextFill(Color.WHITE));
        lbl_forgot_psw.setOnMouseClicked(e -> openFxmlFile(e, "ForgotPage.fxml"));



    }
}
