package com.example.project2;


import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;

public class Admin {

    @FXML
    private Button AdminBtn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Button logInBtn;

    @FXML
    private Label wrong;

    @FXML
    void userLogin(ActionEvent event) {

    }
    @FXML
    void initialize() {
        logInBtn.setOnAction(e -> new LoginController().openFxmlFile(e, "loginPage.fxml"));
        AdminBtn.setOnAction(e -> admin());
    }
    void admin() {

        if(username.getText().toString().equals("I am admin") && password.getText().toString().equals("admin")) {
            AdminBtn.setOnMouseClicked(e -> new LoginController().openFxmlFile(e, "afterLogin.fxml"));
        } else if (username.getText().isEmpty()&& password.getText().isEmpty()){
            wrong.setText("Please enter your data");
        }else{
            wrong.setText("Wrong username or password");
        }
    }
}




