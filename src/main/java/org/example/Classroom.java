package org.example;
import java.util.*;
import java.util.function.Consumer;
import org.apache.commons.math3.distribution.NormalDistribution;

public class Classroom {
    private Student[] students;

    /**
    * Constructors - each overloading to provide flexibility in instantation
    * 1 - takes int of makes students and creates array of [maxStudents] elements
    * 2 - creates classroom instance using passed array of students
    * 3 - nullary constructor w no params - creates classroom with 30 empty elements
    * @return Classroom instance with students array
    * */
    public Classroom(int maxStudents) {
        this.students = new Student[maxStudents];
    }

    public Classroom(Student[] students){
        this.students = students;
    }

    public Classroom(){
        this(30);
    }

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

    /**
     * Reads the private students array
     * @return Array of student objects
     */

    public Student[] getStudents(){
        return Arrays.stream(this.students).filter(this::studentNotNull).toArray(Student[]::new);
    }

    /**
     * Reads the private students array
     * @return Array of student objects
     */

    public void printStudents(){
        System.out.println(Arrays.toString(this.getStudents()));
    }

    /**
     * Sets students to a given array
     * @param students
     */

    public void setStudents(Student[] students){
        this.students = students;
    }

    /**
     * Calculates/returns avg score of entire class
     * @return double equating to avg class score
     */

    public double getAverageScore(){
        // Very helpful article for using mapToDouble to extract double value from operation

        https://www.geeksforgeeks.org/stream-maptodouble-java-examples/

        return Arrays.stream(this.students).filter(this::studentNotNull).mapToDouble(Student::getAverageExamScore).average().orElse(0.0);
    }

    /**
     * Sorts the students by score in descending order
     * @return Descending sorted Student array
     */

    // Figure out good comparison option within sorted - found this great article on comparators
    // https://medium.com/@lonell.liburd/chaining-comparators-and-sorting-in-java-498b8e1e34a8

    public Student[] getStudentsByScore(){
       return Arrays.stream(this.students).filter(this::studentNotNull).sorted((s1, s2) -> Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore())).toArray(Student[]::new);
    }

    /**
     * Prints the sorted studentScore array
     * @return void
     */


    public void printStudentsByScore(){
        Arrays.stream(getStudentsByScore()).forEach(System.out::println);
    }

    /**
     * Determines letter grade by mapping result of getLetterGrade along with student object to a HashMap
     * @return Map of students and their letter grade
     */

    public Map<Student, Character> getGradeBook(){
        Map<Student, Character> studentScores = new HashMap<>();

        forEachStudent(student -> studentScores.put(student, getLetterGrade(calculatePercentTile(student.getAverageExamScore()))));

        return studentScores;
    }

    /**
     * Calculates percentiles using Apache Math3's NormalDistribution Class
     * @param double avgScore - used to calculate percentile calculation using Normal Distriubtion's cumuluative probability
     * @return double representing percentile
     */

    public double calculatePercentTile(double avgScore){
        double mean = 85.00; // middle of the bell curve (i think)

        double standardDeviation = 8.00; // how much above/below mean scores may vary

        // Create normal distribution of grades using params above ^

        NormalDistribution curve = new NormalDistribution(mean, standardDeviation);

        return curve.cumulativeProbability(avgScore); //not sure if this sorts by default, may have to sort beforehand
    }

    /**
     * Determines/returns letter grade based on percentile provided
     * @param double percentile - percentile using to generate letter grade
     * @return char representing letter grade
     */

    public char getLetterGrade(double percentile){
        return (percentile <= .10) ? 'F':
               (percentile <= .29) ? 'D':
               (percentile <= .5) ? 'C':
               (percentile <= .89) ? 'B':
               'A';
    }

    /**
     * Prints the key/values from HashMap
     * @param Map - gradeBook Map
     * @return void
     */


    public void printGradeBook(Map<Student, Character> gradeBook){
        gradeBook.forEach((student, letterGrade) -> System.out.println(student.getFirstName() + " " + student.getLastName() + " : " + letterGrade) );
    }

    /**
     * Removes students from
     * @param expelledStudent
     * @description - Removes student from Classroom using filter where studen != expelled student
     */

    public void removeStudent(Student expelledStudent){
         this.setStudents(Arrays.stream(this.students).filter(student -> student != expelledStudent).toArray(Student[]::new));
    }

    /**
     * Filters all null student elements and performs a given callback on every student
     * @param Consumer callback - operation performed on every student
     * @description - Removes student from Classroom using filter where studen != expelled student
     */

    public void forEachStudent(Consumer<Student> callback){
        Arrays.stream(this.students).filter(this::studentNotNull).forEach(callback);
    }

    /**
     * Filters all null student elements and performs a given callback on every student
     * @param Consumer callback - operation performed on every student
     * @description - Removes student from Classroom using filter where studen != expelled student
     */

    public int getHeadCount(){
        return (int) Arrays.stream(this.students).filter(this::studentNotNull).count();
    }

    /**
     * Checks if student element within Student[] is null
     * @param Student - student to be evaluated
     * @return boolean - confirmation if student is/isnot null
     */

    public boolean studentNotNull(Student student){
        return student != null;
    }




}
