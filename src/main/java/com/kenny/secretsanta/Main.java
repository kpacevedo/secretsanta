package com.kenny.secretsanta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) throws Exception {
        List<Person> persons = new ArrayList<>();
        Person mom = new Person();
        mom.setName("Mom");
        Person dad = new Person();
        dad.setName("Dad");
        Person daughter = new Person();
        daughter.setName("Daughter");
        Person uncle = new Person();
        uncle.setName("Uncle");
        Person aunt = new Person();
        aunt.setName("Aunt");
        Person cousin = new Person();
        cousin.setName("Cousin");

        Map<Integer, Person> momHistory = new HashMap<>();
        momHistory.put(2017, uncle);
        momHistory.put(2016, aunt);
        momHistory.put(2015, daughter);


        persons.add(mom);
        persons.add(dad);
        persons.add(daughter);
        persons.add(uncle);
        persons.add(aunt);
        persons.add(cousin);

        new Assigner().assign(persons);
        for(Person p : persons){
            System.out.println(p.getDescription());
        }
    }

}