package org.example;

public class Classroom {
    private Student[] students;

    public void addStudent(){
        this.students[students.length - 1];
    }

    public Classroom(int maxStudents) {
        this.students = new Student[maxStudents];
    }

    public Classroom(Student[] students){
        this.students = students;
    }

    public Classroom(){
        this(30);
    }


}
