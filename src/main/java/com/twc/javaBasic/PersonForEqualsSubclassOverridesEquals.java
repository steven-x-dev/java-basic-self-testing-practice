package com.twc.javaBasic;

import java.util.Objects;

public class PersonForEqualsSubclassOverridesEquals extends PersonForEquals {

    private byte monthOfYear;

    public PersonForEqualsSubclassOverridesEquals(String name, short yearOfBirth, byte monthOfYear) {
        super(name, yearOfBirth);
        this.monthOfYear = monthOfYear;
    }

    public byte getMonthOfYear() {
        return monthOfYear;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && monthOfYear == ((PersonForEqualsSubclassOverridesEquals) obj).getMonthOfYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monthOfYear);
    }
}
