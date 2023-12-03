package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
import LibrarySystem.library.PersonException;
import LibrarySystem.util.format.StringFormat;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class UsersFromFile extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";

    @Override
    public void requestAndResponse(Library library) {

        try {
            HashMap<Integer, LibraryUser> users = Files.readUserFromFile("users.csv");

            if (!(users == null)) {
                var sb = new StringBuilder();
                sb.append(StringFormat.fixedLength(GREEN + "ID", 12));
                sb.append(StringFormat.fixedLength("USER" + RESET, 24));
                sb.append("\n");
                if (!users.isEmpty()) {
                    for (Map.Entry<Integer, LibraryUser> user : users.entrySet()) {
                        sb.append(StringFormat.fixedLength(user.getKey(), 12));
                        sb.append(StringFormat.fixedLength(user.getValue().getName(), 24));
                        sb.append("\n");
                    }
                    System.out.println(sb);
                } else {
                    System.out.println(RED + " No users from the file." + RESET);
                }
            }
        } catch (PersonException e) {
            throw new RuntimeException(e);
        }

    }
}
