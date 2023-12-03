package LibrarySystem.library;

import LibrarySystem.util.format.StringFormat;

import java.util.HashMap;

public class LibraryAuthorUser extends HashMap<Integer,Person> {

    public String toString( ) {
        var authorSummary = new StringBuilder();
        for (int userID : this.keySet()) {
            authorSummary.append(StringFormat.fixedLength(userID, 12));
            authorSummary.append(StringFormat.fixedLength(this.get(userID).getName(), 36));
        }

        return authorSummary.toString();
    }
}
