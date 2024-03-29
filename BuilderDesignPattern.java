package com.nagarro.builder;

import java.util.*;
import java.lang.String;
public class Student {
    int rollNo;
    int age;
    String name;
    String fatherName;
    String motherName;
    List<String> subjects;

    public Student(StudentBuilder builder) {
        this.rollNo =builder.rollNumber;
        this.age = builder.age;
        this.name = builder.name;
        this.fatherName =builder.fatherName;
        this.motherName =builder.motherName;
        this.subjects = builder.subjects;
    }

    @Override
    public java.lang.String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", age=" + age +
                ", name=" + name +
                ", fatherName=" + fatherName +
                ", motherName=" + motherName +
                ", subjects=" + subjects +
                '}';
    }

}
***************************************************************
package com.nagarro.builder;
import  java.util.*;
public abstract class StudentBuilder {
    int rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;
    List<String> subjects;
    public StudentBuilder setRollNumber(int rollNumber){
        this.rollNumber=rollNumber;
        return this;
    }
    public StudentBuilder setAge(int age){
        this.age=age;
        return this;
    }
    public StudentBuilder setFatherName(String fatherName){
        this.fatherName=fatherName;
        return this;
    }

    public StudentBuilder setName(String name){
        this.name=name;
        return this;
    }
    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    abstract public StudentBuilder setSubjects();
    public Student build(){
        return new Student(this);
    }


}
*********************************
package com.nagarro.builder;


import java.util.*;

public class EngineeringStudentBuilder extends StudentBuilder {


    @Override
    public StudentBuilder setSubjects() {
        List<String> l1=new ArrayList<>();
        l1.add("dsa");
        l1.add("Os");
        l1.add("Computer Organization Architecture");
        this.subjects =l1;
        return this;

    }

}
*******************************
package com.nagarro.builder;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Micro Economics");
        subs.add("Business Studies");
        subs.add("Operations Management");
        this.subjects = subs;
        return this;
    }

}
**************************************
package com.nagarro.builder;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Micro Economics");
        subs.add("Business Studies");
        subs.add("Operations Management");
        this.subjects = subs;
        return this;
    }

}
******************************
package com.nagarro.builder;

public class Client {

    public static void main(String[] args){
        Director d1=new Director(new EngineeringStudentBuilder());
        Student engineerStudent = d1.createStudent();
        System.out.println(engineerStudent.toString());
    }
}

