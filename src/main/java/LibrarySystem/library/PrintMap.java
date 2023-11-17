package LibrarySystem.library;

import java.util.HashMap;

public interface PrintMap <T>{
    /*
    These are generic methods that
    concrete classes which a list
    of hash map will implement.
    */
    void printToFile(HashMap<Integer,T> objects, String csvFilePath);
    HashMap<Integer,T> readFromCsv(String csvFilePath);
}
