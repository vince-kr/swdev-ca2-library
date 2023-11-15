package LibrarySystem.library;

import java.util.ArrayList;

public interface Printable <T>{
    /*
     These are generic methods that enable
     concrete classes to implement
     */
    void printToFile(ArrayList<T> objects, String filePath);
    void readFromCsv(String csvFile);
}
