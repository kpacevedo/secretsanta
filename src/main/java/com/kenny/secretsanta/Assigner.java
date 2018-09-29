package com.kenny.secretsanta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assigner {

    public void assign(List<Person> personList) throws Exception {
        if(personList.size() < 2){
            throw new Exception("Not enough persons for secret santa!");
        }

        for(int i =0; i< personList.size(); i++){
            Person thisPerson = personList.get(i);
            //create a list of candidates
            List<Person> candidates = new ArrayList<Person>(personList);
            candidates.remove(thisPerson);
            Collections.shuffle(candidates);

            //iterate through candidates and assign
            for(int j = 0; j < candidates.size(); j++){
                Person candidate = candidates.get(j);
                //if this candidate already has this person as secret santa and theres only one person left, continue
                if(candidate.getSecretSanta()!= null && candidate.getSecretSanta().equals(thisPerson) && i+2 == personList.size())
                    continue;

                if(thisPerson.assign(candidate)) {
                    candidate.setAssigned(true);
                    break;
                }

                if(j == candidates.size() -1){
                    throw new Exception("Could not find a secret santa for person: "+thisPerson.getName()+". " +
                            "This may be due to too strict of rules.");
                }
            }
        }
    }
}
