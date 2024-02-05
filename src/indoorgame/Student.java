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
// Student.java
public class Student {
    private int studentId;
    private String studentName;
    private String studentID;

    public Student(int studentId, String studentName, String studentID) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public Student(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    // Getter methods
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }
}
