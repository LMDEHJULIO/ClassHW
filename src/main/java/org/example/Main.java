package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int price;


       ArrayList<Double> examScores = new ArrayList<>();
       examScores.add(100.00);


        Student student1 = new Student(
                "Julio",
                "Rodriguez",
                new Double[]{100.00, 86.96}
        );

        Student student2 = new Student(
                "John",
                "Smith",
                new Double[]{100.00, 40.96}
        );

//        System.out.println(student1.getFirstName());
//        System.out.println(student1.getLastName());
//        student1.getScores();
        student1.setExamScore(0, 150);

//        System.out.println(student1.getScores());
//
//        System.out.println(student1.getAverageExamScore());

        student1.addExamScore(78.5);

//        System.out.println(student1.getAverageExamScore());

//        System.out.println(student1.toString());

//        System.out.println(student1.getScores());


        Classroom firstClass = new Classroom();

        firstClass.addStudent(student1);

        System.out.println(firstClass.getStudents());

        firstClass.addStudent(student2);

        System.out.println(firstClass.getHeadCount());

        System.out.println(firstClass.getStudents());

        System.out.println(firstClass.getAverageScore());

//        firstClass.removeStudent(student2);

        System.out.println(firstClass.getHeadCount());

        System.out.println(firstClass.getStudents());

        System.out.println(firstClass.getAverageScore());

        System.out.println(firstClass.getGradeBook());

        Arrays.stream(firstClass.getStudentsByScore()).forEach(student -> System.out.println(student));;


    }


}