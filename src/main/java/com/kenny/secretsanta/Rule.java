package com.kenny.secretsanta;

public interface Rule {
    boolean canAssign(Person person, Person candidate);
}
