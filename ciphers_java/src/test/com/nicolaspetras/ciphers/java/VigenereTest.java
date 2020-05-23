package com.nicolaspetras.ciphers.java;

import com.nicolaspetras.ciphers.java.ciphers.exceptions.InvalidAsciiValForAException;
import com.nicolaspetras.ciphers.java.ciphers.exceptions.InvalidCipherKeyException;
import com.nicolaspetras.ciphers.java.ciphers.exceptions.UnexpectedNonAlphaCharException;
import com.nicolaspetras.ciphers.java.ciphers.Vigenere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test class for Vigenere.
 *
 * @see Vigenere
 */
public class VigenereTest {

    @ParameterizedTest
    @CsvSource({
            "abc, Hfnlp Yosnd! 123&*%",
            "Aberystwyth, Hfpcm Ohnjw! 123&*%",
            "HELLOSOS, Oiwwc Ocjsh! 123&*%"
    })
    public void testEncipher(String key, String expected) throws UnexpectedNonAlphaCharException,
            InvalidAsciiValForAException, InvalidCipherKeyException {
        Vigenere vigenere = new Vigenere(key);
        String plaintext = "Hello World! 123&*%";
        String actual = vigenere.encipher(plaintext);

        Assertions.assertEquals(expected, actual);
    }
}
