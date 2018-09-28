package com.kenny.secretsanta;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) throws Exception {
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person();
        p1.setName("Mom");
        Person p2 = new Person();
        p2.setName("Dad");
        Person p3 = new Person();
        p3.setName("Daughter");

        Person p4 = new Person();
        p4.setName("Uncle");
        Person p5 = new Person();
        p5.setName("Aunt");
        Person p6 = new Person();
        p6.setName("Cousin");


        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);

        new Assigner().assign(persons);
        for(Person p : persons){
            System.out.println(p.toString());
        }
    }

}