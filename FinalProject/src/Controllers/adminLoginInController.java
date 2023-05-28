/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.DB;
import Views.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Ahmed Elias
 */
public class adminLoginInController implements Initializable {

    @FXML
    private TextField userNametxt;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordtxt;

    @FXML
    private Button patientSignInBtn;

    @FXML
    private Button signUpBtn;

    static int userID;

    @FXML
    void loginBtn(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String userName = userNametxt.getText().trim();
        String password = passwordtxt.getText();
        if (userName.equals("") || password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("Fill the filed!");
            alert.showAndWait();
            return;
        }
        String sql = "SELECT * FROM users WHERE role = 'admin' AND usre_name='" + userName + "' AND password='" + password + "'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        boolean isRight = rs.next();
        if (isRight) {
            ViewManager.openAdminDashboard();
            ViewManager.closeAdminLoginPage();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setContentText("There's an error in username or password!");
            alert.showAndWait();
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
    }

    @FXML
    void patientSignInBtnAction(ActionEvent event) throws IOException {
        ViewManager.openPatientLoginPage();
        ViewManager.closeAdminLoginPage();
    }

    @FXML
    void signUpBtn(ActionEvent event) throws IOException {
        ViewManager.openPatientRegistePage();
        ViewManager.closeAdminLoginPage();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
