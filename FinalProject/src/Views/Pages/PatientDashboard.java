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
public class PatientDashboard extends Stage {

    private Scene patientShowBookedAppointments;
    private Scene patientShowFreeAppointments;

    public PatientDashboard() throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../PatientDashboard/PatientShowBookedAppointments.fxml"));
        Parent parent1 = loader1.load();
        patientShowBookedAppointments = new Scene(parent1);

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../PatientDashboard/PatientShowFreeAppointments.fxml"));
        Parent parent2 = loader2.load();
        patientShowFreeAppointments = new Scene(parent2);

        this.setScene(patientShowFreeAppointments);
        this.setResizable(false);
        this.setTitle("Patient Dashboard");
    }

    public void changeSceneToPatientShowFreeAppointmentsScene() {
        this.setScene(patientShowFreeAppointments);
    }

    public void changeSceneToPatientShowBookedAppointmentsScene() {
        this.setScene(patientShowBookedAppointments);
    }
}
