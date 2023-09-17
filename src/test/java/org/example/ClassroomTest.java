package org.example;

import junit.framework.TestCase;

public class ClassroomTest extends TestCase {

    public void testAddStudent() {
        Classroom classroom = new Classroom();

        Student student1 = new Student("Julio", "Rodriguez", new Double[]{100.00, 86.96});

        assertTrue(classroom.addStudent(student1));
    }

    public void testGetStudents() {
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