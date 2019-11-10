package ciphers_java.ciphers;

import ciphers_java.ciphers.Cipher;

public class Caesar extends Cipher
{
   int key;

   static final int NUM_OF_LETTERS_IN_ALPHABET = 26;
   static final int UPPERCASE_A = 65;
   static final int LOWERCASE_A = 97;

   /**
    * This function applies the caesar cipher on the plaintext 'p' using the key 'k'.
    *
    * @return Ciphertext - plaintext 'p' enciphered using the key 'k' provided.
    */
   @Override
   public String encipher()
   {
      int p_len = plaintext.length();
      StringBuilder c = new StringBuilder(p_len);   // ciphertext


      for (int i = 0; i < p_len; i++)
      {
            char curr = plaintext.charAt(i);

            if (Character.isLetter(curr))
            {
               checkCase(c, curr, (int)curr);
            } else
            {
               c.append(plaintext.charAt(i));
         }
      }
      return c.toString();
   }

   /**
    * Checks the case of the current, and depending on this case - the character gets enciphered in a different manner.
    *
    * @param c The cipher text
    * @param curr Current character being considered
    * @param asciiVal The ASCII value of the character currently being considered
    * @see Caesar#encipherChar
    */
   private void checkCase(StringBuilder c, char curr, int asciiVal)
   {
      if (Character.isUpperCase(curr))
      {
         asciiVal = encipherChar(asciiVal, UPPERCASE_A);
         c.append((char)asciiVal);

      } else if (Character.isLowerCase(curr))
      {
         asciiVal = encipherChar(asciiVal, LOWERCASE_A);
         c.append((char) asciiVal);
      } else
      {
         System.err.println("Ciphers:caesar - Caesar cipher is considering a non-alphabetical character");
      }
   }

   /**
    * Returns the ASCII code of the encipher alphabetical character.
    * <p>To encipher a character, first the alphabetic index of that character needs to be calculated, this is done by
    * subtracting the ASCII value for uppercase a (A = 65) or lowercase (a = 97) depending on the case of the character
    * being evaluated.
    *
    * @param asciiVal ASCII value of the current character being considered.
    * @param asciiValOfA The ASCII value of a to be used - uppercase (65) or lowercase (97)
    */
   private int encipherChar(int asciiVal, int asciiValOfA)
   {
      int newAsciiVal = 0;  // encipher ASCII value of 'asciiVal'

      if (asciiValOfA == 65 ^ asciiValOfA == 97)
      {
         // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 65 = ASCII code for 'A', and 97 = 'a'
         newAsciiVal = asciiVal - asciiValOfA;
         // applies letter shift, accounting for overflow
         newAsciiVal = Math.floorMod(asciiVal + key, NUM_OF_LETTERS_IN_ALPHABET);
         // convert enciphered plaintext alphabetical index back to the ASCII character that index represents
         newAsciiVal = asciiVal + asciiValOfA;
      } else {
         System.err.println("An invalid ascii code for a/A was provided");
      }

      return newAsciiVal;
   }
}
