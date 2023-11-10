package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

import java.util.ArrayList;

public class LibraryUser extends Person{
    private ArrayList<Asset> borrowedBooks;


    public LibraryUser(int id, String name) {
        super(id, name);
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
        return String.format("UserId: %d, UserName: %s",getId(),getName());
    }
}
