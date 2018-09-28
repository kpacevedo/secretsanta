package com.kenny.secretsanta;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

}