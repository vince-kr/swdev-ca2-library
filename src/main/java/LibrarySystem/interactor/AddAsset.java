package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.catalogue.*;
import LibrarySystem.util.io.StandardInput;

import java.time.Year;

public class AddAsset extends Interaction {

    String header = "ADD AN ASSET\n";

    String[] assetTypes = {
            "Book/Audiobook",
            "CD/DVD",
            "Thesis/Dissertation"
    };

    @Override
    public void requestAndResponse(Library library) {
        /*
        Steps to add an asset:
        1.  Ask user for the type of asset to add
        2.  Depending on the type, ask further information
            Book: title, ISBN, year of publication, author (author is an object, so should be selected
                or created on-the-fly)
            CD/DVD: title, producer, director, play time, year of publication (producer and director
                are objects, so should be selected from a list or created on-the-fly)
            Thesis/dissertation: title, author, topic, summary, year of publication
        3. Once all information has been gathered, create a new Asset object of the correct type
            and call library.addAsset() with it
            ISSUE: in order for this to work, all Asset specialisations need to be made public
        */

        System.out.println(header);
        String assetType = askAssetType(assetTypes);

        Asset newAsset;

        String title = askTitle();
        String yearOfPublication = askYoP();

        switch (assetType) {
            case "Book/Audiobook":
                String ISBN = askISBN();
                Author bookAuthor = null;
                try {
                    bookAuthor = askAuthor();
                } catch (PersonException e) {
                    throw new RuntimeException(e);
                }
                newAsset = new BookAudioBook(title, ISBN, yearOfPublication, bookAuthor);
                break;
            case "CD/DVD":
                Producer producer = null;
                try {
                    producer = askProducer();
                } catch (PersonException e) {
                    throw new RuntimeException(e);
                }
                Director director = null;
                try {
                    director = askDirector();
                } catch (PersonException e) {
                    throw new RuntimeException(e);
                }
                int playTime = askPlaytime();
                newAsset = new CdDvd(title, producer, director, playTime, yearOfPublication);
                break;
            default:  // Thesis or dissertation
                Author thesisAuthor = null;
                try {
                    thesisAuthor = askAuthor();
                } catch (PersonException e) {
                    throw new RuntimeException(e);
                }
                String topic = askTopic();
                String summary = askSummary();
                newAsset = new ThesisDissertation(title, thesisAuthor, topic, summary, yearOfPublication);
                break;
        }

        library.addAsset(newAsset);

        nextReference = "manage-catalogue";
    }

    private String askSummary() {
        String prompt = "Enter summary: ";
        String responsePattern = "^[\\p{L} ,.'-]+$";

        return StandardInput.getValidString(prompt, responsePattern);

    }

    private String askTopic() {
        String prompt = "Enter topic: ";
        String responsePattern = "^[\\p{L} ,.'-]+$";

        return StandardInput.getValidString(prompt, responsePattern);
    }

    private int askPlaytime() {
        String prompt = "Enter play time in seconds: ";
        return StandardInput.getPositiveInt(prompt,18000);
    }

    private int askQuantity(){
        String prompt = "Enter quantity of asset: ";
        return StandardInput.getPositiveInt(prompt, 50);
    }

    private Director askDirector() throws PersonException {
        String prompt = "Enter director full name: ";
        String responsePattern = "^[\\p{L} '-]+$";

        String directorName = StandardInput.getValidString(prompt, responsePattern);

        return new Director(directorName);
    }

    private Producer askProducer() throws PersonException {
        String prompt = "Enter producer full name: ";
        String responsePattern = "^[\\p{L} '-]+$";

        String producerName = StandardInput.getValidString(prompt, responsePattern);

        return new Producer(producerName);
    }

    private Author askAuthor() throws PersonException {
        String prompt = "Enter author full name: ";
        String responsePattern = "^[\\p{L} '-]+$";

        String authorName = StandardInput.getValidString(prompt, responsePattern);

        return new Author(authorName);
    }

    private String askYoP() {
        String prompt = "Enter year of publication: ";
        int max = Year.now().getValue();

        return Integer.toString(StandardInput.getPositiveInt(prompt, max));
    }

    private String askAssetType(String[] assetTypes) {

        for (int index = 0; index < assetTypes.length; index++) {
            int fmtIndex = index + 1;
            System.out.println(fmtIndex + ".  " + assetTypes[index]);
        }

        int choice = StandardInput.getPositiveInt("Your choice: ", assetTypes.length);

        return assetTypes[choice-1];
    }

    private String askTitle() {
        String prompt = "Enter title: ";
        String responsePattern = "^[\\p{L} ,.'-]+$";

        return StandardInput.getValidString(prompt, responsePattern);
    }

    private String askISBN() {
        String prompt = "Enter ISBN: ";
        String responsePattern = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";

        return StandardInput.getValidString(prompt, responsePattern);
    }

}
