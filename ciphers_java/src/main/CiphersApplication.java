import com.nicolaspetras.ciphers.java.ciphers.*;
import com.nicolaspetras.ciphers.java.ciphers.exceptions.InvalidCipherKeyException;
import com.nicolaspetras.ciphers.java.ciphers.exceptions.UnknownCipherType;

import java.util.Scanner;

/**
 * Main application class.
 * <p>Responsible for initialising the command line interface, handling and appropriately responding to user input.
 */
public class CiphersApplication {
    private static Scanner scan = new Scanner(System.in);
    private static Caesar caesar;
    private static Vigenere vigenere;


    /**
     * Starts up the application, and provides a command line interface to the user.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) throws UnknownCipherType {

        printWelcomeMessage();
        String plainText = getStringInputFromUser("Please provide the plain text you want to encipher: ");
        String cipherType = getStringInputFromUser("Which cipher would you like to use? \n" +
                "Type 'c' for the Caesar Cipher, and 'v' for the Vigenere cipher: ");
        cipherType = cipherType.trim();
        cipherType = cipherType.toLowerCase();

        // NOTE: could become a method returning a generic
        // make sure the input was valid
        while (!cipherType.equals("c") && !cipherType.equals("v")) {
            System.out.println("The value " + cipherType + " is not valid.");
            cipherType = getStringInputFromUser("Please provide a valid value of 'c' or 'v' for the type of cipher you would" +
                    " like to use");
            cipherType = cipherType.trim();
            cipherType = cipherType.toLowerCase();
        }

        String cipherText;

        switch (cipherType) {
            case "c":
                useCaesarCipher(plainText);
                break;
            case "v":
                useVigenereCipher(plainText);
                break;
            default:
                throw new UnknownCipherType("An Unknown Cipher type " + cipherType + " was provided");
        }
    }

    /**
     * Enciphers the plaintext using the Caesar cipher, as well as providing the Caesar specific CLI interface.
     *
     * @param plainText The plaintext the user provided
     */
    private static void useCaesarCipher(String plainText) {
        String message = "Please provide a number Caesar cipher key (number between -25 and 25)";
        int caesarCipherKey;
        boolean validKey;

        do {
            caesarCipherKey = getIntInputFromUser(message);
            validKey = true;
            try {
                caesar = new Caesar(caesarCipherKey);

            } catch (InvalidCipherKeyException ex) {
                // print error
                validKey = false;
            }
        } while (!validKey);

        encipherUsingCaesar(plainText, caesarCipherKey);
    }

    /**
     * Returns the int that the user provided when prompted with the <code>message</code>
     * <p>Current usage is only to get the Caesar key from the user.
     *
     * @param message The message prompt to provoide the user
     * @return The int the user provided, following the prompt
     */
    private static int getIntInputFromUser(String message) {
        System.out.println(message);
        // TODO: Catch Exceptions for Invalid Input
        return scan.nextInt();
    }


    /**
     * Enciphers the plaintext using the Vigenere cipher, as well as providing the Vigenere specific CLI interface.
     *
     * @param plainText The plaintext the user provided
     */
    private static void useVigenereCipher(String plainText) {
        String message = "Please provide a string Vigenere cipher key - the key should only contain \n" +
                "alphabetic characters (letters), it should not contain numbers or other " +
                "non-alphabetic characters:";
        String vigenereCipherKey = getStringInputFromUser(message);
        setVigenereKey(vigenereCipherKey);
        encipherUsingVigenere(plainText, vigenereCipherKey);
    }


    /**
     * Prints a message prompt to the user and then receives String input from the user.
     *
     * @param message The message to be printed to the user, as a prompt for the data they should provide.
     * @return The String input received from the user.
     */
    private static String getStringInputFromUser(String message) {
        System.out.println(message);
        // TODO: Catch Exceptions for Invalid Input
        // TODO: Ensure all characters are alphabetic and spaces
        return scan.nextLine();
    }

    /**
     * Enciphers the plaintext using the Caesar cipher algorithm and key
     *
     * @param plainText The plaintext the user provided
     * @param caesarCipherKey The Caesar cipher key the user provided
     */
    private static void encipherUsingCaesar(String plainText, int caesarCipherKey) {
        try {
            String caesarCipherText = caesar.encipher(plainText);
            System.out.println("Resulting ciphertext: ");
            System.out.println(caesarCipherText);
            System.out.println("\nProduced from:");
            System.out.println("Plaintext: " + plainText);
            System.out.println("Caesar key: " + caesarCipherKey);
            System.out.println(caesarCipherText);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    /**
     * Enciphers the plaintext using the Vigenere cipher algorithm and key
     *
     * @param plainText The plaintext the user provided
     * @param vigenereCipherKey The Vigenere cipher key the user provided
     */
    private static void encipherUsingVigenere(String plainText, String vigenereCipherKey) {
        try {
            String vigenereCipherText = vigenere.encipher(plainText);
            System.out.println("Resulting ciphertext: ");
            System.out.println(vigenereCipherText);
            System.out.println("\nProduced from:");
            System.out.println("Plaintext: " + plainText);
            System.out.println("Vigenere key: " + vigenereCipherKey);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     *
     * @param vigenereCipherKey
     */
    private static void setVigenereKey(String vigenereCipherKey) {
        try {
            vigenere = new Vigenere(vigenereCipherKey);
        } catch (InvalidCipherKeyException ex) {
            // ask for another key
        }
    }

    /**
     * Prints the welcome message for the application to the user.
     */
    private static void printWelcomeMessage() {
        System.out.println("----------------------------- Ciphers -----------------------------");
        System.out.println("This application allows you to encipher any piece of text ");
        System.out.println("(plain text), using one of two ciphers: Caesar or Vigenere");
        System.out.println("into cipher text\n");
    }
}
