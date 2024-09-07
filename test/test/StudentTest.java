
package test;

import main.Student;  // Adjust the import based on your package structure
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Before
    public void setUp() {
        Student.clearStudentList();  // Clear the student list before each test
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        Student.saveStudent(student.getStudentId(), student.getStudentName(), student.getStudentAge(), student.getStudentEmail(), student.getStudentCourse());
        
        Student savedStudent = Student.getStudentById("10111");
        assertNotNull("Student should be saved and found", savedStudent);
        assertEquals("Student name should match", student.getStudentName(), savedStudent.getStudentName());
        assertEquals("Student age should match", student.getStudentAge(), savedStudent.getStudentAge());
        assertEquals("Student email should match", student.getStudentEmail(), savedStudent.getStudentEmail());
        assertEquals("Student course should match", student.getStudentCourse(), savedStudent.getStudentCourse());
    }

    @Test
    public void testSearchStudent() {
        Student student = new Student("10112", "J.Doe", 21, "jdoe@ymail.com", "disd");
        Student.saveStudent(student.getStudentId(), student.getStudentName(), student.getStudentAge(), student.getStudentEmail(), student.getStudentCourse());
        
        Student foundStudent = Student.searchStudent("10112");
        assertNotNull("Student should be found", foundStudent);
        assertEquals("Student name should match", student.getStudentName(), foundStudent.getStudentName());
        assertEquals("Student age should match", student.getStudentAge(), foundStudent.getStudentAge());
        assertEquals("Student email should match", student.getStudentEmail(), foundStudent.getStudentEmail());
        assertEquals("Student course should match", student.getStudentCourse(), foundStudent.getStudentCourse());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        Student student = Student.searchStudent("99999");
        assertNull("Student with given ID should not be found", student);
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("10113", "P.Parker", 20, "spidey@ymail.com", "disn");
        Student.saveStudent(student.getStudentId(), student.getStudentName(), student.getStudentAge(), student.getStudentEmail(), student.getStudentCourse());
        
        Student.deleteStudent("10113");
        Student deletedStudent = Student.getStudentById("10113");
        assertNull("Student should be deleted and not found", deletedStudent);
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        Student.deleteStudent("99999");
        // No assertion needed; deletion of a non-existent student should not throw an exception
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        assertTrue("Age 16 should be valid", Student.isValidAge(16));
        assertTrue("Age 25 should be valid", Student.isValidAge(25));
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        assertFalse("Age 15 should be invalid", Student.isValidAge(15));
        assertFalse("Age 10 should be invalid", Student.isValidAge(10));
    }
}

