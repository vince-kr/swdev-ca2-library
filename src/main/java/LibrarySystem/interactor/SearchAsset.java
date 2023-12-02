package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.Searchable;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetsRegister;

import java.util.ArrayList;
import java.util.Map;

import static LibrarySystem.interactor.AssetOperation.searchLibraryCatalogue;

public class SearchAsset extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "SEARCH FOR AN ASSET\n";
    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        if (library.getAllAssets().isEmpty()){
            System.out.println(RED + "No assets in the system." + RESET);
            return;
        }
        //lambda implementation
        Searchable assetToFind = ()->{
            AssetsRegister allAssets = library.getAllAssets();
            ArrayList<String> assetNames = new ArrayList<>();
            for (Map.Entry<Integer, Asset> asset:allAssets.entrySet()){
                assetNames.add(asset.getValue().getTitle());
                assetNames.add(asset.getValue().getCreatorName());
                assetNames.add(asset.getValue().getAssetType());
            }
            return assetNames;
        };
        if (assetToFind.getSearchableFields().equals("")){
            System.out.println(RED+"Asset not found"+RESET);
        }
        assetToFind.getSearchableFields();
        searchLibraryCatalogue(library.getAllAssets());

    }
}
