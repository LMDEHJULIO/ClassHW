package org.example;

import java.util.Arrays;

public class Classroom {
    private Student[] students;

    public boolean addStudent(Student newStudent){
        for(int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = newStudent;
                return true;
            }
        }
        System.out.println("Enrollment full.");
        return false;
    }

    public String getStudents(){
        String studentString = "";
        for(Student student : this.students){
            if(student != null) {
                studentString += student.toString();
            }

        }
        return studentString;
    }

    public Double getAverageScore(){
        double classAvg = 0.0;

        for(Student student : this.students){
            classAvg += student.getAverageExamScore();
        }

        return classAvg / this.getHeadCount();
    }

    public int getHeadCount(){
        return (int) Arrays.stream(this.students).filter(student -> student != null).count();
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
