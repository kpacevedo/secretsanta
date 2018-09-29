package com.kenny.secretsanta;

import org.junit.Test;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ImmediateFamilyRuleTest {

    @Test
    public void testIsImmediateFamily(){
        Person dad = new Person();
        dad.setName("Dad");
        Person daughter = new Person();
        daughter.setName("Daughter");
        dad.getImmediateFamily().add(daughter);
        daughter.getImmediateFamily().add(dad);

        assertFalse(new ImmediateFamilyRule().canAssign(dad, daughter));
    }

    @Test
    public void testIsNotImmediateFamily(){
        Person dad = new Person();
        dad.setName("Dad");
        Person daughter = new Person();
        daughter.setName("Daughter");
        Person cousin = new Person();
        cousin.setName("Cousin");
        dad.getImmediateFamily().add(daughter);

        assertTrue(new ImmediateFamilyRule().canAssign(dad, cousin));
    }
}
