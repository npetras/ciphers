package com.nicolaspetras.ciphers.java.ciphers;

public class Vigenere extends Cipher
{
    // instance variables
    private String key;

    // constructors

    /**
     * Initialises this object with the 'key' provided.
     *
     * @param key The cipher key
     */
    public Vigenere(String key)
    {
        this.key = key;
    }

    // getters/setters
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    // methods
    /**
     *
     *
     * @param plaintext
     * @return
     * @throws UnexpectedNonAlphaCharException
     * @throws InvalidAsciiValForAException
     */
    @Override
    public String encipher(String plaintext) throws UnexpectedNonAlphaCharException, InvalidAsciiValForAException
    {
        int p_len = plaintext.length();
        StringBuilder ciphertext = new StringBuilder(p_len);  // ciphertext
        int keyIndex = 0;

        for (int i = 0; i < p_len; i++)
        {
            keyIndex = keyIndex % key.length();     // makes sure key gets wrapped around properly
            char currP = plaintext.charAt(i);       // current plaintext char
            char currK = key.charAt(keyIndex);      // current key char
            int pAsciiVal = currP;                  // ascii value of plaintext char
            int kAsciiVal = currK;                  //  ascii value of key char

            if (Character.isLetter(currP))
            {
                encipherChar(ciphertext, currP, currK, pAsciiVal, kAsciiVal);
                keyIndex = keyIndex + 1;
            } else
            {
                ciphertext.append(currP);
            }
        }
        return ciphertext.toString();
    }

    private void encipherChar(StringBuilder ciphertext, char currP, char currK, int pAsciiVal, int kAsciiVal)
            throws UnexpectedNonAlphaCharException, InvalidAsciiValForAException
    {
        if (Character.isUpperCase(currP) && Character.isUpperCase(currK))
        {
            char encipheredChar = applyCipher(pAsciiVal, kAsciiVal, UPPERCASE_A, UPPERCASE_A);
            ciphertext.append(encipheredChar);
        } else if (Character.isUpperCase(currP) && Character.isLowerCase(currK))
        {
            char encipheredChar = applyCipher(pAsciiVal, kAsciiVal, UPPERCASE_A, LOWERCASE_A);
            ciphertext.append(encipheredChar);
        } else if (Character.isLowerCase(currP) && Character.isUpperCase(currK))
        {
            char encipheredChar = applyCipher(pAsciiVal, kAsciiVal, LOWERCASE_A, UPPERCASE_A);
            ciphertext.append(encipheredChar);
        } else if (Character.isLowerCase(currP) && Character.isLowerCase(currK))
        {
            char encipheredChar = applyCipher(pAsciiVal, kAsciiVal, LOWERCASE_A, LOWERCASE_A);
            ciphertext.append(encipheredChar);
        } else
        {
            throw new UnexpectedNonAlphaCharException();
        }
    }

    /**
     * Returns the enciphered character with the ASCII value 'pAsciiVal' in the plaintext.
     * <p>First the alphabetical index of both the plaintext character and the key character are calculated to ensure
     * that the letter shift can be applied properly. Then the letter shift specified by the key character relative to
     * the plain text character being considered is applied, and the enciphered character is returned.
     *
     * @param pAsciiVal       The ASCII value of a plaintext character
     * @param kAsciiVal       The ASCII value of a key character
     * @param asciiValOfAForP The ASCII value of A/a to be used for the plaintext character - depends on the character's
     *                        case.
     * @param asciiValOfAForK The ASCII value of A/a to be used for the key character - depends on the character's case.
     * @return The enciphered character
     */
    private char applyCipher(int pAsciiVal, int kAsciiVal, int asciiValOfAForP, int asciiValOfAForK)
            throws InvalidAsciiValForAException
    {
        int encipheredAsciiValP = 0;

        if ((asciiValOfAForK == 65 ^ asciiValOfAForK == 97) && (asciiValOfAForP == 65 ^ asciiValOfAForP == 97))
        {
            // get the alphabetical index of both the plain text and the key
            int alphaIndexP = pAsciiVal - asciiValOfAForP;
            int alphaIndexK = kAsciiVal - asciiValOfAForK;

            // apply the necessary letter shift, required by the key
            int encipheredAlphaIndexP = Math.floorMod(alphaIndexP + alphaIndexK, NUM_OF_LETTERS_IN_ALPHABET);
            // convert the enciphered alpha-index character to its ASCII value
            encipheredAsciiValP = encipheredAlphaIndexP + asciiValOfAForP;
        } else
        {
            throw new InvalidAsciiValForAException();
        }

        return (char) encipheredAsciiValP;
    }
}