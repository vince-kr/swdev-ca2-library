package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.ThesisDissertation;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class ThesisToFile extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
          steps to print assets to file
          1. get all assets in the system
          2. call helper method to print to csv file
        */
        System.out.println(header);
        HashMap<Integer, ThesisDissertation> thesis = new HashMap<>();
        for (Map.Entry<Integer, Asset> asset: library.getAllAssets().entrySet()){
            if (asset.getValue() instanceof ThesisDissertation)
            thesis.put(asset.getKey(), (ThesisDissertation) asset.getValue());
            else
                System.out.println(RED+" No thesis type in asset"+RESET);
        }
        if (!thesis.isEmpty()){
            System.out.println("Printing to file ...");
            Files.DissertationsToFile(thesis,"thesis.csv");
        }else {
            System.out.println(RED+" No thesis in the system yet."+RESET);
        }

    }
}
