package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public class ListAvailableAssets extends Interaction {
    String header = "LIST AVAILABLE ASSETS\n";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        System.out.println(library.getAvailableAssets());

        this.nextReference = "common-filters";
    }
}
