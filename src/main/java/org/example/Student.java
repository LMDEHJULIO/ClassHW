package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Student class privately containing firstName, lastName, and examScores
 * Getters and setters are made for all of the above
 * Overrides toString to allow special formatting when printed to console
 * */

public class Student {

    private String firstName, lastName;

    private ArrayList<Double> examScores;

    /**
     * Add exam score to student List
     * @param Double representing score to be added
     * @return Boolean - representing success/failure of the operation
     */


    public Boolean addExamScore(Double score){
        this.examScores.add(score);

        return true;
    }

    /**
     * Reads exam scores from student object, returned in specific Exam (examNumber) -> score format
     * @return String - formatted string represting all exam scores for given student
     * */

    public String getExamScores(){
        String scoreString = "Exam Scores: \n";
        int count = 0;
        for(Double score: this.examScores){
            count++;
            scoreString += "   " + "Exam " + count + " -> " + score + " \n";
        };

        return scoreString;
    }


    /**
     * Setter for firstName attribute
     * @param String firstName - firstName to be set to the Student object
     */


    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Getter for firstName attribute
     * @return String - firstName property returned publicly
     */

    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for lastName attribute
     * @param String lastName - lastName to be set to the Student object
     */

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Getter for lastName attribute
     * @return String - lastName property returned publicly
     */

    public String getLastName(){
        return this.lastName;
    }

    /**
     * Sets an exam score at a given index of the examScores List
     * @param int examIndex - index of the arrayList element to be written to
     * @param double newScore - new score to be written at examIndex
     */


    public void setExamScore(int examIndex, double newScore){
        this.examScores.set(examIndex, newScore);
    }

    /**
     * Gets average exam score for student calling method
     * @return double - average calculated by total this.examscores and dividing by examScores.size()
     */

    public Double getAverageExamScore(){
        Double scoreSum = 0.0;

        for(Double score : this.examScores){
            scoreSum += score;
        }

        return scoreSum / examScores.size();
    }

    /**
    * Constuctor for new instances of Student
     * @param String firstName - First name of Student instance
     * @param String lastName - Last name of Student instance
     * @param Double[] testScores - array of testScores to be written as an ArrayList within Constructor
    */


    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores)); // create ArrayList from testScorres array

    }

    /**
     * Overidden toString providing custom formatting for printing Student objects to the console
     * @return A string interpolating/concatenation return values of getFirstName and getLastName
     */


    @Override
    public String toString(){
        String firstLine, secondLine;
                firstLine = "> Student Name: " + this.getFirstName() + " " + this.getLastName() + "\n";
                secondLine = "> Average Score: " + this.getAverageExamScore() + " \n";

        return firstLine + secondLine + "> " + getExamScores();
    }



}
