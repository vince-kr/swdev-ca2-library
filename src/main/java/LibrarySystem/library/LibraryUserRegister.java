package LibrarySystem.library;

import LibrarySystem.util.format.StringFormat;

import java.util.Collections;
import java.util.HashMap;

public class LibraryUserRegister extends HashMap<Integer, LibraryUser> {
    void addUser(LibraryUser newUser) {
        this.put(getLastID() + 1, newUser);
    }

    public String toString() {
        var userSummary = new StringBuilder();

        for (int userID : this.keySet()) {
            userSummary.append(StringFormat.fixedLength(userID, 12));
            userSummary.append(StringFormat.fixedLength(this.get(userID).getName(), 36));
        }

        return userSummary.toString();
    }

    int getLastID() {
        return this.isEmpty() ? 20000 : Collections.max(this.keySet());
    }
}
