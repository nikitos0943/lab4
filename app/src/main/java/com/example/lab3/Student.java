package com.example.lab3;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.name=name;
        this.groupName=groupName;
    }

    public String getName(){
        return name;
    }
    public String getGroupName(){
        return groupName;
    }
    private final static ArrayList<Student> students = new ArrayList<Student>(
            Arrays.asList(
                    new Student("Иванов Иван", "К20-1"),
                    new Student("Петров Петя", "К20-1"),
                    new Student("Сидоров Сергей", "К20-1"),
                    new Student("Лукинов Костя", "К20-1"),
                    new Student("Ткач Костя", "К21-1"),
                    new Student("Акинина Ангелина", "К21-1"),
                    new Student("Андриевский Валерий", "К21-1"),
                    new Student("Петров Вася", "К21-1м"),
                    new Student("Муханов Никита", "К21-1м"),
                    new Student("Колоковов Артем", "К21-1м")
            )
    );
    public static ArrayList<Student> getStudents(String groupName){
        ArrayList<Student> stList = new ArrayList<>();
        for (Student s: students){
            if(s.getGroupName().equals(groupName)){
                stList.add(s);
            }
        }
        return stList;
    }
}

