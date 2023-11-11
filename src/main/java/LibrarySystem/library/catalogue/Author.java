package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.catalogue.BookAudioBook;

import java.util.ArrayList;

public class Author extends Person {
    private ArrayList<BookAudioBook> booksAuthored;

    public Author(int id, String name) {
        super(id, name);
        this.booksAuthored = new ArrayList<>();
    }

    public ArrayList<BookAudioBook> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(ArrayList<BookAudioBook> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }

    @Override
    public String toString() {
        return String.format("AuthorId: %d, AuthorName: %s", getId(), getName());
    }
}
