package com.kenny.secretsanta;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AssignerTest{

    @Test
    public void testNoPersons(){
        try{
            new Assigner().assign(new ArrayList<Person>());
        }catch(Exception e){
            assertEquals("Not enough persons for secret santa!", e.getMessage());
            return;
        }
        fail("Expected exception not thrown!");
    }

    @Test
    public void testOnePerson(){
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person());
        try{
            new Assigner().assign(new ArrayList<Person>());
        }catch(Exception e){
            assertEquals("Not enough persons for secret santa!", e.getMessage());
            return;
        }
        fail("Expected exception not thrown!");
    }

    @Test
    public void testMultPersons() throws Exception{
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

        //make sure each person is assigned by building a set of assigned and comparing it with original list
        List<Person> assigned = new ArrayList<>();
        for(Person p : persons){
            assigned.add(p.getSecretSanta());
        }
        assertEquals(new HashSet(persons), new HashSet(assigned));
    }

}