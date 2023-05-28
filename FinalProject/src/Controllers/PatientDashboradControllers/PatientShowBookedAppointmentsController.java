/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.PatientDashboradControllers;

import Models.BookedAppointment;
import Views.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ahmed Elias
 */
public class PatientShowBookedAppointmentsController implements Initializable {

    @FXML
    private ToggleGroup appointmentsStatusGroup;

    @FXML
    private TableColumn<BookedAppointment, String> tcComment;

    @FXML
    private Button btnOverview5;

    @FXML
    private TableView<BookedAppointment> tableView;

    @FXML
    private TableColumn<BookedAppointment, String> tcStatusAppointments;

    @FXML
    private TableColumn<BookedAppointment, Integer> tcIdDoctor;

    @FXML
    private TableColumn<BookedAppointment, Integer> tcIdAppointments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetAll();
    }

    @FXML
    void ShowFreeAppointmentsBtnHandle(ActionEvent event) {
        ViewManager.patientDashboard.changeSceneToPatientShowFreeAppointmentsScene();

    }

    @FXML
    void handleClicks(ActionEvent event) {

    }

    @FXML
    void fefeff(ActionEvent event) {
    }

    @FXML
    void WaitingAppointmentsHandle(ActionEvent event) throws ClassNotFoundException, SQLException {
        ArrayList<BookedAppointment> bookedAppointment;
        bookedAppointment = BookedAppointment.getAllWaitingBookedAppointments(1);
        tcIdAppointments.setCellValueFactory(new PropertyValueFactory<>("app_id"));
        tcIdDoctor.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        tcStatusAppointments.setCellValueFactory(new PropertyValueFactory<>("status"));
        tcComment.setCellValueFactory(new PropertyValueFactory<>("doctor_comment"));
        ObservableList<BookedAppointment> data = FXCollections.observableArrayList(bookedAppointment);
        tableView.setItems(data);
    }

    @FXML
    void FinishedAppointmentsHandle(ActionEvent event) throws ClassNotFoundException, SQLException {
        ArrayList<BookedAppointment> bookedAppointment;
        bookedAppointment = BookedAppointment.getAllFinishedBookedAppointments(1);
        tcIdAppointments.setCellValueFactory(new PropertyValueFactory<>("app_id"));
        tcIdDoctor.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        tcStatusAppointments.setCellValueFactory(new PropertyValueFactory<>("status"));
        tcComment.setCellValueFactory(new PropertyValueFactory<>("doctor_comment"));
        ObservableList<BookedAppointment> data = FXCollections.observableArrayList(bookedAppointment);
        tableView.setItems(data);
    }

    @FXML
    void logOutBtn(ActionEvent event) throws IOException {
        ViewManager.closePatientPage();
        ViewManager.openPatientLoginPage();
    }

    @FXML
    void refreshHandle(ActionEvent event) {
        resetAll();
    }

    public void resetAll() {
        ArrayList<BookedAppointment> bookedAppointment;
        try {
            bookedAppointment = BookedAppointment.getAllWaitingBookedAppointments(1);
            tcIdAppointments.setCellValueFactory(new PropertyValueFactory<>("app_id"));
            tcIdDoctor.setCellValueFactory(new PropertyValueFactory<>("user_id"));
            tcStatusAppointments.setCellValueFactory(new PropertyValueFactory<>("status"));
            tcComment.setCellValueFactory(new PropertyValueFactory<>("doctor_comment"));
            ObservableList<BookedAppointment> data = FXCollections.observableArrayList(bookedAppointment);
            tableView.setItems(data);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientShowBookedAppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PatientShowBookedAppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
