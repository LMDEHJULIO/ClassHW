package org.example;

import javax.management.loading.ClassLoaderRepository;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Classroom {
    private Student[] students;

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
