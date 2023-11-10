package LibrarySystem.util.io;

import java.util.Scanner;

public abstract class StandardInput {
    public static int getValidNumber(String prompt, int min, int max) {
        var in = new Scanner(System.in);

        System.out.print(prompt);
        String userInput = in.nextLine();
        int choice;

        try {
            choice = Integer.parseInt(userInput);
        } catch (NumberFormatException nf) {
            choice = min - 1;
        }

        if (min <= choice && choice <= max) {
            return choice;
        }

        System.out.println("WARNING - your input '" + userInput + "' is invalid!");
        return getValidNumber(prompt, min, max);
    }

    public static int getPositiveNumber(String prompt, int max) {
        return getValidNumber(prompt, 1, max);
    }

    public static int getAnyInt(String prompt) {
        return getValidNumber(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
