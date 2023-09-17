package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName, lastName;

    private ArrayList<Double> examScores;

    public void addExamScore(Double score){
        this.examScores.add(score);
    }
//
//    public String formatScore(Double score){
//        return "Exam "
//    }

    public String getScores(){
        String scoreString = "Exam Scores: \n";
        int count = 0;
        for(Double score: this.examScores){
            count++;
            scoreString += "   " + "Exam " + count + " -> " + score + " \n";
        };

        return scoreString;
    }


    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setExamScore(int examIndex, double newScore){
        this.examScores.set(examIndex, newScore);
    }

    public Double getAverageExamScore(){
        Double scoreSum = 0.0;

        for(Double score : this.examScores){
            scoreSum += score;
        }

        return scoreSum / examScores.size();
    }

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores)); // create ArrayList from testScorres array

    }



    @Override
    public String toString(){
        String firstLine, secondLine;
                firstLine = "> Student Name: " + this.getFirstName() + " " + this.getLastName() + "\n";
                secondLine = "> Average Score: " + this.getAverageExamScore() + " \n";

        return firstLine + secondLine + "> " + getScores();
    }



}
