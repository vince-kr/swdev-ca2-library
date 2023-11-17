package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public class ListAllAssets extends Interaction {
    String header = "LIST ALL ASSETS\n";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        System.out.println(library.summariseAllAssets());

        this.nextReference = "common-filters";
    }
}
