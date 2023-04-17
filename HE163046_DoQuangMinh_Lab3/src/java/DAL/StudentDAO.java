/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author fsoft
 */
public class StudentDAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Student> getStudents() {

        try {
            String sql = "select * from  Student";

            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4)));
            }
            return students;
        } catch (Exception ex) {

        }
        return null;
    }

    public Student getStudent(int id) {
        try {
            String sql = "SELECT * FROM Student \n"
                    + "WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {

                return new Student(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertStudent(String name, boolean gender, String date) {
        try {
            String sql = "INSERT INTO [Student]\n"
                    + "           ([Name]\n"
                    + "           ,[Gender]\n"
                    + "           ,[Dob])\n"
                    + "     VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setBoolean(2, gender);
            statement.setString(3, date);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStudent(String name, boolean gender, String date,int id) {
        try {
            String sql = "UPDATE [Student]\n"
                    + "   SET [Name] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[Dob] = ?\n"
                    + " WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setBoolean(2, gender);
            statement.setString(3, date);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudent(int id) {
        try {
            String sql = "delete from student where id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
