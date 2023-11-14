package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public interface AskUpdateContinue {
    void requestAndResponse(Library library);
    String getNextReference();
}
