package com.example.projektiknk.Controller;

import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import Services.UserService;
import Interface.UserServiceInterface;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button Login;

    @FXML
    private ToggleButton Translate;

    @FXML
    private Button SignUp;
    private boolean accessGranted = false;

    private UserServiceInterface userService;

    public LoginController() {
        this.userService = new UserService();
    }

    @FXML
    private void loginClick(ActionEvent e) {


        String username = this.username.getText();
        String password = this.password.getText();


        if (username.isEmpty() && password.isEmpty()) {
            showAlert("Error", "Fill the Fields", Alert.AlertType.ERROR);
        }


        try {
            User user = userService.login(username, password);
            if (user == null) {
                showAlert("Error", "Invalid Login", Alert.AlertType.ERROR);
            } else {
                accessGranted = true;
                showAlert("Sucess", "Login Sucessful", Alert.AlertType.INFORMATION);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @FXML

    public void gotoSignUp(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("SignUp");
        stage.show();
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    @FXML
    private void translateClick(ActionEvent e) {
        Locale currentLocale = Locale.getDefault();
        if (currentLocale.getLanguage().equals("en")) {
            Locale newLocale = new Locale("sq");
            Locale.setDefault(newLocale);
        } else {
            Locale newLocale = new Locale("en");
            Locale.setDefault(newLocale);
        }
        translate();
    }

    public void translate() {
        Locale locale = Locale.getDefault();

        ResourceBundle translate = ResourceBundle.getBundle("Translation.content", locale);

        username.setPromptText(translate.getString("Login.TextField.setPromptText"));
        password.setPromptText(translate.getString("Login.PasswordField.setPromptText"));
        Login.setText(translate.getString("Login.Button.setText"));
        SignUp.setText(translate.getString("SignUp.Button.setText"));
        Translate.setText(translate.getString("Translate.ToggleButton.setText"));
        // Përkthe të tjerat elemente në aplikacion sipas nevojës

        if (locale.getLanguage().equals("en")) {
            ((Stage) username.getScene().getWindow()).setTitle("Login");
        } else {
            ((Stage) username.getScene().getWindow()).setTitle("Kyqja");
        }
    }
    }




