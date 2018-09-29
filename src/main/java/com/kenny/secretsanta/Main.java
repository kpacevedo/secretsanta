package com.kenny.secretsanta;

import java.util.*;

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

        Person uncle2 = new Person();
        uncle2.setName("Uncle 2");
        Person grandfather = new Person();
        grandfather.setName("Grandfather");
        Person otherCousin = new Person();
        otherCousin.setName("Other cousin");
        Person otherCousin2 = new Person();
        otherCousin2.setName("Other cousin 2");
        Person otherCousin3 = new Person();
        otherCousin3.setName("Other cousin 3");

        Map<Integer, Person> momHistory = new HashMap<>();
        momHistory.put(2017, uncle);
        momHistory.put(2016, aunt);
        momHistory.put(2015, daughter);

        mom.getImmediateFamily().add(dad);
        mom.getImmediateFamily().add(daughter);
        dad.getImmediateFamily().add(daughter);
        uncle.getImmediateFamily().add(aunt);
        uncle.getImmediateFamily().add(cousin);
        aunt.getImmediateFamily().add(cousin);

        persons = Arrays.asList(mom, dad, daughter, uncle, aunt, cousin, uncle2, grandfather, otherCousin, otherCousin2,
                otherCousin3);

        new Assigner().assign(persons);
        for(Person p : persons){
            System.out.println(p.getDescription());
        }
    }

}