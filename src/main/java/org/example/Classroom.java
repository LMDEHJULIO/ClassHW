package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

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
            if(studentNotNull(student)) {
                studentString += student.toString();
            }

        }
        return studentString;
    }

    public Double getAverageScore(){
        double classAvg = 0.0;

        for(Student student : this.students){
            if(studentNotNull(student)){
                classAvg += student.getAverageExamScore();
            }
        }

        return classAvg / this.getHeadCount();
    }

    // Figure out good comparison option within sorted - found this great article on comparators
    // https://medium.com/@lonell.liburd/chaining-comparators-and-sorting-in-java-498b8e1e34a8

    public Student[] getStudentsByScore(){
       return Arrays.stream(this.students).filter(student -> studentNotNull(student)).sorted((s1, s2) -> Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore())).toArray(Student[]::new);
    }

    public ArrayList<Character> getGradeBook(){
        char[] letterGrades = {'A', 'B', 'C', 'D', 'F'};
        char letterGrade;
        ArrayList<Character> gradebook = new ArrayList<>();


        for(Student student : this.students){

            if(studentNotNull(student)){
                Double averageScore = student.getAverageExamScore();

                letterGrade = (averageScore > 93) ? letterGrades[0] :
                              (averageScore > 85) ? letterGrades[1] :
                              (averageScore > 80) ? letterGrades[2] :
                              (averageScore > 70) ? letterGrades[3] :
                              letterGrades[4];

                gradebook.add(letterGrade);
            }

        }

        return gradebook;
    }

    public void removeStudent(Student expelledStudent){ // input
        // do something with input
        int expelledStudentIndex = Arrays.asList(this.students).indexOf(expelledStudent); // get index of expelled student

        this.students[expelledStudentIndex] = null; // access student at that array, and nullify the data
    }


    public int getHeadCount(){
        return (int) Arrays.stream(this.students).filter(student -> studentNotNull(student)).count();
    }

    public boolean studentNotNull(Student student){
        return student != null;
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
