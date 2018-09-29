package com.kenny.secretsanta;

import java.util.Calendar;
import java.util.Map;

public class ThreeYearRule implements Rule{


    @Override
    public boolean canAssign(Person person, Person candidate) {
        //if this person has had this candidate in the previous 2 years, return false
        //TODO update assigner to throw exception if this rule prevents everyone from being assigned
        Map<Integer, Person> history = person.getHistory();

        if(history == null || history.isEmpty()){
            return true; //no history to compare against
        }
        Integer thisYear = Calendar.getInstance().get(Calendar.YEAR);
        if(history.get(thisYear - 1) != null  && history.get(thisYear - 1).equals(candidate)){
            return false;
        }

        if(history.get(thisYear - 2) != null  && history.get(thisYear - 2).equals(candidate)){
            return false;
        }

        return true;
    }




}
