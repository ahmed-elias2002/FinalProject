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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Ahmed Elias
 */
public class UpdateAppointmentController implements Initializable {

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

    private Appointment oldAppointment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        oldAppointment = ShowAllAppointmentsController.selectedPatientToUpdate;
        if (oldAppointment != null) {
            dateTextField.setText(oldAppointment.getApp_date());
            timeTextField.setText(oldAppointment.getApp_time());
            dayTextField.setText(oldAppointment.getApp_day());
            RadioButton status = oldAppointment.getStatus().equals("free") ? freeBtn : bookedBtn;
            statusGroup.selectToggle(status);
        }
    }
    
    @FXML
    void saveHandle(ActionEvent event) throws ClassNotFoundException, ParseException, SQLException {
        String date = dateTextField.getText();
        String time = timeTextField.getText();
        String day = dayTextField.getText();
        String status = ((RadioButton) statusGroup.getSelectedToggle()).getText();
        Appointment appointments = new Appointment(oldAppointment.getApp_id(),date, day, time, status);
        appointments.updateAppointment();
        oldAppointment = ShowAllAppointmentsController.selectedPatientToUpdate = null;
        ShowAllAppointmentsController.updateStage.close();
    }

}
