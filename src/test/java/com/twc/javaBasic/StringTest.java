package com.twc.javaBasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTest {
    //Hint: String https://beginnersbook.com/2013/12/java-strings/
    @SuppressWarnings({"StringEquality", "ConstantConditions"})
    @Test
    void should_be_immutable() {
        String originalString = "The original string";
        String modifiedString = originalString.replace("original", "new");

        // TODO:
        //  Please modify the following line to pass the test. It is really easy to pass
        //  the test. But you have to tell why.
        // <--start

        /*
         * Answer:
         *
         * According to JLS-§4.3.3: A String object has a constant (unchanging) value.
         *
         * According to "https://stackoverflow.com/questions/9082971/compile-time-constants-and-variables",
         * if a primitive type or a string is defined as a constant and the value is
         * known at compile time, the compiler replaces the constant name everywhere
         * in the code with its value. This is called a compile-time constant. Compile
         * time constant must be: 1. declared final, 2. primitive or String, 3. initialized
         * within declaration, initialized with constant expression.
         *
         * According to "https://www.geeksforgeeks.org/string-constant-pool-in-java/", a String
         * instance is stored in the String constant pool if, at compile time, the String's value
         * is known (by creating directly using double quotes). Otherwise, the String instance will
         * be stored in the heap but not the String constant pool.
         *
         * Therefore, when a new String instance is created, it might be in the String constant
         * pool, or in the heap but outside the pool, depending on the way it is created.
         *
         * Calling replace() on originalString creates a new String instance at run time, and the
         * new reference is assigned to modifiedString. Therefore, the == operator returns false.
         */
        final boolean areSame = false;
        // --end-->

        assertEquals("The new string", modifiedString);
        assertEquals(areSame, originalString == modifiedString);
    }

    @SuppressWarnings({"StringEquality", "ConstantConditions"})
    @Test
    void all_modification_method_will_create_new_string() {
        String originalString = "The string with tailing space.     ";
        String modifiedString = originalString.trim();

        // TODO:
        //  Please modify the following line to pass the test. It is really easy to pass
        //  the test. But you have to tell why.
        // <--start

        /*
         * Answer: see above
         */
        final boolean areSame = false;
        // --end-->

        assertEquals("The string with tailing space.", modifiedString);
        assertEquals(areSame, originalString == modifiedString);
    }

    @SuppressWarnings("StringEquality")
    @Test
    void will_create_new_string_when_concat() {
        String originalString = "Part one. ";
        String copyOfOriginalString = originalString;
        originalString += "Part two.";

        // TODO:
        //  Please modify the following line to pass the test. It is really easy to pass
        //  the test. But you have to tell why.
        // <--start

        /*
         * Answer: At line 59 the two String literals still share the same reference to a String instance.
         * Concatenating the String instance referenced by originalString and "Part two." creates a new
         * String instance and the new reference is assigned to originalString, while the reference stored
         * in copyOfOriginalString remains unchanged.
         */
        final boolean areSame = false;
        // --end-->

        assertEquals("Part one. Part two.", originalString);
        assertEquals(areSame, originalString == copyOfOriginalString);
    }


    @SuppressWarnings({"unused"})
    @Test
    void should_break_string_into_words() {
        final String sentence = "This is Mike";

        // TODO: Extract words in the sentence.
        // <--Start
        String[] words = sentence.split(" ");
        // --End-->

        assertArrayEquals(new String[] {"This", "is", "Mike"}, words);
    }

}
