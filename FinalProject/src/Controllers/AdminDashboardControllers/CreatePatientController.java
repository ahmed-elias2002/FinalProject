/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AdminDashboardControllers;

import Models.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Ahmed Elias
 */
public class CreatePatientController implements Initializable {
    
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private ToggleGroup genderGroup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void saveHandle(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (usernameTextField.getText().trim().equals("") || passwordTextField.getText().equals("") || firstNameTextField.getText().trim().equals("") || lastNameTextField.getText().trim().equals("") || Integer.parseInt(ageTextField.getText().trim()) == 0 || emailTextField.getText().trim().equals("") || Long.parseLong(phoneTextField.getText().trim()) == 0 || ((RadioButton) genderGroup.getSelectedToggle()).getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("Fill the filed!");
            alert.showAndWait();
            return;
        }
        User user = new User(usernameTextField.getText().trim(), passwordTextField.getText().trim(), firstNameTextField.getText().trim(), lastNameTextField.getText().trim(), Integer.parseInt(ageTextField.getText().trim()), emailTextField.getText().trim(), Long.parseLong(phoneTextField.getText().trim()), ((RadioButton) genderGroup.getSelectedToggle()).getText(), "patient");
        user.addUser();
        ShowPatientControllers.createStage.close();
    }
    
}
