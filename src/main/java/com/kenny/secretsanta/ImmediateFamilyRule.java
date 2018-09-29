package com.kenny.secretsanta;

import java.util.List;

public class ImmediateFamilyRule implements Rule {


    @Override
    public boolean canAssign(Person person, Person candidate) {
        List<Person> personImmediateFamily = person.getImmediateFamily();
        List<Person> candidateImmediateFamily = candidate.getImmediateFamily();

        if(personImmediateFamily != null && personImmediateFamily.contains(candidate)){
            return false;
        }
        if(candidateImmediateFamily != null && candidateImmediateFamily.contains(person)){
            return false;
        }
        return true;
    }
}
