/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StartingPoint;

import Views.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Elias
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager.openPatientLoginPage();
    }

}
