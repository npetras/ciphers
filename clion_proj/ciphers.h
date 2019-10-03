//
// Created by Nicolas Petras on 26/05/2019.
//

#ifndef CLION_PROJ_CIPHERS_H
#define CLION_PROJ_CIPHERS_H

#define P_MAX 255   // maximum length of plaintext and cipher text

void caesar_cipher(int k, char *p, char *c);
void vigenere_cipher(char *k, char *p, char *c);

#endif //CLION_PROJ_CIPHERS_H
