## User interaction

`HashMap<String, Interaction> allInteractions`:
	A collection of String identifiers for Interaction objects
	The strings are all literals that refer to the functionality they enable
	The objects are created by unique classes, each of which is instantiated exactly once
	I.e. Entry<"borrow-asset", new BorrowAsset()>
	
Each object that extends abstract class Interaction has a method requestAndResponse() which handles user interaction. This method optionally determines the next menu to present by setting field String nextReference; by default any given menu will refer to "main" (the main menu) as the next menu to present.

Interaction objects are split into two general categories:

1. Menus: the user is presented with a list of 2 or more options, plus a 'Back' option. These options represent either more menus, or:
2. Functionality: the user is optionally asked for a prompt (for example, when adding a new library customer, we ask the user to enter the new customer's name) and is almost always presented with some kind of output: a list of assets, a confirmation of an action, etc

User menus are created in the Interactor class. This class is instantiated exactly once, in the program's main method, and handles all user interaction. Its constructor calls a private method that builds up the HashMap of interactions by instantiating a unique class for each menu Interaction or functionality Interaction. Each menu is constructed in a dedicated method for the sake of organisation.

Menu items are objects of type MenuItem. Each MenuItem takes a String description -- which is presented to the user -- and a String nextInteractionReference which is a key in the allInteractions HashMap. When the user enters their choice for a given menu option, the nextInteractionReference field of the menu is set to the value of the chosen menu item. On the next iteration of the event loop, that new Interaction is presented.
