package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.ThesisDissertation;
import LibrarySystem.util.format.StringFormat;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class ReadFromThesis extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        HashMap<Integer, ThesisDissertation> thesis = Files.readThesisCsv("thesis.csv");
        if (!(thesis == null)) {
            var sb = new StringBuilder();
            sb.append(StringFormat.fixedLength(GREEN + "ID", 12));
            sb.append(StringFormat.fixedLength("TITLE", 24));
            sb.append(StringFormat.fixedLength("TOPIC", 24));
            sb.append(StringFormat.fixedLength("YEAR", 12));
            sb.append(StringFormat.fixedLength("AUTHOR", 24));
            sb.append(StringFormat.fixedLength("SUMMARY" + RESET, 24));
            sb.append("\n");
            if (!thesis.isEmpty()) {
                for (Map.Entry<Integer, ThesisDissertation> item : thesis.entrySet()) {
                    sb.append(StringFormat.fixedLength(item.getKey(), 12));
                    sb.append(StringFormat.fixedLength(item.getValue().getTitle(), 24));
                    sb.append(StringFormat.fixedLength(item.getValue().getTopic(), 24));
                    sb.append(StringFormat.fixedLength(item.getValue().getPublishedDate(), 12));
                    sb.append(StringFormat.fixedLength(item.getValue().getAuthor().getName(), 24));
                    sb.append(StringFormat.fixedLength(item.getValue().getSummary(), 24));
                    sb.append("\n");
                }
                System.out.println(sb);
            } else {
                System.out.println(RED + "No thesis from file." + RESET);
            }
        }

    }
}
