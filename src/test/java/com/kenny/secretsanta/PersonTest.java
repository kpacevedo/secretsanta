package com.kenny.secretsanta;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testAssignMyself(){
        Person p = new Person();
        assertFalse(p.assign(p));
        assertNull(p.getSecretSanta());
    }

    @Test
    public void testAssignDifferent() throws Exception{
        Person p = new Person();
        p.setName("Kenny");
        Person p2 = new Person();
        p2.setName("Will");
        assertTrue(p.assign(p2));
        assertEquals(p2, p.getSecretSanta());
    }

    @Test
    public void testAssignAlreadyAssigned() throws Exception{
        Person p = new Person();
        p.setName("Kenny");
        Person p2 = new Person();
        p2.setName("Will");
        p2.setAssigned(true);
        assertFalse(p.assign(p2));
        assertNull(p.getSecretSanta());
    }

    @Test
    public void testRulesHonored(){
        //verify that the three year rule is honored
        Person p = new Person();
        p.setName("Dad");
        Person p2 = new Person();
        p2.setName("Mom");

        Map<Integer, Person> dadHistory = new HashMap<>();
        dadHistory.put(2017, p2);
        p.setHistory(dadHistory);

        assertFalse(p.assign(p2));
        assertNull(p.getSecretSanta());
    }

    @Test
    public void testGetRules(){
        assertEquals(2, Person.rules.size());
        assertTrue(Person.rules.get(0) instanceof ThreeYearRule);
        assertTrue(Person.rules.get(1) instanceof ImmediateFamilyRule);
    }

}