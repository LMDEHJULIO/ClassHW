package org.example;

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
        double clasAvg
        for(Student student : this.students){

        }
    }

    public int getHeadCount(){
        return this.students.length;
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
