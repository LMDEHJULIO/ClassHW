package org.example;
import java.util.*;
import java.util.function.Consumer;
import org.apache.commons.math3.distribution.NormalDistribution;

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

    public Student[] getStudents(){
        return Arrays.stream(this.students).filter(this::studentNotNull).toArray(Student[]::new);
    }

    public void printStudents(){
        System.out.println(Arrays.toString(this.getStudents()));
    }

    public void setStudents(Student[] students){
        this.students = students;
    }

    public double getAverageScore(){
        // Very helpful article for using mapToDouble to extract double value from operation

        https://www.geeksforgeeks.org/stream-maptodouble-java-examples/

        return Arrays.stream(this.students).filter(this::studentNotNull).mapToDouble(Student::getAverageExamScore).average().orElse(0.0);
    }

    // Figure out good comparison option within sorted - found this great article on comparators
    // https://medium.com/@lonell.liburd/chaining-comparators-and-sorting-in-java-498b8e1e34a8

    public Student[] getStudentsByScore(){
       return Arrays.stream(this.students).filter(student -> studentNotNull(student)).sorted((s1, s2) -> Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore())).toArray(Student[]::new);
    }


    public void printStudentsByScore(){
        Arrays.stream(getStudentsByScore()).forEach(System.out::println);
    }

    /**
     * Determines letter grade by getting student, taking student's avg score, and returning a letter based on the calculation
     * @param student
     * @return char representing the letter grade
     */

    public Map<Student, Character> getGradeBook(){
        Map<Student, Character> studentScores = new HashMap<>();

        forEachStudent(student -> studentScores.put(student, getLetterGrade(calculatePercentTile(student.getAverageExamScore()), student.getAverageExamScore())));

        return studentScores;
    }

    public double calculatePercentTile(double avgScore){
        double mean = 85.00; // middle of the bell curve (i think)

        double standardDeviation = 8.00; // how much above/below mean scores may vary

        // Create normal distribution of grades using params above ^

        NormalDistribution curve = new NormalDistribution(mean, standardDeviation);

        return curve.cumulativeProbability(avgScore);
    }

    public char getLetterGrade(double percentile, double examScore){
        return (percentile <= .10) ? 'F':
               (percentile <= .29) ? 'D':
               (percentile <= .5) ? 'C':
               (percentile <= .89) ? 'B':
               'A';
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

    public void forEachStudent(Consumer<Student> callback){
        Arrays.stream(this.students).filter(this::studentNotNull).forEach(callback);
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
