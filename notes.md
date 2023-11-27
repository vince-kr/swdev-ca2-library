# Design

## User-facing design

```
MAIN menu
|--OPERATIONS
|	|--BORROW asset
|	|--RETURN asset
|--LISTS
|	|--all BORROWED
|	|--created by AUTHOR (/producer/director?)
|	|--borrowed by USER
|	|--OVERDUE
|	|--ALL assets
|--CATALOGUE management
|    |--ADD asset
|    |--REMOVE asset
|    |--ADD author
|--USER management
|    |--ADD library customer
|    |--DEACTIVATE customer (or delete?)
```
### Notes on methods

The following notes attempt to describe the required steps at a high level, plus suggestions for methods that the `Library` interface should define.

#### BORROW asset

1. Ask Librarian to select a user  
	Search by ID / name?
2. Ask Librarian to select an asset to borrow  
	Search by title / author?
3. Interface method `borrowAsset(Asset toBorrow)`: call with the selected asset
    1. Asset is available: qty in stock - 1, borrowed by customer + 1; Loan object is created from Asset + User and records the borrowed-on-date and return-by-date
    2. Asset is not available: reserve the asset for this user

#### RESERVE asset


#### RETURN asset

1. Ask Librarian to select a user
2. Ask Librarian which Asset which is currently borrowed by this user should be returned
	Should allow multiple assets to be selected
3. Interface method `returnAsset(Asset toReturn)`: call once for every selected asset
	qty in stock + 1, borrowed by customer - 1; Loan object is destroyed

## 2. Internal design

### Packages

The system is split into three major packages:

#### interactor

This package takes care of all interaction with the user. Its main method takes an object of type Library -- i.e. an instance of some class that implements the `Library` interface -- as its only argument.

#### library

This package owns a LibraryManagement class which implements the Library interface. An instance of LibraryManagement is created early in the lifetime of the program and is passed to the main method of the interactor package.

The Library package has several subpackages:

- **catalogue.operations:** common operations such as borrowing, returning, and reserving assets
- **catalogue.maintenance:** less common operations such as adding & removing assets
- **users:** maintain library customers

The main purpose of these packages is to organise the code into logical segments. All *behaviour* required by the various options in the menu should be defined in the Library interface and, consequently, implemented in the LibraryManagement class.

#### util

File operations, stdin/stdout operations, useful string methods, etc

### Notes on objects

#### Asset

Objects of type `Asset` represent one unique asset, which may have a quantity greater than 1. E.g. if the library has three copies of Terry Pratchett's "The Colour of Magic", the catalogue will contain one `Asset` object representing this unique combination of author + title + ISBN (and probably an internal-only ID of some kind), which also has a field `int quantity` equal to 3.

Asset objects are fairly simple records of asset attributes that do not define behaviour beyond constructors and getters.

#### Loan

Objects of type `Loan` represent currently active loans. If a library customer borrows an asset, a new Loan object is created that holds references to the customer and the asset and also records the date.

Loan objects may be stored in some collection -- note this means they should also be persisted on disk between program runs. Listing all assets that are currently loaned out becomes very easy: it's simple the entire collection of Loan objects. Listing a selection of loaned out assets, for example based on author or customer, is also straightforward.

#### Person

Objects of type `Person` may represent people associated with Assets: authors, producers, and directors. They may also represent Library *customers*.

# Step-by-step

## Creating a new feature

I realise this is a very general description, but hear me out. Creating a new user-facing feature consists of multiple steps:

1. Implement the actual feature  
   As an example, let's say borrowing an asset. The Library and Catalogue systems need the appropriate methods and logic to handle the scenario of a library customer wanting to borrow an asset.
2. Implement the menu logic  
	In addition to the system logic, the feature must be accessible to the library customer through the menu. This involves various steps.
3. Add the required reference to the Interactor class
