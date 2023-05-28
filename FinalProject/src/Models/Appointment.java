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
public class Appointment {

    private int app_id;
    private String app_date;
    private String app_day;
    private String app_time;
    private String status;

    public Appointment(String app_date, String app_day, String app_time, String status) {
        this.app_date = app_date;
        this.app_day = app_day;
        this.app_time = app_time;
        this.status = status;
    }

    public Appointment(int app_id, String app_date, String app_day, String app_time, String status) {
        this.app_id = app_id;
        this.app_date = app_date;
        this.app_day = app_day;
        this.app_time = app_time;
        this.status = status;
    }

    public int addAppointment() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String sql = "INSERT INTO `appointments`(`app_id`, `app_date`, `app_day`, `app_time`, `status`)  VALUES (?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, this.getApp_id());
        ps.setString(2, this.getApp_date());
        ps.setString(3, this.getApp_day());
        ps.setString(4, this.getApp_time());
        ps.setString(5, this.getStatus());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return rows;
    }

    public static ArrayList<Appointment> getAllAppointments() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Appointment appointment = new Appointment(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            appointment.setApp_id(rs.getInt(1));
            appointments.add(appointment);
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return appointments;
    }

    public static ArrayList<Appointment> getFreeAppointments() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE status='free'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Appointment appointment = new Appointment(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            appointment.setApp_id(rs.getInt(1));
            appointments.add(appointment);
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return appointments;
    }

    public int deleteAppointment() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String sql = "DELETE FROM `appointments` WHERE app_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, this.getApp_id());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return rows;
    }

    public int updateAppointment() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String sql = "UPDATE `appointments` SET `app_date`=?,`app_day`=?,`app_time`=?,`status`=? WHERE `app_id`=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, this.getApp_date());
        ps.setString(2, this.getApp_day());
        ps.setString(3, this.getApp_time());
        ps.setString(4, this.getStatus());
        ps.setInt(5, this.getApp_id());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return rows;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getApp_date() {
        return app_date;
    }

    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }

    public String getApp_day() {
        return app_day;
    }

    public void setApp_day(String app_day) {
        this.app_day = app_day;
    }

    public String getApp_time() {
        return app_time;
    }

    public void setApp_time(String app_time) {
        this.app_time = app_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
