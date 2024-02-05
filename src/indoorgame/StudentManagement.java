/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indoorgame;

/**
 *
 * @author nazmul
 */
// StudentManagement.java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private final DatabaseIntegration databaseIntegration;

    public StudentManagement(DatabaseIntegration databaseIntegration) {
        this.databaseIntegration = databaseIntegration;
    }

    public void registerStudent(Student student) {
        databaseIntegration.executeUpdate("INSERT INTO students (studentName, studentID) VALUES ('"
                + student.getStudentName() + "', '" + student.getStudentID() + "')");
    }

    public void modifyStudent(Student student) {
        databaseIntegration.executeUpdate("UPDATE students SET studentName = '" + student.getStudentName()
                + "', studentID = '" + student.getStudentID() + "' WHERE studentId = " + student.getStudentId());
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String selectQuery = "SELECT * FROM students";
        try (ResultSet resultSet = databaseIntegration.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName");
                String studentID = resultSet.getString("studentID");
                students.add(new Student(studentId, studentName, studentID));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
        return students;
    }
}
