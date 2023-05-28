/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AdminDashboardControllers;

import Models.BookedAppointment;
import Models.DB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

/**
 *
 * @author Ahmed Elias
 */
public class CommentAppointmentBookedController implements Initializable {

    @FXML
    private TextArea textArea;

    private BookedAppointment oldBookedAppointment;

    @FXML
    void CommmentHandle(ActionEvent event) throws ClassNotFoundException, SQLException {
        oldBookedAppointment = ShowBookedAppointmentsController.selectBookedAppointment;
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String comment = textArea.getText().trim();
        if (comment.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("Fill the text area!");
            alert.showAndWait();
            return;
        }
        String sql = "UPDATE `booked_appointments` SET `doctor_comment`=?, status='finished' WHERE id=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, comment);
        ps.setInt(2, oldBookedAppointment.getId());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        oldBookedAppointment = ShowBookedAppointmentsController.selectBookedAppointment = null;
        ShowBookedAppointmentsController.commentStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
