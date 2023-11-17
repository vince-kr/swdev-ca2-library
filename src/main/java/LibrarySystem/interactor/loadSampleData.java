package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.util.io.StandardInput;

public class loadSampleData extends Interaction {
    String header = "LOAD SAMPLE DATA\n";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        if (StandardInput.getYesNo("Would you like to load sample data?"))
            library.loadSampleData();
    }
}
