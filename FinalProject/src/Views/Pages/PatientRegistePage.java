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
public class PatientRegistePage extends Stage {

    public PatientRegistePage() throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../patientRegister.fxml"));
        Parent parent = loder.load();
        this.setTitle("Patient Register");
        this.setResizable(false);
        this.setScene(new Scene(parent));
    }
}
