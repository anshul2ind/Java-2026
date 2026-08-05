package com.project.collection.list;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Student b) {
        return Double.compare(b.getGpa(), this.getGpa());
    }
}
