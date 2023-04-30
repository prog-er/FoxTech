package com.example.project2;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.*;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForgotController implements Initializable {


    @FXML
    private Button backBtn;

    @FXML
    private ImageView account_img;
    @FXML
    private ImageView logo_img;
    @FXML
    private PasswordField psw_txtField;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField userName_txtField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("img/foxtechlogo.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        logo_img.setImage(brandingImage);

        File accountFile = new File("img/login.png");
        Image accountImage = new Image(accountFile.toURI().toString());
        account_img.setImage(accountImage);
    }
    @FXML
    void initialize(MouseEvent event) throws IOException {
        backBtn.setOnAction(e -> new LoginController().openFxmlFile(e, "loginPage.fxml"));
        submitBtn.setOnAction(e -> {
            try {
                forgot(e);
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    void forgot(ActionEvent e) throws IOException {
        File file = new File("folder/" + userName_txtField.getText() + ".txt");
        if (file.exists()) {
            String name = "";
            String pass = "";
            String email = "";
            try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
                name = inputStream.readUTF();
                pass = inputStream.readUTF();
                email = inputStream.readUTF();
            }
            try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file))) {
                outputStream.writeUTF(name);
                outputStream.writeUTF(psw_txtField.getText() + "\n");
                outputStream.writeUTF(email);
            }
            new AfterLogin().infoMessage("Password Successful renamed");
            new LoginController().openFxmlFile(e, "loginPage.fxml");

        } else {
            new SignUpController().showErrorMessage("Username isn't");
        }
    }
}




