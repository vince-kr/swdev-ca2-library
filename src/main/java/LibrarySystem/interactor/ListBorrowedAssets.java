package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public class ListBorrowedAssets extends Interaction {
    String header = "LIST BORROWED ASSETS\n";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        System.out.println(library.summariseBorrowedAssets());

        this.nextReference = "common-filters";
    }
}
