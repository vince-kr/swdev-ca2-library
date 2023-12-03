package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.Person;
import LibrarySystem.library.Searchable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static LibrarySystem.interactor.AssetOperation.searchAuthors;

public class SearchAuthor extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "SEARCH FOR AN AUTHOR\n";
    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);
        if (library.getAllCreators().isEmpty()){
            System.out.println(RED+"No authors in the system."+RESET);
            return;
        }
        //lambda implementation
        Searchable authorToFind = ()->{
            HashMap<Integer, Person> allCreators = library.getAllCreators();
            ArrayList<String> authorNames = new ArrayList<>();
            for (Map.Entry<Integer,Person> author:allCreators.entrySet()){
                authorNames.add(author.getValue().getName());
            }
            return authorNames;
        };
        if (authorToFind.getSearchableFields().equals("")){
            System.out.println(RED+"author not found."+RESET);
            return;
        }
        authorToFind.getSearchableFields();
        searchAuthors(library.getAllCreators());

    }
}
