#include <stdio.h>
#include <string.h>

#include "ciphers.h"

#define DEBUG

int main( )
{
    char p[P_MAX];
    char c[P_MAX];
    char k[10];


//    printf("key: ");
//    scanf(" %s", k);
//
//#ifdef DEBUG
//    printf("key = %s\n", k);
//#endif
//
//    printf("plaintext: ");
//    scanf(" %s", p);

//#ifdef DEBUG
//    printf("plaintext = %s\n", p);
//#endif

    strcpy(k, "abc");
    strcpy(p, "hello");


    vigenere_cipher(k, p, c);
    printf("ciphertext: %s\n", c);

    return 0;
}
