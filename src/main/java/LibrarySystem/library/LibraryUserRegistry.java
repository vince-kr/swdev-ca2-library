package LibrarySystem.library;

import java.util.Collections;
import java.util.HashMap;

public class LibraryUserRegistry extends HashMap<Integer, LibraryUser> {
    void addUser(LibraryUser newUser) {
        this.put(getLastID() + 1, newUser);
    }

    String summariseUsers() {
        var userSummary = new StringBuilder();
        for (int userID : this.keySet())
            userSummary.append(userID + ".  " + this.get(userID) + "\n");

        return userSummary.toString();
    }

    int getLastID() {
        return this.isEmpty() ? 20000 : Collections.max(this.keySet());
    }
}
