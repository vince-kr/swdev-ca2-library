package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

import java.util.ArrayList;

public class LibraryUser extends Person implements Comparable<LibraryUser>{
    final private ArrayList<Asset> borrowedBooks;



    public LibraryUser(String name) throws PersonException {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public ArrayList<Asset> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedAssets(Asset borrowedAsset) {
        borrowedBooks.add(borrowedAsset);
    }

    @Override
    public String toString() {
        return String.format("UserName: %s",getName());
    }

    /*
     Compare users by the number of assets
     they borrowed
     */
    @Override
    public int compareTo(LibraryUser o) {
        return Integer.compare(this.borrowedBooks.size(),o.borrowedBooks.size());
    }
}
