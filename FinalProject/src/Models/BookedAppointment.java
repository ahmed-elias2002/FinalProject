/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Elias 
 */
public class BookedAppointment {

    private int id;
    private int app_id;
    private int user_id;
    private String status;
    private String doctor_comment;

    public BookedAppointment(int app_id, int user_id, String status, String doctor_comment) {
        this.app_id = app_id;
        this.user_id = user_id;
        this.status = status;
        this.doctor_comment = doctor_comment;
    }

    public int addBookesAppointment() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String sql = "INSERT INTO `booked_appointments`(`id`, `app_id`, `user_id`, `status`, `doctor_comment`) VALUES (?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setInt(2, this.getApp_id());
        ps.setInt(3, this.getUser_id());
        ps.setString(4, this.getStatus());
        ps.setString(5, this.getDoctor_comment());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return rows;
    }

    public static ArrayList<BookedAppointment> getAllBookedAppointments(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointment> bookedAppointments = new ArrayList<>();
        String sql = "SELECT * FROM booked_appointments WHERE user_id="+id;
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointment bookedAppointment = new BookedAppointment(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            bookedAppointment.setId(rs.getInt(1));
            bookedAppointments.add(bookedAppointment);
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return bookedAppointments;
    }

    public static ArrayList<BookedAppointment> getAllBookedAppointments() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointment> bookedAppointments = new ArrayList<>();
        String sql = "SELECT * FROM booked_appointments";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointment bookedAppointment = new BookedAppointment(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            bookedAppointment.setId(rs.getInt(1));
            bookedAppointments.add(bookedAppointment);
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return bookedAppointments;
    }

    public static ArrayList<BookedAppointment> getAllWaitingBookedAppointments(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointment> bookedAppointments = new ArrayList<>();
        String sql = "SELECT * FROM booked_appointments WHERE status='wainting'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointment bookedAppointment = new BookedAppointment(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            bookedAppointment.setId(rs.getInt(1));
            bookedAppointments.add(bookedAppointment);
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return bookedAppointments;
    }

    public static ArrayList<BookedAppointment> getAllFinishedBookedAppointments(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointment> bookedAppointments = new ArrayList<>();
        String sql = "SELECT * FROM booked_appointments WHERE status='finished'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointment bookedAppointment = new BookedAppointment(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            bookedAppointment.setId(rs.getInt(1));
            bookedAppointments.add(bookedAppointment);
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return bookedAppointments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor_comment() {
        return doctor_comment;
    }

    public void setDoctor_comment(String doctor_comment) {
        this.doctor_comment = doctor_comment;
    }

}
