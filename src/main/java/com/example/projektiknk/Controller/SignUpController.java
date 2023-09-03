package com.example.projektiknk.Controller;

import Models.User;
import Services.UserAuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private TextField name;

    @FXML
    private AnchorPane main;

    @FXML
    private TextField surname;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirm;

    @FXML
    private DatePicker Date;

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton Female;

    @FXML
    private Button Login;

    @FXML
    private Button SignUp;

    @FXML
    private Label Gender;


    private UserAuthService userService;

    public SignUpController() {
        this.userService = new UserAuthService();
    }



    @FXML
    public void SignUpClick(ActionEvent e) {




        String username = this.name.getText();
        String surname = this.surname.getText();
       String password = this.password.getText();
       String Confirm = this.confirm.getText();
        LocalDate birthday = this.Date.getValue();



       if(username.isEmpty() && surname.isEmpty() && password.isEmpty() && Confirm.isEmpty() && birthday == null ) {
           showAlert("Error", "Please fill in all fields.", AlertType.ERROR);
           return;
       }
       if(!password.equals(Confirm)) {
           showAlert("Error", "Passwords do not match.", AlertType.ERROR);
           return;
       }

       if(password.length() < 8 && Confirm.length() <= 8) {
           showAlert("Error","Length Password must be 8 character or more",AlertType.ERROR);
           return ;
       }






        try{
            User user = userService.register(username, password);
            if(user == null){
                showAlert("Error", "Invalid registration.", AlertType.ERROR);
                return;

            }
             else {
                showAlert("Success", "User is inserted.", AlertType.INFORMATION);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @FXML
    private void gotoLogin(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    private void showAlert(String title, String content, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void translateclick(ActionEvent e) {
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

    private void translate() {
        Locale locale = Locale.getDefault();

        ResourceBundle translate = ResourceBundle.getBundle("Translation.content", locale);

        name.setPromptText(translate.getString("SignUp.TextField.setPromptText"));
        surname.setPromptText(translate.getString("SignUp1.TextField.setPromptText"));
        password.setPromptText(translate.getString("SignUp.PasswordField.setPromptText"));
        confirm.setPromptText(translate.getString("SignUp1.PasswordField.setPromptText"));
        Date.setPromptText(translate.getString("SignUp.DatePicker.setPromptText"));
        Male.setText(translate.getString("SignUp.RadioButton.setText"));
        Female.setText(translate.getString("SignUp1.RadioButton.setText"));
        Login.setText(translate.getString("Login.Button.setText"));
        SignUp.setText(translate.getString("SignUp.Button.setText"));
        Gender.setText(translate.getString("SignUp.Label.setText"));

        if (locale.getLanguage().equals("en")) {
            ((Stage) name.getScene().getWindow()).setTitle("SignUp");
        } else {
            ((Stage) name.getScene().getWindow()).setTitle("Regjistrohu");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        main.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.T) {
                translateclick(null);
            }
        });
    }
}





