package LibrarySystem.library;

import LibrarySystem.util.format.StringFormat;

import java.util.Collections;
import java.util.HashMap;

public class LibraryUserRegister extends HashMap<Integer, LibraryUser> {
    public LibraryUser getUser(int id) {
        return this.get(id);
    }

    void addUser(LibraryUser newUser) {
        this.put(getLastID() + 1, newUser);
    }

    public String toString() {
        var userSummary = new StringBuilder();

        userSummary.append(StringFormat.fixedLength("ID", 12));
        userSummary.append(StringFormat.fixedLength("NAME", 36));
        userSummary.append(StringFormat.fixedLength("STATE", 12));
        userSummary.append("\n");

        for (int userID : this.keySet()) {
            LibraryUser user = this.get(userID);
            userSummary.append(StringFormat.fixedLength(userID, 12));
            userSummary.append(StringFormat.fixedLength(user.getName(), 36));
            userSummary.append(StringFormat.fixedLength(user.isActive() ? "Active" : "Inactive", 12));
            userSummary.append("\n");
        }

        return userSummary.toString();
    }

    public int getLastID() {
        return this.isEmpty() ? 20000 : Collections.max(this.keySet());
    }
}
