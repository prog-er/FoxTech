package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class SignUpController {

    @FXML
    private RadioButton female_radioBtn;

    @FXML
    private TextField gmail_txtField;

    @FXML
    private Button logInBtn;

    @FXML
    private RadioButton male_radioBtn;

    @FXML
    private RadioButton other_radioBtn;

    @FXML
    private PasswordField psw_txtField;

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField userName_txtField;

    @FXML
    private ToggleGroup tgGender;

    private boolean account_created = false;

    private int count_lines = 0;

    void showErrorMessage(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR, s);
        alert.setTitle("Error");
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        logInBtn.setOnAction(e -> new LoginController().openFxmlFile(e, "loginPage.fxml"));
        signUpBtn.setOnAction(e -> signup(e));
    }

    void signup(ActionEvent e) {
        createFolder();
        checkData();
        if (account_created)

            new LoginController().openFxmlFile(e, "loginPage.fxml");
    }

    void createFolder() {
        File folder = new File("folder");
        if (!folder.exists())
            folder.mkdir();
    }

    void checkData() {
        if (userName_txtField.getText().isEmpty() || psw_txtField.getText().isEmpty() || gmail_txtField.getText().isEmpty()) {
            showErrorMessage("username/password/email is empty");
        } else if (userName_txtField.getText().length() > 9 || psw_txtField.getText().length() > 9 ||
                gmail_txtField.getText().length() > 15) {
            showErrorMessage("username/password/email is not correct");
        } else if (!male_radioBtn.isSelected() && !female_radioBtn.isSelected() && !other_radioBtn.isSelected()) {
            showErrorMessage("gender is not selected");
        } else {
            logic();
        }
    }

    void logic() {
        if (userName_txtField.getText().equals(psw_txtField.getText())) {
            showErrorMessage("password is unsafe");
        } else {
            addData();
        }
    }

    void addData() {
        String name = "", password = "", email = "";
        File file = new File("folder/" + userName_txtField.getText() + ".txt");
        File alldata_file = new File("folder/alldata.txt");
        if (file.exists()) {
            showErrorMessage("the account same name already exist");
        } else {
            try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));) {
                name = userName_txtField.getText() + "\n";
                password = psw_txtField.getText() + "\n";
                email = gmail_txtField.getText() + "";
                dataOutputStream.writeUTF(name);
                dataOutputStream.writeUTF(password);
                dataOutputStream.writeUTF(email);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            countLines();
            String[] lines = new String[count_lines + 3];
            if (alldata_file.exists()) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new FileInputStream(alldata_file));
                    for (int i = 0; i < count_lines; i++)
                        lines[i] = dataInputStream.readUTF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            lines[count_lines] = name;
            lines[count_lines + 1] = password;
            lines[count_lines + 2] = email + "\n";
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(alldata_file, "rw");
                for (String line : lines)
                    randomAccessFile.writeUTF(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            new AfterLogin().infoMessage("Account Created Successfully");
            account_created = true;
        }
    }

    void countLines() {
        File file = new File("folder/alldata.txt");
        if (file.exists()) {
            try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
                while (true) {
                    dataInputStream.readUTF();
                    count_lines++;
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("the number of lines is " + count_lines);
    }
}