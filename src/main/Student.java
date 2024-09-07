package main;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
    private String studentId;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentCourse;

    private static ArrayList<Student> studentList = new ArrayList<>();

    public Student(String studentId, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }

    public static void saveStudent(String id, String name, int age, String email, String course) {
        Student newStudent = new Student(id, name, age, email, course);
        studentList.add(newStudent);
    }

    public static Student searchStudent(String studentId) {
        for (Student student : studentList) {
            if (student.studentId.equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public static void deleteStudent(String studentId) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.studentId.equals(studentId)) {
                iterator.remove();
                return;
            }
        }
    }

    public static void clearStudentList() {
        studentList.clear();
    }

    public static boolean isValidAge(int age) {
        return age >= 16;
    }

    public static Student getStudentById(String studentId) {
        return searchStudent(studentId);
    }

    // Getters for testing purposes
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public static ArrayList<Student> getStudentList() {
    return studentList;
}
}

