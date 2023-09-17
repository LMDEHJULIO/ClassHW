package org.example;

import junit.framework.TestCase;

public class ClassroomTest extends TestCase {

    Classroom classroom = new Classroom();

    Student student1 = new Student("Julio", "Rodriguez", new Double[]{100.00, 86.96});

    public void testAddStudent() {
        assertTrue(classroom.addStudent(student1));
    }

    public void testGetStudents() {
        classroom.addStudent(student1);

        String expected = student1.toString();
        String actual = classroom.getStudents();

        assertEquals(expected, actual);
    }

    public void testGetAverageScore() {
    }

    public void testGetStudentsByScore() {
    }

    public void testGetGradeBook() {
    }

    public void testRemoveStudent() {
    }

    public void testGetHeadCount() {
    }

    public void testStudentNotNull() {
    }
}