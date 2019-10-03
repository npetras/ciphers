#include <stdio.h>
#include <string.h>

#include "ciphers.h"

#define DEBUG

int main( )
{
    char p[P_MAX];
    char c[P_MAX];
    char k[10];


    printf("key: ");
    scanf(" %s", k);

#ifdef DEBUG
    printf("key = %s\n", k);
#endif

    printf("plaintext: ");
    scanf(" %s", p);

#ifdef DEBUG
    printf("plaintext = %s\n", p);
#endif

    vigenere_cipher(k, p, c);
    printf("ciphertext: %s", c);

    return 0;
}
