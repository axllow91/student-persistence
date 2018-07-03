package com.mrn.students.model;

import javax.persistence.*;

// This a POJO or Entity
@Entity
@Table(name="STUDENTS_TABLE")
public class Student extends AbstractStudent{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;


    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String country, int zipCode) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}
