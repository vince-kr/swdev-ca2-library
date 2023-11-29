package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.CdDvd;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class CdsToFile extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
          steps to print assets to file
          1. get all Cds in the system
          2. call helper method to print to csv file
        */
        System.out.println(header);
        HashMap<Integer, CdDvd> cds = new HashMap<>();
        for (Map.Entry<Integer, Asset> asset:library.getAllAssets().entrySet()){
            if (asset.getValue() instanceof CdDvd)
                cds.put(asset.getKey(), (CdDvd) asset.getValue());
            else
                System.out.println(RED+" No Cd type in the assets."+RESET);

        }
        if (!cds.isEmpty()){
            Files.CdsToFile(cds,"cds.csv");
        }else {
            System.out.println(RED+" No cds in the system yet."+RESET);
        }

    }
}
