/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AdminDashboardControllers;

import Models.User;
import Views.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Elias
 */
public class ShowPatientControllers implements Initializable {

    public static User selectedAppointmentToUpdate;
    public static Stage updateStage;
    public static Stage createStage;

    @FXML
    private Button btnOverview31;

    @FXML
    private TableColumn<User, String> fullNameColumn;

    @FXML
    private Button btnOverview5;

    @FXML
    private TableColumn<User, String> tcLastName;

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> genderColumn;

    @FXML
    private TableColumn<User, Integer> agecolumn;

    @FXML
    private TableColumn<User, Long> phoneColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private Button btnOverview4;

    @FXML
    private Button btnOverview3;

    @FXML
    private Button btnOverview2;

    @FXML
    private TableColumn<User, String> emailcolumn;

    @FXML
    private Button btnOverview;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetAll();
    }

    @FXML
    void showFreeAppointments(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToShowFreeAppointmentsScene();
    }

    @FXML
    void createAppointmentsHandle(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToCreateAppointmentsScene();
    }

    @FXML
    void showBookedAppointments(ActionEvent event) {
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

    @FXML
    void searchBtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        String searchkey = textField.getText();
        ArrayList<User> users = User.getAllUsers();
        ArrayList<User> result = new ArrayList<>();
        for (User u : users) {
            if (u.getFirst_name().equals(searchkey)) {
                result.add(u);
            }
        }
        ObservableList<User> data = FXCollections.observableArrayList(result);
        tableView.setItems(data);
    }

    @FXML
    void createNewPatientHandle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/AdminDashboard/createUserPage.fxml"));
        Parent root = loader.load();
        createStage = new Stage();
        createStage.setScene(new Scene(root));
        createStage.show();
    }

    @FXML
    void updatePatientHandle(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            selectedAppointmentToUpdate = tableView.getSelectionModel().getSelectedItem();
            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("../Views/AdminDashboard/UpdateUserPage.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            updateStage = new Stage();
            updateStage.setScene(new Scene(rootUpdate));
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
    void deletePatientHandle(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            User user = tableView.getSelectionModel().getSelectedItem();
            user.deleteUser();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("No Selected Item!");
            alert.showAndWait();
            return;
        }
        resetAll();
    }

    public void resetAll() {
        try {
            ArrayList<User> users = User.getAllUsers();
            usernameColumn.setCellValueFactory(new PropertyValueFactory<>("user_name"));
            fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            tcLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            agecolumn.setCellValueFactory(new PropertyValueFactory<>("age"));
            phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            ObservableList<User> data = FXCollections.observableArrayList(users);
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
