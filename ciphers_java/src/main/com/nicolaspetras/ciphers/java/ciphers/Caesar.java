package com.nicolaspetras.ciphers.java.ciphers;

/**
 * An implementation of the Caesar cipher, which uses a numerical key that determines the letter shift applied to the
 * plaintext and thus produced an piece of Caesar cipher cipher text.
 */
public class Caesar extends Cipher
{
    // instance variables
    private int key;

    // constructors
    public Caesar(int key)
    {
        this.key = key;
    }

    // getters/setters
    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    // methods

    /**
     * This function applies the Caesar cipher on the 'plaintext' using the 'key' instance variable.
     * <p>The key determines the letter shift to be applied to the 'plaintext' to produce the cipher text.
     *
     * @param plaintext The plain text to be encoded
     * @return Enciphered plaintext (cipher text)
     * @throws UnexpectedNonAlphaCharException When a non-alphabetical character is evaluated at a point, where
     *                                         all characters should be alphabetical
     * @throws InvalidAsciiValForAException    When an invalid ASCII value for A/a is provided.
     */
    @Override
    public String encipher(String plaintext) throws UnexpectedNonAlphaCharException,
            InvalidAsciiValForAException
    {
        int p_len = plaintext.length();
        StringBuilder c = new StringBuilder(p_len);   // ciphertext

        for (int i = 0; i < p_len; i++)
        {
            char curr = plaintext.charAt(i);

            // only encipher letters (alphabetical characters)
            if (Character.isLetter(curr))
            {
                encipherChar(c, curr, (int) curr);
            } else
            {
                c.append(plaintext.charAt(i));
            }
        }
        return c.toString();
    }

    /**
     * Enciphers and then appends the enciphered letter 'curr' to the 'ciphertext'.
     * <p>The case of the letter changes the enciphering process - because the ASCII code of the character is used for
     * enciphering - the alphabetic index of the character is obtained first, and then the letter shift is applied.
     *
     * @param ciphertext The current cipher text
     * @param curr       Current character being considered (that is a letter)
     * @param asciiVal   The ASCII value of the character currently being considered
     */
    private void encipherChar(StringBuilder ciphertext, char curr, int asciiVal) throws UnexpectedNonAlphaCharException,
            InvalidAsciiValForAException
    {
        char encipheredAsciiVal;
        if (Character.isUpperCase(curr))
        {
            encipheredAsciiVal = applyCipher(asciiVal, UPPERCASE_A);
        } else if (Character.isLowerCase(curr))
        {
            encipheredAsciiVal = applyCipher(asciiVal, LOWERCASE_A);
        } else
        {
            throw new UnexpectedNonAlphaCharException();
        }
        ciphertext.append(encipheredAsciiVal);
    }

    /**
     * Returns the enciphered character that had the ASCII value 'asciiVal' in the plaintext..
     * <p>To encipher a character, first the alphabetic index of that character needs to be calculated, this is done by
     * subtracting the ASCII value for uppercase a (A = 65) or lowercase (a = 97) depending on the case of the character
     * being evaluated. Then the letter shift is applied, which depends on the value of the 'key' instance variable.
     *
     * @param asciiVal    ASCII value of the current plaintext character being considered.
     * @param asciiValOfA The ASCII value of a to be used - uppercase (65) or lowercase (97)
     * @return The enciphered character
     */
    private char applyCipher(int asciiVal, int asciiValOfA) throws InvalidAsciiValForAException
    {
        int encipheredAsciiVal;  // enciphered ASCII value of 'asciiVal'

        if (asciiValOfA == 65 ^ asciiValOfA == 97)
        {
            // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 65 = ASCII code for 'A', and 97 = 'a'
            int alphaIndex = asciiVal - asciiValOfA;
            // applies letter shift, accounting for overflow
            int encipheredAlphaIndex = Math.floorMod(alphaIndex + key, NUM_OF_LETTERS_IN_ALPHABET);
            // convert enciphered plaintext alphabetical index back to the ASCII character that index represents
            encipheredAsciiVal = encipheredAlphaIndex + asciiValOfA;
        } else
        {
            throw new InvalidAsciiValForAException();
        }

        return (char) encipheredAsciiVal;
    }
}
