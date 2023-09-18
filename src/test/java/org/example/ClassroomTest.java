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
        Classroom classroom2 = new Classroom();

        Student student2 = new Student("Jon", "Wick", new Double[]{80.00, 100.00, 95.00});

        classroom2.addStudent(student2);

//        classroom2.removeStudent(student2);

        classroom2.removeStudent(student2);

        assertEquals(0, classroom2.getHeadCount());
    }

    public void testGetHeadCount() {
    }

    public void testStudentNotNull() {
    }
}