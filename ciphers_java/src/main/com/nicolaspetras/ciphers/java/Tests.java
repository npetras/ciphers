package com.nicolaspetras.ciphers.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Tests
{
//   @Test
//   void testCaesarCipher()
//   {
//      String p = "Hello World! 123&*%";
//
//      String expected = "Khoor Zruog! 123&*%";
//      Assertions.assertEquals(expected,Ciphers.caesar(3, p));
//
//      expected = "Ebiil Tloia! 123&*%";
//      Assertions.assertEquals(expected, Ciphers.caesar(-3, p));
//
//      expected = "Axeeh Phkew! 123&*%";
//      Assertions.assertEquals(expected, Ciphers.caesar(45, p));
//
//      expected = "Olssv Dvysk! 123&*%";
//      Assertions.assertEquals(expected, Ciphers.caesar(-45, p));
//   }

   @Test
    void testVigenereCipher()
   {
       String p = "Hello World! 123&*%";

       String expected = "Hfnlp Yosnd! 123&*%";
       Assertions.assertEquals(expected, Ciphers.vigenere("abc", p));

       expected = "Hfpcm Ohnjw! 123&*%";
       Assertions.assertEquals(expected, Ciphers.vigenere("Aberystwyth", p) );

       expected = "Oiwwc Ocjsh! 123&*%";
       Assertions.assertEquals(expected, Ciphers.vigenere("HELLOSOS", p) );

   }
}
