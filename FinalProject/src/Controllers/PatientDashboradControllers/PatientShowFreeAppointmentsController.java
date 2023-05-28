/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.PatientDashboradControllers;

import Models.Appointment;
import Views.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ahmed Elias
 */
public class PatientShowFreeAppointmentsController implements Initializable {

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Appointment, String> tcDayAppointments;

    @FXML
    private TableColumn<Appointment, Integer> tcIdAppointments;

    @FXML
    private Button btnOverview5;

    @FXML
    private TableColumn<Appointment, Time> tcTimeAppointments;

    @FXML
    private TableColumn<Appointment, Date> tcDateAppointments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetAll();
    }

    @FXML
    void ShowFreeAppointmentsBtn(ActionEvent event) {
        ViewManager.patientDashboard.changeSceneToPatientShowFreeAppointmentsScene();
    }

    @FXML
    void ShowBookedAppointmentsBtn(ActionEvent event) {
        ViewManager.patientDashboard.changeSceneToPatientShowBookedAppointmentsScene();

    }

    @FXML
    void bookedAppointmentBtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        Appointment selectedAppointment = (Appointment) tableView.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            selectedAppointment.setStatus("booked");
            selectedAppointment.updateAppointment();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("No Item Selected!");
            alert.showAndWait();
        }
    }

    @FXML
    void logOutBtn(ActionEvent event) throws IOException {
        ViewManager.closePatientPage();
        ViewManager.openPatientLoginPage();
    }

    public void resetAll() {
        try {
            ArrayList<Appointment> Appointments = Appointment.getAllAppointments();
            tcIdAppointments.setCellValueFactory(new PropertyValueFactory<>("app_id"));
            tcDateAppointments.setCellValueFactory(new PropertyValueFactory<>("app_date"));
            tcDayAppointments.setCellValueFactory(new PropertyValueFactory<>("app_day"));
            tcTimeAppointments.setCellValueFactory(new PropertyValueFactory<>("app_time"));
            ObservableList<Appointment> data = FXCollections.observableArrayList(Appointments);
            tableView.setItems(data);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    void refreshHandle(ActionEvent event) {
        resetAll();
    }

}
