/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.User;
import Views.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Ahmed Elias
 */
public class patientRegisterController implements Initializable {

    @FXML
    private TextField agetxt;

    @FXML
    private TextField emailtxt;

    @FXML
    private TextField firstNametxt;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private TextField lastNametxt;

    @FXML
    private PasswordField passwordtxt;

    @FXML
    private TextField phonetxt;

    @FXML
    private ToggleGroup roleGroup;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField userNametxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void submitBtn(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        String username = userNametxt.getText().trim();
        String password = passwordtxt.getText();
        String email = emailtxt.getText().trim();
        String firstName = firstNametxt.getText().trim();
        String lastName = lastNametxt.getText().trim();
        String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
        String role = ((RadioButton) roleGroup.getSelectedToggle()).getText();
        long phone = 0;
        int age = 0;
        try {
            phone = Long.parseLong(phonetxt.getText().trim());
            age = Integer.parseInt(agetxt.getText().trim());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setContentText("There's an error in your inputs!");
            alert.showAndWait();
        }
        if (username.equals("") || password.equals("") || email.equals("") || phone == 0 || firstName.equals("") || lastName.equals("") || age == 0 || gender.equals("") || role.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("Fill the filed!");
            alert.showAndWait();
            return;
        }
        User user = new User(username, password, firstName, lastName, age, email, phone, gender, role);
        user.addUser();
        ViewManager.openPatientLoginPage();
        ViewManager.closePatientRegistePage();
    }

}
