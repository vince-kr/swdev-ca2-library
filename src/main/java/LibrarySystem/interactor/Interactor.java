package LibrarySystem.interactor;

import LibrarySystem.library.Library;

class Interactor {
    boolean isFinished;

    public Interactor() {};

    public boolean userIsFinished() {
        return isFinished;
    }

    public void completeRequestResponseCycle(Library library){};
}
