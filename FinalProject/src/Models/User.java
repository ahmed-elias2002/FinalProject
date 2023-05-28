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
 * @author Ahmed Eliass
 */
public class User {

    private int user_id;
    private String user_name;
    private String password;
    private String first_name;
    private String last_name;
    private int age;
    private String email;
    private long phone;
    private String gender;
    private String role;

    public User(String user_name, String password, String first_name, String last_name, int age, String email, long phone, String gender, String role) {
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }
    
      public User(int user_id,String user_name, String password, String first_name, String last_name, int age, String email, long phone, String gender, String role) {
      this.user_id = user_id;
          this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public int addUser() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String sql = "INSERT INTO `users`(`user_id`, `usre_name`, `password`, `first_name`, `last_name`, `age`, `email`, `phone`, `gender`, `role`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, this.getUser_id());
        ps.setString(2, this.getUser_name());
        ps.setString(3, this.getPassword());
        ps.setString(4, this.getFirst_name());
        ps.setString(5, this.getLast_name());
        ps.setInt(6, this.getAge());
        ps.setString(7, this.getEmail());
        ps.setLong(8, this.getPhone());
        ps.setString(9, this.getGender());
        ps.setString(10, this.getRole());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return rows;
    }

    public static ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'patient'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getLong(8), rs.getString(9), rs.getString(10));
            user.setUser_id(rs.getInt(1));
            users.add(user);
        }
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return users;
    }

    public int deleteUser() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String sql = "DELETE FROM `users` WHERE user_id=?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, this.getUser_id());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return rows;
    }

    public int updateUser() throws ClassNotFoundException, SQLException {
        Connection conn = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rows = 0;
        String sql = "UPDATE users SET `usre_name`=?, `password`=?, `first_name`=?, `last_name`=?, `age`=?, `email`=?, `phone`=?, `gender`=?, `role`=? WHERE user_id =?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, this.getUser_name());
        ps.setString(2, this.getPassword());
        ps.setString(3, this.getFirst_name());
        ps.setString(4, this.getLast_name());
        ps.setInt(5, this.getAge());
        ps.setString(6, this.getEmail());
        ps.setLong(7, this.getPhone());
        ps.setString(8, this.getGender());
        ps.setString(9, this.getRole());
        ps.setInt(10, this.getUser_id());
        rows = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        conn.close();
        return rows;

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

}
