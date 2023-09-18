package org.example;

import java.util.*;
import java.util.stream.Stream;

public class Classroom {
    private Student[] students;

    /**
     * Adds new student to ClassRoom instance
     * @param newStudent the student being added to the classroom
     * @return true if student added, false (for testing/error-handling purposes) and print out if not
     */

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

//    public String getStudents(){
//        String studentString = "";
//        for(Student student : this.students){
//            if(studentNotNull(student)) {
//                studentString += student.toString();
//            }
//
//        }
//        return studentString;
//    }

    public Student[] getStudents(){
//        String studentString = "";
//        for(Student student : this.students){
//            if(studentNotNull(student)) {
//                studentString += student.toString();
//            }
//
//        }

        return Arrays.stream(this.students).filter(this::studentNotNull).toArray(Student[]::new);
    }

    public void setStudents(Student[] students){
        this.students = students;
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


    /**
     * Determines letter grade by getting student, taking student's avg score, and returning a letter based on the calculation
     * @param student
     * @return char representing the letter grade
     */
    public char getLetterGrade(Student student){
        char[] letterGrades = {'A', 'B', 'C', 'D', 'F'};
        char letterGrade;

        double averageScore = student.getAverageExamScore();


        letterGrade = (averageScore > 93) ? letterGrades[0] :
                      (averageScore > 85) ? letterGrades[1] :
                      (averageScore > 80) ? letterGrades[2] :
                      (averageScore > 70) ? letterGrades[3] :
                      letterGrades[4];

        return letterGrade;
    }

    public Map<Student, Character> getGradeBook(){
        Map<Student, Character> studentScores = new HashMap<>();
        // Filter out null student elements, forEach student, map student to Average ExamScore
        Arrays.stream(students).filter(this::studentNotNull).forEach(student -> studentScores.put(student, this.getLetterGrade(student)));

        return studentScores;
    }

    public void printGradeBook(Map<Student, Character> gradeBook){
        gradeBook.forEach((student, letterGrade) -> System.out.println(student.getFirstName() + " " + student.getLastName() + " : " + letterGrade) );
    }

    /**
     *
     * @param expelledStudent
     * @description - Removes student from Classroom using filter where studen != expelled student
     */

    public void removeStudent(Student expelledStudent){

         this.setStudents(Arrays.stream(this.students).filter(student -> student != expelledStudent).toArray(Student[]::new));

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
