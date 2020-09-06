package com.twc.javaBasic;

public class PersonForEqualsSubclassDoesNotOverrideEquals extends PersonForEquals {

    private byte monthOfYear;

    public PersonForEqualsSubclassDoesNotOverrideEquals(String name, short yearOfBirth, byte monthOfYear) {
        super(name, yearOfBirth);
        this.monthOfYear = monthOfYear;
    }

}
