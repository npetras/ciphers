package ciphers_java;

/**
 *
 *
 * @author Nicolas Petras
 * @version 0.1 (in development)
 */
public class Ciphers
{
   /**
    * This function applies the caesar cipher on the plaintext 'p' using the key 'k'.
    *
    * @param k Integer key determining the degree and direction of the shift - this key has to be in the range: -25 to
    *          25. Negative values indicate a left shift and positive values indicate a right shift.
    * @param p Plaintext to be enciphered.
    *
    * @return Ciphertext - plaintext 'p' enciphered using the key 'k' provided.
    */
   public static String caesar(int k, String p)
   {
      int p_len = p.length();
      StringBuilder c = new StringBuilder(p_len);

      for (int i = 0; i < p_len; i++)
      {
         char curr = p.charAt(i);
         int asciiVal = curr;
         if (Character.isLetter(curr))
         {
            if (Character.isUpperCase(curr))
            {
               // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 65 = ASCII code for 'A'
               asciiVal = asciiVal - 65;
               // alphabetical index allows the addition of the key, while handling any overflow
               asciiVal = (asciiVal + k) % 26;
               c.append((char)asciiVal);

            } else if (Character.isLowerCase(curr))
            {
               // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 97 = ASCII code for 'a'
               asciiVal = asciiVal - 97;
               // alphabetical index allows the addition of the key, while handling any overflow
               asciiVal = (asciiVal + k) % 26;
               c.append((char) asciiVal);
            } else {
               System.err.println("Ciphers:caesar - Caesar cipher is considering a non-alphabetical character");
            }
         } else
         {
            continue;
         }
      }
      return c.toString();
   }
}
