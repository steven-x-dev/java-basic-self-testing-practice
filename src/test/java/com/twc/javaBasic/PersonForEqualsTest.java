package com.twc.javaBasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonForEqualsTest {

    @Test
    void test_super() {
        PersonForEquals p1 = new PersonForEquals("steven", (short) 2000);
        PersonForEquals p2 = new PersonForEquals("steven", (short) 2000);

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void test_super_with_wrong_subclass() {
        PersonForEquals p1 = new PersonForEquals("steven", (short) 2000);
        PersonForEquals p2 = new PersonForEqualsSubclassDoesNotOverrideEquals("steven", (short) 2000, (byte) 11);

        // expected not equal because p1 and p2 are not of the same class,
        // and will return false in PersonForEquals.equals()
        assertNotEquals(p1, p2);

        // expected equal, because the implementation is wrong in subclass
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void test_super_with_correct_subclass() {
        PersonForEquals p1 = new PersonForEquals("steven", (short) 2000);
        PersonForEquals p2 = new PersonForEqualsSubclassOverridesEquals("steven", (short) 2000, (byte) 11);

        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void test_wrong_subclass() {
        PersonForEquals p1 = new PersonForEqualsSubclassDoesNotOverrideEquals("steven", (short) 2000, (byte) 10);
        PersonForEquals p2 = new PersonForEqualsSubclassDoesNotOverrideEquals("steven", (short) 2000, (byte) 11);

        // expected equal, because the implementations are wrong in subclass
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void test_correct_subclass() {
        PersonForEquals p1 = new PersonForEqualsSubclassOverridesEquals("steven", (short) 2000, (byte) 10);
        PersonForEquals p2 = new PersonForEqualsSubclassOverridesEquals("steven", (short) 2000, (byte) 11);

        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

}
