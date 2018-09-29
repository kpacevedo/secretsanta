package com.kenny.secretsanta;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ThreeYearRuleTest {

    @Test
    public void testAssignedTwoYearsAgo(){
        Person p = new Person();
        p.setName("Dad");
        Person p2 = new Person();
        p2.setName("Daughter");
        Map<Integer, Person> history = new HashMap<>();
        history.put(2016, p2);
        p.setHistory(history);

        assertFalse(new ThreeYearRule().canAssign(p, p2));

    }

    @Test
    public void testAssignedOneYearAgo(){
        Person p = new Person();
        p.setName("Dad");
        Person p2 = new Person();
        p2.setName("Daughter");
        Map<Integer, Person> history = new HashMap<>();
        history.put(2017, p2);
        p.setHistory(history);

        assertFalse(new ThreeYearRule().canAssign(p, p2));

    }

    @Test
    public void testNotAssignedInPastTwoYears(){
        Person p = new Person();
        p.setName("Dad");
        Person p2 = new Person();
        p2.setName("Daughter");
        Map<Integer, Person> history = new HashMap<>();
        history.put(2015, p2);
        p.setHistory(history);

        assertTrue(new ThreeYearRule().canAssign(p, p2));

    }

    @Test
    public void testNoHistory(){
        Person p = new Person();
        p.setName("Dad");
        Person p2 = new Person();
        p2.setName("Daughter");

        assertTrue(new ThreeYearRule().canAssign(p, p2));

    }
}
