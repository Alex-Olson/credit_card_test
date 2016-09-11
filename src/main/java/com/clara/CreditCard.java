package com.clara;

import java.util.InputMismatchException;
import java.util.Scanner;


public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the Visa credit card number, digits only:");
        String ccNumber = String.valueOf(intInput());
        boolean isValid = isVisaCreditCardNumberValid(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid Visa credit card number");
        } else {
            System.out.println("This is **not** a valid Visa credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isVisaCreditCardNumberValid(String cardNumber) {

        //TODO Replace with your code to process the credit card number, and determine if it is valid.
        //TODO Make sure all the tests pass!
        String[] cardDigitsString = cardNumber.split("");
        int[] cardDigits = new int[cardDigitsString.length];

        for (int i = 0; i < cardDigitsString.length; i++){
            cardDigits[i] = Integer.parseInt(cardDigitsString[i]);
        }

        if (cardDigits[0] != 4 || cardDigits.length != 16){
            return false;
        } else {
            int digitTotal = 0;

            for (int i = 0; i < cardDigits.length; i++){

                if ((i + 1) % 2 == 0){
                    digitTotal += cardDigits[i];
                } else {
                    int doubleDigit = cardDigits[i] * 2;
                    if (cardDigits[i] > 4){
                        digitTotal += (doubleDigit / 10) + (doubleDigit % 10);
                    } else {
                        digitTotal += doubleDigit;
                    }
                }
            }

            if (digitTotal % 10 == 0){
                return true;
            } else {
                return false;
            }

        }

    }


    //everything past this line was copy/pasted from https://github.com/minneapolis-edu/Java2545examples/blob/master/src/week3_methods/Validation.java
    // A variant of the method below - notice it calls intInput with null as the argument
    public static long intInput() {
        return intInput(null);
    }

    //Takes a question, asks user the question, checks to make sure user enters an int, and
    //then returns that int to the calling method.
    public static long intInput(String question) {

        while (true) {
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.println(question);
            }

            //Try to read what the user typed as an int.
            try {
                // If the input can be read as a int, that int will be returned
                // This ends the loop, and this method, and control returns to the calling method.
                return stringScanner.nextLong();
            } // if the input can't be read as an int, then an error will be raised.
            // For example, if the user enters 'ten' or 1.4 or 123456543454343434, these are not ints, so will cause an error.
            // That error can be 'caught' by this code, and we can print an error message.
            // Since we are inside a while loop, then the loop can repeat and ask the user for input again.
            catch (InputMismatchException ime) {
                System.out.println("Error - please enter an integer number");
                stringScanner.next();   //Clear any other characters from the Scanner
            }

        }
    }

}
