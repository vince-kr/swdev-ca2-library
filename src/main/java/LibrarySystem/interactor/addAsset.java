package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.*;
import LibrarySystem.util.io.StandardInput;

import java.time.Year;

public class addAsset extends Interaction {
    String header = "ADD AN ASSET\n";


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
        String assetType = askAssetType();

        Asset newAsset;

        String title = askTitle();
        String yearOfPublication = askYoP();

        switch (assetType) {
            case "Book/Audiobook":
                String ISBN = askISBN();
                Author bookAuthor = askAuthor();
                newAsset = new BookAudioBook(1, title, ISBN, yearOfPublication, bookAuthor);
                break;
            case "CD/DVD":
                Producer producer = askProducer();
                Director director = askDirector();
                int playTime = askPlaytime();
                newAsset = new CdDvd(2, title, producer, director, playTime, yearOfPublication);
                break;
            case "Thesis/Dissertation":
                Author thesisAuthor = askAuthor();
                String topic = askTopic();
                String summary = askSummary();
                newAsset = new ThesisDissertation(6, title, thesisAuthor, topic, summary, yearOfPublication);
                break;
        }

        try {
            library.addAsset(newAsset);
        } catch (NullPointerException np) {}

        nextReference = "manage-catalogue";
    }

    private int askPlaytime() {
        String prompt = "Enter play time in seconds: ";

        return StandardInput.getAnyInt(prompt);
    }

    private Director askDirector() {
        String prompt = "Enter director full name: ";
        String responsePattern = "^[\\p{L} '-]+$";

        String directorName = StandardInput.getValidString(prompt, responsePattern);

        return new Director(5, directorName);
    }

    private Producer askProducer() {
        String prompt = "Enter producer full name: ";
        String responsePattern = "^[\\p{L} '-]+$";

        String producerName = StandardInput.getValidString(prompt, responsePattern);

        return new Producer(4, producerName);
    }

    private Author askAuthor() {
        String prompt = "Enter author full name: ";
        String responsePattern = "^[\\p{L} '-]+$";

        String authorName = StandardInput.getValidString(prompt, responsePattern);

        return new Author(3, authorName);
    }

    private String askYoP() {
        String prompt = "Enter year of publication: ";
        int max = Year.now().getValue();

        return Integer.toString(StandardInput.getPositiveInt(prompt, max));
    }

    private String askAssetType() {
        String[] assetTypes = {
                "Book/Audiobook",
                "CD/DVD",
                "Thesis/Dissertation"
        };

        for (int index = 0; index < assetTypes.length; index++) {
            int fmtIndex = index + 1;
            System.out.println(fmtIndex + ".  " + assetTypes[index]);
        }

        int choice = StandardInput.getPositiveInt("Your choice: ", assetTypes.length);

        return assetTypes[choice-1];
    }

    private String askTitle() {
        String prompt = "Enter title: ";
        String responsePattern = "^[\\p{L} '-]+$";

        return StandardInput.getValidString(prompt, responsePattern);
    }

    private String askISBN() {
        String prompt = "Enter ISBN: ";
        String responsePattern = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";

        return StandardInput.getValidString(prompt, responsePattern);
    }
}
