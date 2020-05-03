package com.nicolaspetras.ciphers.java;

import com.nicolaspetras.ciphers.java.ciphers.Caesar;
import com.nicolaspetras.ciphers.java.ciphers.InvalidAsciiValForAException;
import com.nicolaspetras.ciphers.java.ciphers.InvalidCipherKeyException;
import com.nicolaspetras.ciphers.java.ciphers.UnexpectedNonAlphaCharException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test class for the Caesar class.
 * @see Caesar
 */
public class CaesarTest
{
    /**
     * Test for the encipher method.
     * <p>Tests with a plaintext that contains alphabetical, space and special characters. The same plaintext is used
     * for each test, but different keys are applied that plaintext - both negative and positive, including keys
     * greater than 25, which the Caesar should be able to handle if required.
     *
     * @param key The Caesar key to be used
     * @param expected The expected ciphertext to be output by the encipher method
     * @throws UnexpectedNonAlphaCharException
     */
    @ParameterizedTest
    @CsvSource({
            "3, Khoor Zruog! 123&*%",
            "-3, Ebiil Tloia! 123&*%",
            "45, Axeeh Phkew! 123&*%",
            "-45, Olssv Dvysk! 123&*%"
    })
    public void testEncipher(int key, String expected) throws UnexpectedNonAlphaCharException,
            InvalidAsciiValForAException, InvalidCipherKeyException
    {
        Caesar caesar = new Caesar(key);
        String plaintext = "Hello World! 123&*%";
        String actual = caesar.encipher(plaintext);

        Assertions.assertEquals(expected, actual);
    }

}
