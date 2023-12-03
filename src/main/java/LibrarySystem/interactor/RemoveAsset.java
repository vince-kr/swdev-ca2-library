package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public class RemoveAsset extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "REMOVE AN ASSET\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
            steps to remove an assset
            1. list the available assets
            2. choose the asset to remove
            3. remove asset and display message
         */
        System.out.println(header);


    }
}
