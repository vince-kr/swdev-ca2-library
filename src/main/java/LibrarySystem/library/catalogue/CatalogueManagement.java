package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;

import java.util.*;

class CatalogueManagement implements Catalogue {
    final HashMap<Integer, Person> allCreators;
    final AssetsRegister allAssets;

    public CatalogueManagement(String csvCatalogueData) {
        allCreators = new HashMap<>();
        allAssets = new AssetsRegister();
    }

    @Override
    public void addAsset(Asset toAdd) {
        int currentID = computeCurrentID(allAssets.keySet());
        allAssets.put(currentID + 1, toAdd);
    }

    @Override
    public int getAssetCount() {
        return allAssets.size();
    }

    @Override
    public HashMap<Integer, Person> getAllCreators() {
        return allCreators;
    }

    @Override
    public int getLastCreatorID() {
        return computeCurrentID(allCreators.keySet());
    }

    @Override
    public AssetsRegister getAssetsForCreator(Person creator) {
        return allAssets.byCreator(creator);
    }

    public AssetsRegister getAllAssets() {
        return allAssets;
    }

    @Override
    public Author addAuthor(String name) throws PersonException {
        for (Person existingAuthor : allCreators.values()) {
            String authorName = existingAuthor.getName();
            if (authorName.equals(name))
                // Existing author found
                return (Author) existingAuthor;
        }

        // If this is reached, no existing author was found
        int currentID = computeCurrentID(allCreators.keySet());
        var newAuthor = new Author(name);
        allCreators.put(currentID + 1, newAuthor);

        return newAuthor;
    }

    @Override
    public Producer addProducer(String name) throws PersonException {
        for (Person existingProducer : allCreators.values()) {
            String producerName = existingProducer.getName();
            if (producerName.equals(name))
                // Existing author found
                return (Producer) existingProducer;
        }

        // If this is reached, no existing author was found
        int currentID = computeCurrentID(allCreators.keySet());
        var newProducer = new Producer(name);
        allCreators.put(currentID + 1, newProducer);

        return newProducer;
    }

    @Override
    public Director addDirector(String name) throws PersonException {
        for (Person existingDirector : allCreators.values()) {
            String directorName = existingDirector.getName();
            if (directorName.equals(name))
                // Existing author found
                return (Director) existingDirector;
        }

        // If this is reached, no existing author was found
        int currentID = computeCurrentID(allCreators.keySet());
        var newDirector = new Director(name);
        allCreators.put(currentID + 1, newDirector);

        return newDirector;
    }

    @Override
    public Asset getAsset(int Id) {
        return allAssets.get(Id);
    }

    private int computeCurrentID(Collection<Integer> keys) {
        return keys.isEmpty() ? 10000 : Collections.max(keys);
    }
}
