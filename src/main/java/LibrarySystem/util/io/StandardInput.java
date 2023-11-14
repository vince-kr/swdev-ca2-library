package LibrarySystem.util.io;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

import java.util.ArrayList;
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
                        System.out.println(RED + " Number should only be in the range of : "+RESET+ min + " and " + max + "!");
                    }
                } catch (NumberFormatException nf) {
                    System.out.println(" NumberFormatException: - your input '"+RED + userInput + "' is invalid!"+RESET);
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
        System.out.print(prompt);
        do {
            switch (prompt) {
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
    /*
     get asset type
     */
    public static Asset getAssetType(){
        int select = 0;
        while(select == 0){
            System.out.println("Select asset type you want to create:");
            System.out.println(" Type 1 - Book Asset");
            System.out.println(" Type 2 - CdDvd Asset");
            System.out.println(" Type 3 - ThesisDissertation Asset");
            System.out.println(" Type 4 - Exit");
            select = getIntInRange("Choice: ",1,4);
            switch (select){
                case 1:
                    //create and return book asset
                    break;
                case 2:
                    //create and return cd asset
                    break;
                case 3:
                    //create and return thesis asset
                    break;
                case 4:
                    System.out.println(RED+" Choose a type of asset to create!!!"+RESET);
                default:
                    System.out.println(RED+" Invalid Choice, please follow instructions!!"+RESET);
            }
        }
        return null;
    }
}
