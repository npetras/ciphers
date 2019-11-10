package ciphers_java;

/**
 *
 *
 * @author Nicolas Petras
 * @version 0.1 (in development)
 */
public class Ciphers
{


   public static String vigenere(String k, String p)
   {
       int p_len = p.length();
       StringBuilder c = new StringBuilder(p_len);  // ciphertext
      int keyIndex = 0;


      for (int i = 0; i < p_len; i++)
      {
          keyIndex = keyIndex % k.length();    // makes sure key gets wrapped around properly

          char currP = p.charAt(i);         // current plaintext character
          char currK = k.charAt(keyIndex);  // current key character

          int pAsciiVal = currP;            // plaintext ascii value
          int kAsciiVal = currK;            // key ascii value

         // only encipher alphabetical characters
          if (Character.isLetter(currP))
          {
              if (Character.isUpperCase(currP) && Character.isUpperCase(currK))
              {
                  // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 65 = ASCII code for 'A'
                  pAsciiVal = pAsciiVal - 65;
                  // turn alphabetic key into plaintext character - key will have to be purely alphabetic
                  kAsciiVal = kAsciiVal - 65;
                  // make the letter shift based on key, accounting for any overflow
                  pAsciiVal =  Math.floorMod(pAsciiVal + kAsciiVal, 26);
                  // convert enciphered plaintext alphabetical index back to the ASCII character that index represents
                  pAsciiVal = pAsciiVal + 65;
                 // convert ASCII value back to a character
                 currP = (char)pAsciiVal;

                  c.append(currP);
                  keyIndex = keyIndex + 1;
              } else if (Character.isUpperCase(currP) && Character.isLowerCase(currK))
              {
                 // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 65 = ASCII code for 'A'
                 pAsciiVal = pAsciiVal - 65;
                 // turn alphabetic key into plaintext character - key will have to be purely alphabetic
                 kAsciiVal = kAsciiVal - 97;
                 // make the letter shift based on key, accounting for any overflow
                 pAsciiVal =  Math.floorMod(pAsciiVal + kAsciiVal, 26);
                 // convert enciphered plaintext alphabetical index back to the ASCII character that index represents
                 pAsciiVal = pAsciiVal + 65;
                 // convert ASCII value back to a character
                 currP = (char)pAsciiVal;

                 c.append(currP);
                 keyIndex = keyIndex + 1;
              } else if (Character.isLowerCase(currP) && Character.isUpperCase(currK))
              {
                 // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 65 = ASCII code for 'A'
                 pAsciiVal = pAsciiVal - 97;
                 // turn alphabetic key into plaintext character - key will have to be purely alphabetic
                 kAsciiVal = kAsciiVal - 65;
                 // make the letter shift based on key, accounting for any overflow
                 pAsciiVal =  Math.floorMod(pAsciiVal + kAsciiVal, 26);
                 // convert enciphered plaintext alphabetical index back to the ASCII character that index represents
                 pAsciiVal = pAsciiVal + 97;
                 // convert ASCII value back to a character
                 currP = (char)pAsciiVal;

                 c.append(currP);
                 keyIndex = keyIndex + 1;
              } else if (Character.isLowerCase(currP) && Character.isLowerCase(currK))
              {
                  // turn plaintext character to an alphabetic index (with A = 0, Z = 25), 97 = ASCII code for 'a'
                  pAsciiVal = pAsciiVal - 97;
                  // turn alphabetic key into plaintext character - key will have to be purely alphabetic
                  kAsciiVal = kAsciiVal - 97;
                  // make the letter shift based on key, accounting for any overflow
                  pAsciiVal =  Math.floorMod(pAsciiVal + kAsciiVal, 26);
                  // convert enciphered plaintext alphabetical index back to the ASCII character that index represents
                  pAsciiVal = pAsciiVal + 97;
                 // convert ASCII value back to a character
                 currP = (char)pAsciiVal;

                 c.append(currP);
                 keyIndex = keyIndex + 1;
              } else
              {
                  System.err.println("Ciphers:vigenere Error while enciphering plaintext");
              }
          } else
          {
             c.append(currP);
          }
      }
      return c.toString();
   }
}
