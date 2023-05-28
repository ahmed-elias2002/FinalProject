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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Elias
 */
public class ShowAllAppointmentsController implements Initializable {

    public static Appointment selectedPatientToUpdate;
    public static Stage updateStage;
    public static Stage createStage;

    @FXML
    private TableColumn<Appointment, Time> tcTime;

    @FXML
    private Button btnOverview5;

    @FXML
    private TableColumn<Appointment, Date> tcDate;

    @FXML
    private Button btnOverview3;

    @FXML
    private TableView<Appointment> tableView;

    @FXML
    private TableColumn<Appointment, Integer> tcID;

    @FXML
    private TableColumn<Appointment, String> tcDay;

    @FXML
    private TableColumn<Appointment, String> tcStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetAll();
    }

    @FXML
    void showPatientHandle(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToShowPatientScene();
    }

    @FXML
    void showFreeAppointmentsHandle(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToShowFreeAppointmentsScene();
    }

    @FXML
    void showBookedAppointments(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToShowBookedAppointmentsScene();
    }

    @FXML
    void fefeff(ActionEvent event) {

    }

    @FXML
    void deletePatientHandle(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            Appointment appointment = tableView.getSelectionModel().getSelectedItem();
            appointment.deleteAppointment();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("No Selected Item!");
            alert.showAndWait();
            return;
        }
        resetAll();
    }

    @FXML
    void updatePatientHandle(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            selectedPatientToUpdate = tableView.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/AdminDashboard/UpdateAppointment.fxml"));
            Parent root = loader.load();
            updateStage = new Stage();
            updateStage.setScene(new Scene(root));
            updateStage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("No Selected Item!");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void createNewPatientHandle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/AdminDashboard/CreateAppointment.fxml"));
        Parent root = loader.load();
        createStage = new Stage();
        createStage.setScene(new Scene(root));
        createStage.show();
    }

    @FXML
    void logoutHandle(ActionEvent event) throws IOException {
        ViewManager.closeAdminPage();
        ViewManager.openPatientLoginPage();
    }

    public void resetAll() {
        try {
            ArrayList<Appointment> appointments = Appointment.getAllAppointments();

            tcID.setCellValueFactory(new PropertyValueFactory<>("app_id"));
            tcTime.setCellValueFactory(new PropertyValueFactory<>("app_time"));
            tcDay.setCellValueFactory(new PropertyValueFactory<>("app_day"));
            tcDate.setCellValueFactory(new PropertyValueFactory<>("app_date"));
            tcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            ObservableList<Appointment> data = FXCollections.observableArrayList(appointments);

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
