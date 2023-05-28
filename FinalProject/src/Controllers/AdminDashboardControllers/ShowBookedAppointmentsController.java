/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AdminDashboardControllers;

import Models.BookedAppointment;
import Models.DB;
import Models.User;
import Views.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class ShowBookedAppointmentsController implements Initializable {

    public static Stage commentStage;
    public static BookedAppointment selectBookedAppointment;

    @FXML
    private TableColumn<BookedAppointment, Integer> idColumn;

    @FXML
    private TableColumn<BookedAppointment, String> statusColumn;

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
    private TextField textField;

    @FXML
    private TableView<BookedAppointment> tableView;

    @FXML
    void CommmentHandle(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("No Selected Item!");
            alert.showAndWait();
            return;
        } else if (tableView.getSelectionModel().getSelectedItem().getStatus().equals("wainting")) {
            selectBookedAppointment = tableView.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/commentBookedAppointment.fxml"));
            Parent root = loader.load();
            commentStage = new Stage();
            commentStage.setScene(new Scene(root));
            commentStage.show();
        } else if (tableView.getSelectionModel().getSelectedItem().getStatus().equals("finished")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("The status is finished!");
            alert.showAndWait();
            return;
        }
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
    void createAppointmentsHandle(ActionEvent event) {
        ViewManager.adminDashboard.changeSceneToCreateAppointmentsScene();
    }

    @FXML
    void logoutHandle(ActionEvent event) throws IOException {
        ViewManager.closeAdminPage();
        ViewManager.openPatientLoginPage();
    }

    @FXML
    void fefeff(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetAll();
    }

    @FXML
    void searchBtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        String searchkey = textField.getText();
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE first_name='" + searchkey + "'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        boolean isRetuen = rs.next();
        int userId;
        if (isRetuen) {
            userId = rs.getInt(1);
        } else {
            return;
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        ArrayList<BookedAppointment> bookedAppointments = BookedAppointment.getAllBookedAppointments(userId);
        ObservableList<BookedAppointment> data = FXCollections.observableArrayList(bookedAppointments);
        tableView.setItems(data);
    }

    public void resetAll() {
        try {
            ArrayList<BookedAppointment> bookedAppointments = BookedAppointment.getAllBookedAppointments();
            idColumn.setCellValueFactory(new PropertyValueFactory<>("app_id"));
            statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
            ObservableList<BookedAppointment> data = FXCollections.observableArrayList(bookedAppointments);
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
