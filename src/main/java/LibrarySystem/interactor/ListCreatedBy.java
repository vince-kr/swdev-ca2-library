package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.Person;
import LibrarySystem.library.catalogue.AssetsRegister;
import LibrarySystem.util.format.StringFormat;
import LibrarySystem.util.io.StandardInput;

import java.util.HashMap;
import java.util.Map;

public class ListCreatedBy extends Interaction {
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";
    String header = "ASSETS CREATED BY AUTHOR\n";

    @Override
    public void requestAndResponse(Library library) {
        nextReference = "common-filters";

        System.out.println(header);

        if (library.getAllCreators().isEmpty()) {
            System.out.println(RED+"No authors exist in the system yet."+RESET);
            return;
        }

        Person creator = askCreator(library);

        AssetsRegister createdBy = library.getAssetsForCreator(creator);
        System.out.println(createdBy);
    }

    private Person askCreator(Library library) {
        HashMap<Integer, Person> allCreators = library.getAllCreators();
        String prompt = "Please enter the required author ID: ";

        System.out.println(formatCreators(allCreators));
        int creatorID = StandardInput.getPositiveInt(prompt, library.getLastCreatorID());

        Person selectedCreator = allCreators.get(creatorID);
        if (selectedCreator != null) {
            return selectedCreator;
        }
        else {
            System.out.println(RED+"User with given Id not found in the system!"+RESET);
            return askCreator(library);
        }
    }

    private String formatCreators(HashMap<Integer, Person> creators) {
        var creatorsSummary = new StringBuilder();

        creatorsSummary.append(StringFormat.fixedLength("ID", 12));
        creatorsSummary.append(StringFormat.fixedLength("NAME", 36));
        creatorsSummary.append("\n");

        for (Map.Entry<Integer, Person> creatorEntry : creators.entrySet()) {
            creatorsSummary.append(StringFormat.fixedLength(creatorEntry.getKey(), 12));
            creatorsSummary.append(StringFormat.fixedLength(creatorEntry.getValue().getName(), 36));
            creatorsSummary.append("\n");
        }

        return creatorsSummary.toString();
    }

}
