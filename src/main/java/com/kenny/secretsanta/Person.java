package com.kenny.secretsanta;

public class Person {

    private String name;

    private boolean assigned = false;

    private Person secretSanta;

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
        if(this.equals(person) || person.isAssigned())
            return false;
        else
            secretSanta = person;
            return true;
    }

    public String toString(){
        return name + " assigned to " + secretSanta.getName();
    }
}
