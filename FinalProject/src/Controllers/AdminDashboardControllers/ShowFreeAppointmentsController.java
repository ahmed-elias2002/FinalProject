/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AdminDashboardControllers;

import Models.Appointment;
import Views.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ahmed Elias
 */
public class ShowFreeAppointmentsController implements Initializable {

    @FXML
    private TableColumn<Appointment, String> timeColumn1;

    @FXML
    private TableColumn<Appointment, String> dayColumn;

    @FXML
    private Button btnOverview31;

    @FXML
    private Button btnOverview5;

    @FXML
    private Button btnOverview4;

    @FXML
    private Button btnOverview3;

    @FXML
    private Button btnOverview2;

    @FXML
    private Button btnOverview;

    @FXML
    private TableColumn<Appointment, String> dateColumn;

    @FXML
    private TableColumn<Appointment, Integer> idColumn;

    @FXML
    private TableView tableView;

    @FXML
    void showPatientHandle(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToShowPatientScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetAll();
    }

    @FXML
    void createAppointmentsHandle(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToCreateAppointmentsScene();
    }

    @FXML
    void showBookedAppointmentsHandle(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToShowBookedAppointmentsScene();
    }

    @FXML
    void logoutHandle(ActionEvent event) throws IOException {
        ViewManager.closeAdminPage();
        ViewManager.openPatientLoginPage();
    }

    @FXML
    void fefeff(ActionEvent event) {

    }

    public void resetAll() {
        try {
            ArrayList<Appointment> Appointments = Appointment.getFreeAppointments();
            idColumn.setCellValueFactory(new PropertyValueFactory<>("app_id"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("app_date"));
            dayColumn.setCellValueFactory(new PropertyValueFactory<>("app_day"));
            timeColumn1.setCellValueFactory(new PropertyValueFactory<>("app_time"));
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
