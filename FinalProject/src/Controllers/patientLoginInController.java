/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author Ahmed Elias
 */
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

public class patientLoginInController implements Initializable {

    @FXML
    private Button SignUpBtn;

    @FXML
    private Button adminSignInBtn;

    @FXML
    private TextField usreNametxt;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordtxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void loginBtn(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String userName = usreNametxt.getText().trim();
        String password = passwordtxt.getText();
        if (userName.equals("") || password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("Fill the filed!");
            alert.showAndWait();
            return;
        }
        String sql = "SELECT * FROM users WHERE usre_name='" + userName + "' AND role='patient' AND password='" + password + "'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        boolean isRight = rs.next();
        if (isRight) {
            ViewManager.openPatientDashboard();
            ViewManager.closePatientLoginPage();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erorr!");
            alert.setContentText("Fill the filed!");
            alert.showAndWait();
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();

    }

    @FXML
    void SignUpBtn(ActionEvent event) throws IOException {
        ViewManager.openPatientRegistePage();
        ViewManager.closePatientLoginPage();
    }

    @FXML
    void adminSignInBtn(ActionEvent event) throws IOException {
        ViewManager.openPAdminLoginPage();
        ViewManager.closePatientLoginPage();
    }
}
