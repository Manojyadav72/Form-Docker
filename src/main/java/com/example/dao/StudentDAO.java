package com.example.dao;

import com.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL =
            "jdbc:mysql://mysql:3306/studentdb";

    private static final String USER = "student";

    private static final String PASSWORD = "student123";


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }


    // CREATE
    public void insertStudent(Student student) {

        String sql =
                "INSERT INTO students(name,email,course) VALUES(?,?,?)";

        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // READ
    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));

                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    // GET BY ID
    public Student getStudent(int id) {

        Student student = null;

        String sql =
                "SELECT * FROM students WHERE id=?";

        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }


    // UPDATE
    public void updateStudent(Student student) {

        String sql =
                "UPDATE students SET name=?, email=?, course=? WHERE id=?";

        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // DELETE
    public void deleteStudent(int id) {

        String sql =
                "DELETE FROM students WHERE id=?";

        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}