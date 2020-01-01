package com.nicolaspetras.ciphers.java;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;

public class CaesarTest
{
    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    public void testEncipher(int key, String expected) {

    }

}
