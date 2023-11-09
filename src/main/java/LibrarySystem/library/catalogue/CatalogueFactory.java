package library.catalogue;

// Similar to the LibraryFactory, the CatalogueFactory is a public class with a single static method
// which returns a new CatalogueManagement instance. The Catalogue needs CSV data to populate its
// records of assets, authors, etc.

public abstract class CatalogueFactory {
    public static Catalogue createCatalogue(String csvCatalogueData) {
        return new CatalogueManagement(csvCatalogueData);
    }
}
