package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class LibraryUser extends Person implements PrintMap<LibraryUser>{
    private ArrayList<Asset> borrowedBooks;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";


    public LibraryUser(String name) throws PersonException {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public ArrayList<Asset> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Asset> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return String.format("UserName: %s",getName());
    }

    @Override
    public void printToFile(HashMap<Integer, LibraryUser> objects, String csvFilePath) {

    }

    @Override
    public HashMap<Integer, LibraryUser> readFromCsv(String csvFilePath) {
        return null;
    }


}
