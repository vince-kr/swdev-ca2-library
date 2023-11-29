package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.BookAudioBook;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class AssetsToFile extends Interaction{
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
        HashMap<Integer,Asset> assets = library.getAllAssets();
        if (!assets.isEmpty()){
            Files.printAssetsToFile(assets,"assets.csv");
        }else{
            System.out.println(RED+" No assets in the system yet."+RESET);
        }
    }
}
