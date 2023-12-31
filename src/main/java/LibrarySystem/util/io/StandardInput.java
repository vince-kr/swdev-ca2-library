package LibrarySystem.util.io;

import java.util.Scanner;

public abstract class StandardInput {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";

    /*
     The prompt of this method will accept
     strings such as: 'EnterId: ','Enter Choice: '
     and a positive max value
     */
    public static int getIntInRange(String prompt, int min, int max) {
        var in = new Scanner(System.in);
        boolean inputIsValid = false;
        int choice = 0;

        while (!inputIsValid) {
            System.out.print(prompt);
            String userInput = in.nextLine();

            if (userInput.isEmpty()) {
                System.out.println(RED+" You did not enter a value!!" + RESET);
            } else {
                try {
                    choice = Integer.parseInt(userInput);
                    if (min <= choice && choice <= max) {
                        inputIsValid = true;
                    } else {
                        System.out.println(RED + " Number should only be in the range of : "+ min + " and " + max + "!"+RESET);
                    }
                } catch (NumberFormatException nf) {
                    System.out.println(RED+" NumberFormatException: - your input '" + userInput + "' is invalid!"+RESET);
                }
            }
        }

        return choice;
    }

    public static int getPositiveInt(String prompt, int max) {
        return getIntInRange(prompt, 1, max);
    }

    public static int getAnyInt(String prompt) {
        return getIntInRange(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /*
     The response pattern regex in this method for
     name, title and topic are same:"[a-zA-Z -]+",
     for the ISBN:"^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
     */
    public static String getValidString(String prompt, String responsePattern) {
        var in = new Scanner(System.in);
        boolean flag = false;
        String userInput;

        do {
            switch (prompt) {
                case "Title" -> System.out.print(" Enter Title: ");
                case "Topic" -> System.out.print(" Enter Topic: ");
                case "ISBN" -> System.out.print(" Enter ISBN: ");
                case "Name" -> System.out.print(" Enter Name: ");
                default -> System.out.print(prompt);
            }
            userInput = in.nextLine();
            if (userInput.isEmpty()){
                System.out.println(RED+" You did not enter a value!!"+RESET);
            } else if (!userInput.matches(responsePattern)) {
                System.out.println(RED + " Please enter a valid input!!!" + RESET);
            } else if(prompt.equals("Name") && (userInput.length() < 2 || userInput.length() > 30)){
                System.out.println(RED+" Name must be between 2 and 30 characters long!!!"+RESET);
            }else{
                flag = userInput.matches(responsePattern);
            }
        } while(!flag);

        return userInput;
    }


    public static boolean getYesNo(String prompt) {
        var in = new Scanner(System.in);

        System.out.print(prompt + "[y/n] ");
        String userInput = in.nextLine();

        if (userInput.matches("^[YyNn]$"))
            return userInput.matches("[Yy]");

        System.out.println("WARNING - Your input was not valid. Please enter Y or N.");
        return getYesNo(prompt);
    }
}
