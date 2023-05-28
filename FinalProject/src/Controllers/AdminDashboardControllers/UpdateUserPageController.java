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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Ahmed Elias
 */
public class UpdateUserPageController implements Initializable {

    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField firstNameTextField;
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

    @FXML
    private RadioButton maleBtn;

    @FXML
    private RadioButton femaleBtn;

    private User oldPatient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        oldPatient = ShowPatientControllers.selectedAppointmentToUpdate;
        if (oldPatient != null) {
            lastNameTextField.setText(oldPatient.getLast_name());
            firstNameTextField.setText(oldPatient.getFirst_name());
            emailTextField.setText(oldPatient.getEmail());
            ageTextField.setText(String.valueOf(oldPatient.getAge()));
            usernameTextField.setText(oldPatient.getUser_name());
            phoneTextField.setText(String.valueOf(oldPatient.getPhone()));
            RadioButton gender = oldPatient.getGender().equals("male") ? maleBtn : femaleBtn;
            genderGroup.selectToggle(gender);
        }
    }

    @FXML
    private void saveHandle(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (oldPatient != null) {
            User user = new User(oldPatient.getUser_id(), usernameTextField.getText(), oldPatient.getPassword(), firstNameTextField.getText(), lastNameTextField.getText(), Integer.parseInt(ageTextField.getText()), emailTextField.getText(), Long.parseLong(phoneTextField.getText()), ((RadioButton) genderGroup.getSelectedToggle()).getText(), "patient");
            user.updateUser();
            oldPatient = ShowPatientControllers.selectedAppointmentToUpdate = null;
            ShowPatientControllers.updateStage.close();
        } else {
        }
    }

}
