package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public interface GetUpdateContinue {
    void requestAndResponse(Library library);
    String getNextReference();
}
