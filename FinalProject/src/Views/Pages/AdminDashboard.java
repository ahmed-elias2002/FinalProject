/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Pages;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Elias
 */
public class AdminDashboard extends Stage {

    private Scene showPatientScene;
    private Scene showFreeAppointmentsScene;
    private Scene createAppointmentsScene;
    private Scene showBookedAppointmentsScene;

    public AdminDashboard() throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../AdminDashboard/ShowPatient.fxml"));
        Parent parent1 = loader1.load();
        showPatientScene = new Scene(parent1);

        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("../AdminDashboard/ShowFreeAppointments.fxml"));
        Parent parent3 = loader3.load();
        showFreeAppointmentsScene = new Scene(parent3);

        FXMLLoader loader4 = new FXMLLoader(getClass().getResource("../AdminDashboard/ShowAllAppointments.fxml"));
        Parent parent4 = loader4.load();
        createAppointmentsScene = new Scene(parent4);

        FXMLLoader loader5 = new FXMLLoader(getClass().getResource("../AdminDashboard/ShowBookedAppointments.fxml"));
        Parent parent5 = loader5.load();
        showBookedAppointmentsScene = new Scene(parent5);

        this.setScene(showPatientScene);
        this.setResizable(false);
        this.setTitle("Admin Dashboard");
    }

    public void changeSceneToShowPatientScene() {
        this.setScene(showPatientScene);
    }

    public void changeSceneToShowFreeAppointmentsScene() {
        this.setScene(showFreeAppointmentsScene);
    }

    public void changeSceneToCreateAppointmentsScene() {
        this.setScene(createAppointmentsScene);
    }

    public void changeSceneToShowBookedAppointmentsScene() {
        this.setScene(showBookedAppointmentsScene);
    }
}
