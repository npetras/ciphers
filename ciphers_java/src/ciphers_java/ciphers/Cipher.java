package ciphers_java.ciphers;

/**
 * Defines a basic common class from which all ciphers can inherit.
 */
public abstract class Cipher
{
   String plaintext;

   public Cipher()
   {
      this.plaintext = "";
   }

   public Cipher(String plaintext)
   {
      this.plaintext = plaintext;
   }

   public String getPlaintext()
   {
      return plaintext;
   }

   public void setPlaintext(String plaintext)
   {
      this.plaintext = plaintext;
   }

   /**
    * Method used to encipher this cipher's plaintext into cipher text, by applying the key being
    * used.
    *
    * @return The encicphered plain text (cipher text)
    */
   public abstract String encipher();


}
