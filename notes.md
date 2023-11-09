# Design

## Package 'library'

This package owns a LibraryManagement class which implements the Library interface. This interface specifies methods that are used by the 'interactor' package (see below). The constructor for the LibraryManagement class reads in catalogue data -- eventually from disk, but we can hardcode some mock data in the meantime if we need to -- and creates a Catalog object (see below).

The package also owns the LibraryUser class, used to identify users of the Library system, and a small `public static LibraryFactory` class whose `createLibrary` method returns a LibraryManagement object (this method's return type is actually `Library` the interface, not `LibraryManager` the class).

All classes except the interface and the factory are package-private.

### Sub-package 'catalogue'

This package owns all the library assets plus the Author/Producer/Director types. The package has a CatalogueManagement class which implements the Catalogue interface. This interface specifies catalogue-specific operations such as adding/removing and borrowing/returning/reserving assets.

## Package 'interactor'

This package takes care of all interaction with the user. Its main method takes a Library type object as its only argument.

## Package 'util'

File operations, stdin/stdout operations, useful string methods, etc

