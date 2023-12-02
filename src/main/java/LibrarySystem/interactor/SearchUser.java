package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
import LibrarySystem.library.Searchable;

import java.util.ArrayList;
import java.util.Map;

public class SearchUser extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "SEARCH FOR A USER\n";
    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);
        if (!library.hasUsers()) {
            System.out.println(RED + "No users in the system." + RESET);
            return;
        }
        //lambda implementation
        Searchable userToFind = () ->{
            LibraryUserRegister users = library.getAllUsers();
            ArrayList<String> userNames = new ArrayList<>();
            for (Map.Entry<Integer, LibraryUser> user:users.entrySet()){
                userNames.add(user.getValue().getName());
            }
            return userNames;
        };

        System.out.println(userToFind.getSearchableFields());;
        //this.nextReference = "search-menu";

    }
}
