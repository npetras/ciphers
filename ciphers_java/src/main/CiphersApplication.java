import com.nicolaspetras.ciphers.java.ciphers.Caesar;
import com.nicolaspetras.ciphers.java.ciphers.UnknownCipherType;

import java.util.Scanner;

/**
 *
 */
public class CiphersApplication
{
    private static Scanner scan = new Scanner(System.in);
    private static Caesar caesar;


    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) throws UnknownCipherType
    {
        printWelcomeMessage();
        String plainText = getStringInputFromUser("Please provide the plain text you want to encipher: ");
        String cipherType = getStringInputFromUser("Which cipher would you like to use? \n" +
                "Type 'c' for the Caesar Cipher, and 'v' for the Vigenere cipher: ");

        cipherType = cipherType.trim();
        cipherType = cipherType.toLowerCase();

        String cipherText;

        switch (cipherType) {
            case "c":
                // get Caesar cipher key
                // encipher plain text with that cipher key
                break;
            case "v":
                // get Vigenere cipher key
                // encipher plain text using that cipher key
                break;
            default:
                throw new UnknownCipherType("An Unknown Cipher type" + cipherType + "was provided");
        }

        // encipher the plain text based on the input
        // print out the cipher text
    }

    /**
     * Prints a message prompt to the user and then receives String input from the user.
     *
     * @param message The message to be printed to the user, as a prompt for the data they should provide.
     * @return The String input received from the user.
     */
    private static String getStringInputFromUser(String message)
    {
        System.out.println(message);
        return scan.nextLine();
    }

    /**
     * Prints the welcome message for the application to the user.
     */
    private static void printWelcomeMessage()
    {
        System.out.println("----------------------------- Ciphers -----------------------------");
        System.out.println("This application allows you to encipher any piece of text ");
        System.out.println("(plain text), using one of two ciphers: Caesar or Vigenere");
        System.out.println("into cipher text\n");
    }
}
