package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public class SearchAuthor extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "SEARCH FOR AN AUTHOR\n";
    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

    }
}
