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
    public static int getValidNumber(String prompt, int max) {
        var in = new Scanner(System.in);
        int value = 0;
        int choice = 0;
        while(value == 0){
            System.out.print(prompt);
            String userInput = in.nextLine();
            if (userInput.isEmpty()){
                System.out.println(RED+" You did not enter a value!!" + RESET);
            }else{
                try {
                    value = Integer.parseInt(userInput);
                    if (value < 0){
                        value = 0;
                        System.out.println(RED+" Please only positive numbers allowed!!!"+RESET);
                    } else if (value > max) {
                        System.out.println(RED+" Number should only be in the range of : "+RESET+"'1' and "+max+" !!");
                    }
                    choice = value;
                } catch (NumberFormatException nf) {
                    System.out.println(" NumberFormatException: - your input '"+RED + userInput + "' is invalid!"+RESET);
                }
            }

        }

        return choice;
    }

    public static int getPositiveNumber(String prompt, int max) {
        return getValidNumber(prompt, max);
    }

    public static int getAnyInt(String prompt) {
        return getValidNumber(prompt,Integer.MAX_VALUE);
    }
    /*
     The response pattern regex in this method for
     name, title and topic are same:"[a-zA-Z -]+",
     for the ISBN:"";
     */
    public static String getValidString(String prompt, String responsePattern) {
        var in = new Scanner(System.in);
        boolean flag = false;
        String userInput;
        System.out.print(prompt);
        do {
            switch (prompt){
                case "Title" -> System.out.print(" Enter Title: ");
                case "Topic" -> System.out.print(" Enter Topic: ");
                case "ISBN" -> System.out.print(" Enter ISBN: ");
                case "Name" -> System.out.print(" Enter Name: ");
                default -> System.out.print(" Enter valid input: ");
            }
            userInput = in.nextLine();
            if (userInput.isEmpty()){
                System.out.println(RED+" You did not enter a value!!"+RESET);
            } else if (!userInput.matches(responsePattern)) {
                System.out.println(RED+" Please enter a valid input!!!"+RESET);
            }else{
                flag = userInput.matches(responsePattern);
            }

        }while(!flag);

        return userInput;
    }
}
