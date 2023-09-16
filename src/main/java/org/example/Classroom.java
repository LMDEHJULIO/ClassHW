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
            if(!isNull(student)){
                classAvg += student.getAverageExamScore();
            }
        }

        return classAvg / this.getHeadCount();
    }

    // Figure out good comparison option within sorted

//    public getStudentsByScore(){
//        return Arrays.stream(this.students).sorted((s1, s2) -> );
//    }

    public void removeStudent(Student expelledStudent){
        int expelledStudentIndex = Arrays.asList(this.students).indexOf(expelledStudent);

        this.students[expelledStudentIndex] = null;
    }

    public int getHeadCount(){
        return (int) Arrays.stream(this.students).filter(student -> !isNull(student)).count();
    }

    public boolean isNull(Student student){
        return student == null;
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
