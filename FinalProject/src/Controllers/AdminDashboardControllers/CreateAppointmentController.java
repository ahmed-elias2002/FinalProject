/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AdminDashboardControllers;

import Models.Appointment;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Ahmed Elias
 */
public class CreateAppointmentController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private RadioButton freeBtn;

    @FXML
    private TextField dateTextField;

    @FXML
    private ToggleGroup statusGroup;

    @FXML
    private TextField dayTextField;

    @FXML
    private RadioButton bookedBtn;

    @FXML
    private TextField timeTextField;

    @FXML
    void saveHandle(ActionEvent event) throws ClassNotFoundException, ParseException, SQLException {
        String date = dateTextField.getText().trim();
        String time = timeTextField.getText().trim();
        String day = dayTextField.getText().trim();
        String status = ((RadioButton) statusGroup.getSelectedToggle()).getText();
        if (date.equals("") || time.equals("") || day.equals("") || status.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("fill the filed!");
            alert.showAndWait();
            return;
        }
        Appointment appointments = new Appointment(date, day, time, status);
        appointments.addAppointment();
        ShowAllAppointmentsController.createStage.close();
    }

}
