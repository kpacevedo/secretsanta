package com.kenny.secretsanta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {

    private String name;

    private boolean assigned = false;

    private Person secretSanta;

    //simplistic way of maintaining history, maps year to previous secret santa
    //realistically this would be stored in some sort of table
    private Map<Integer, Person> history;

    private List<Rule> rules = Arrays.asList(new ThreeYearRule());

    public Map<Integer, Person> getHistory() {
        return history;
    }

    public void setHistory(Map<Integer, Person> yearToSecretSanta) {
        this.history = yearToSecretSanta;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public Person getSecretSanta() {
        return secretSanta;
    }

    public boolean assign(Person person){
        if(this.equals(person) || person.isAssigned()){
            return false;
        }
        for(Rule r : rules){
            if(!r.canAssign(this, person)){
                return false;
            }
        }
        secretSanta = person;
        return true;
    }

    public String getDescription(){
        return name + " assigned to " + secretSanta.getName();
    }
}
