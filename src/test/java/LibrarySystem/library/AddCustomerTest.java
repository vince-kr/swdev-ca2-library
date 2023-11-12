package LibrarySystem.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCustomerTest {

    @Test
    @DisplayName("Call public method to add library customer")
    void addCustomer() {
        Library library = LibraryFactory.createLibrary();
        library.addUser("Vince");
    }

    @Test
    @DisplayName("Confirm adding one customer changes the number of customers")
    void addCustomerThenTotalCustomersPlusOne() {
        Library library = LibraryFactory.createLibrary();
        library.addUser("Vince");
        assertEquals(1, library.getCustomerCount());
    }

    @Test
    @DisplayName("Retrieve all customers")
    void addCustomerThenRetrieve() {
        Library library = LibraryFactory.createLibrary();
        library.addUser("Vince");

        String userRepresentation = """
                ID      NAME
                1       Vince""";

        assertEquals(userRepresentation, library.getAllUsers());
    }
}
