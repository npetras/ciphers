package com.nicolaspetras.ciphers.java.ciphers;

import com.nicolaspetras.ciphers.java.ciphers.exceptions.InvalidAsciiValForAException;
import com.nicolaspetras.ciphers.java.ciphers.exceptions.UnexpectedNonAlphaCharException;

/**
 * Defines a basic common class from which all ciphers can inherit.
 * <p>Defines some constant values, and the main method every Cipher class should have, which is an encipher method.
 */
public abstract class Cipher
{
    // constants
    /**
     * Number of letters in the alphabet
     */
    static final int NUM_OF_LETTERS_IN_ALPHABET = 26;
    /**
     * The ASCII code for an uppercase letter A
     */
    static final int UPPERCASE_A = 65;
    /**
     * The ASCII code for an lowercase letter a
     */
    static final int LOWERCASE_A = 97;

    // instance variables

    // constructors

    // getters/setters

    // methods

    /**
     * Implemented methods should return the enciphered  'plaintext' passed to this method, using the cipher's key and
     * encoding method.
     *
     * @param plaintext The plain text to be encoded
     * @return The enciphered 'plaintext' (cipher text)
     * @throws UnexpectedNonAlphaCharException When a non-alphabetical character is evaluated at a point, where
     *                                         all characters should be alphabetic.
     */
    public abstract String encipher(String plaintext) throws UnexpectedNonAlphaCharException,
            InvalidAsciiValForAException;
}
