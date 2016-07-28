/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javademo;

import java.sql.*;

/**
 * @name DbOperation
 * @author asif
 */
public class DbOperation {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    /**
     * show all students
     *
     * @author Asif
     * @name showStudents
     */
    public void showStudents() {

        try {
            // make the connection
            conn = ConnectionManager.getConnection();
            // create statement
            stmt = conn.createStatement();
            // db query
            String sql = "SELECT * FROM students";
            // execute the query
            rs = stmt.executeQuery(sql);

            System.out.println("DriverManagerTest Started....");

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String studentId = rs.getString("student_id");
                String name = rs.getString("name");
                String dept = rs.getString("dept");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Student Id: " + studentId);
                System.out.print(", Name: " + name);
                System.out.println(", Dept: " + dept);
            }
            System.out.println("DriverManagerTest End....");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * get a student
     *
     * @name getStudent
     * @param studentId
     * @return
     */
    public String getStudent(String studentId) {
        String value = null;

        try {
            // make the connection
            conn = ConnectionManager.getConnection();
            // create statement
            stmt = conn.createStatement();
            // db query
            String sql = "SELECT * FROM students where student_id ='" + studentId + "'";
            // execute the query
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                value = rs.getString("id");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }

    /**
     * check a student exist or not by student id and password
     *
     * @name checkLogin
     * @param studentId
     * @param password
     * @return
     */
    public int checkLogin(String studentId, String password) {

        int id = 0;

        try {
            // make the connection
            conn = ConnectionManager.getConnection();
            // create statement
            stmt = conn.createStatement();
            // db query
            String sql = "SELECT * FROM students where student_id ='" + studentId + "' and password='" + password + "'";
            // execute the query
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                id = rs.getInt("id");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    /**
     * add a student
     *
     * @name addStudent
     * @param stuId
     * @param pass
     * @param name
     * @param dept
     * @return
     */
    public int addStudent(String stuId, String pass, String name, String dept) {

        // check the student exist or not
        if (getStudent(stuId) != null) {
            return 2;
        }

        int count = 0;
        try {
            // make the connection
            conn = ConnectionManager.getConnection();

            // create statement
            stmt = conn.createStatement();

            String sql = "INSERT INTO students (student_id,password, name, dept) VALUES('" + stuId + "', '" + pass + "','" + name + "', '" + dept + "')";
            count = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (count > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * edit a student
     *
     * @name editStudent
     * @param stuId
     * @param name
     * @param dept
     * @return
     */
    public int editStudent(String stuId, String name, String dept) {
        int count = 0;
        try {
            // make the connection
            conn = ConnectionManager.getConnection();

            // create statement
            stmt = conn.createStatement();

            String sql = "update  students set name='" + name + "', dept='" + dept + "' where student_id ='" + stuId + "'";
            count = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (count > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * delete a specific student by unique id
     *
     * @author Asif
     * @name deleteStudent
     * @param stuId
     * @return
     */
    public int deleteStudent(String stuId) {
        int count = 0;
        try {
            // make the connection
            conn = ConnectionManager.getConnection();

            // create statement
            stmt = conn.createStatement();

            String sql = "delete from  students where student_id ='" + stuId + "'";
            count = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (count > 0) {
            return 1;
        }
        return 0;
    }

}
