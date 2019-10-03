/*
 * Author Nicolas Petras
 * Version: 0.1 (Development)
 * Version Date: 26/05/2019
 */

#include <string.h>
#include <ctype.h>
#include <stdio.h>
#include "ciphers.h"

char *convertAlphaToNumKey(char *k, int p_len);

void printOutAsciiKey(const char *k, int k_len);

/*
 * This function applies the caesar cipher on the plaintext 'p' using the key 'k'.
 *
 * Parameters:
 * p: plaintext to be enciphered
 * k: integer key determining the degree and direction of the shift - this key has to be in the range: -25 to 25. Negat-
 * ive values indicate a left shift and positive values indicate a right shift
 *
 * Returns: ciphertext - plaintext 'p' enciphered using the key 'k' provided
 */
void caesar_cipher(int k, char *p, char *c)
{
    int p_len;      // length of p


    p_len = (int)strlen(p);

    for (int i = 0; i < p_len; i++)
    {
        // only apply cipher to alphabetic characters
        if (isalpha(p[i]))
        {
            // depending if character is uppercase or lowercase a different calculation will take place
            if(isupper(p[i]))
            {
                c[i] = (char)(p[i] - 65);       // get the alpha-numeric index of uppercase letter p[i] by subtracting
                                                // the ascii code for 'A' from the uppercase letter
                c[i] = (char)((c[i] + k) % 26); // apply letter shift, ensuring that the character stays a letter
                c[i] = (char)(c[i] + 65);       // get the new character ascii value

            } else if(islower(p[i]))
            {
                c[i] = (char)(p[i] - 97);       // get the alpha-numeric index of lowercase letter p[i] by subtracting
                                                // the ascii code for 'a' from the lowercase letter
                c[i] = (char)((c[i] + k) % 26); // apply letter shift, ensuring that the character stays a letter
                c[i] = (char)(c[i] + 97);       // get the new character ascii value
            } else // error - shouldn't occur
            {
                fprintf(stderr, "error cipher:caesar_cipher - non-alphabetical character being considered, by caesar"
                        "cipher ");
            }
        }
    }
}


/*
 * This function applies the vigenere cipher on the plaintext 'p' using the key 'k'
 *
 * Parameters:
 * p: plaintext to be enciphered
 * k: alphabetical string key
 * c: ciphertext
 */
void vigenere_cipher(char *k, char *p, char *c)
{
    int p_len;      // length of the plaintext
    int k_len;      // length of the key
    int c_len;      // length of the ciphertext
    int k_index;    // key index


    strcpy(c, p);
    p_len = (int)strlen(p);
    k_len = (int)strlen(k);
    k_index = 0;

    strcpy(k, convertAlphaToNumKey(k, k_len));

    for (int p_index = 0; p_index < p_len; p_index++)
    {
        k_index = k_index % k_len;
        // only apply cipher to alphabetic characters
        if (isalpha(p[p_index]))
        {
            // depending if character is uppercase or lowercase a different calculation will take place
            if(isupper(p[p_index]))
            {
                c[p_index] = (char)(p[p_index] - 65);       // get the alpha-numeric index of uppercase letter p[p_index] by subtracting
                                                // the ascii code for 'A' from the uppercase letter
                c[p_index] = (char)((c[p_index] + k[k_index]) % 26); // apply letter shift, ensuring that the character stays a letter
                c[p_index] = (char)(c[p_index] + 65);       // get the new character ascii value

            } else if(islower(p[p_index]))
            {
                c[p_index] = (char)(p[p_index] - 97);           // get the alpha-numeric index of lowercase letter p[p_index] by subtracting
                                                    // the ascii code for 'a' from the lowercase letter
                c[p_index] = (char)((c[p_index] + k[k_index]) % 26);  // apply letter shift, ensuring that the character stays a letter
                c[p_index] = (char)(c[p_index] + 97);           // get the new character ascii value
            } else // error - shouldn't occur
            {
                fprintf(stderr, "error ciphers:vigenere_cipher - non-alphabetical character being considered, by caesar"
                        "cipher ");
            }
        }
        k_index++;
    }

    c_len = (int)strlen(c);
    c[c_len] = '\0';
}

void printOutAsciiKey(const char *k, int k_len)
{
    printf("Vigenere Numeric key: ");

    for (int i = 0; i < k_len; i++)
    {
        printf("%d", k[i]);
    }
}

/*
 * params:
 * k: alphabetical key
 * k_len: length of the alphabetical key
 */
char *convertAlphaToNumKey(char *k, int k_len)
{
    // convert alphabetic key to numeric key
    for (int i = 0; i < k_len; i++)
    {
        if(isalpha(k[i]))
        {
            if (isupper(k[i]))
            {
                k[i] = (char)(k[i] - 65);
            } else if (islower(k[i]))
            {
                k[i] = (char)(k[i] - 97);
            } else {
                fprintf(stderr, "Error: Vigenere cipher is reading a non-alphabetical character");
            }
        } else
        {
            fprintf(stderr, "Error: Vigenere key has a non-alphabetical character");
        }
    }

    k[k_len] = '\0';
    return k;
}