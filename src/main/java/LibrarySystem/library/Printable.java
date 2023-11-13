package LibrarySystem.library;

import java.util.ArrayList;

public interface Printable <T>{
    void printToFile(ArrayList<T> objects, String filePath);
    void readFromCsv(String csvFile);
}
