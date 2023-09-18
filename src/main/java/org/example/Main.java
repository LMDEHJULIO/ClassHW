package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


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

        Student student3 = new Student(
                "Valentina",
                "Shevchenko",
                new Double[]{80.00, 80.00}
        );

//        System.out.println(student1.getFirstName());
//        System.out.println(student1.getLastName());

        // Get Exam scores - should be 100.00 and 86.96

//        System.out.println(student1.getExamScores());

        //Set student one's exam score - first exam score should now be 98
        student1.setExamScore(0, 98);

        // Get new exam score - should be 98.0, 86.06
//        System.out.println(student1.getExamScores());
////
//        System.out.println(student1.getAverageExamScore());

//        student1.addExamScore(78.5);
//
//        System.out.println(student1.getAverageExamScore());

//        System.out.println(student1.toString());

//        System.out.println(student1.getScores());


        Classroom firstClass = new Classroom();

        firstClass.addStudent(student1);

//        System.out.println(Arrays.toString(firstClass.getStudents()));

        firstClass.printStudents();

        firstClass.addStudent(student2);

        firstClass.addStudent(student3);

        System.out.println(firstClass.getHeadCount());

//        System.out.println(Arrays.toString(firstClass.getStudents()));

        System.out.println(firstClass.getAverageScore());

//        firstClass.removeStudent(student2);

        System.out.println(firstClass.getHeadCount());

//        System.out.println(Arrays.toString(firstClass.getStudents()));

//        System.out.println(firstClass.getAverageScore());

//        System.out.println(firstClass.getGradeBook());

//        Arrays.stream(firstClass.getStudentsByScore()).forEach(student -> System.out.println(student));;

        firstClass.printStudentsByScore();
//        firstClass.removeStudent(student2);

//         firstClass.getStudentsByScore().forEach((student, score) -> System.out.println(student + " : " + score));


//        Arrays.stream(firstClass.getStudentsByScore()).forEach(student -> System.out.println(student));;

//     System.out.println(firstClass.getStudents());

     firstClass.printGradeBook(firstClass.getGradeBook());

    }


}