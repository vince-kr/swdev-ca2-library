package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;

import java.util.HashMap;

public interface Catalogue {
    int getAssetCount();
    void addAsset(Asset toAdd);
    Author addAuthor(String name) throws PersonException;
    Producer addProducer(String name) throws PersonException;
    Director addDirector(String name) throws PersonException;
    Asset getAsset(int Id);

    AssetsRegister getAllAssets();

    int getLastAssetID();

    HashMap<Integer, Person> getAllCreators();

    int getLastCreatorID();

    AssetsRegister getAssetsForCreator(Person creator);
}
