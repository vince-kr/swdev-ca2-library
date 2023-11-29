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
        var sb = new StringBuilder();
        sb.append("=======================================================================\n");
        sb.append(StringFormat.fixedLength(GREEN+"ID",15));
        sb.append(StringFormat.fixedLength("TITLE",15));
        sb.append(StringFormat.fixedLength("TOPIC",15));
        sb.append(StringFormat.fixedLength("YEAR",15));
        sb.append(StringFormat.fixedLength("AUTHOR",15));
        sb.append(StringFormat.fixedLength("SUMMARY"+RESET,15));
        sb.append("\n");
        sb.append("=======================================================================\n");
        if (!thesis.isEmpty()){
            for (Map.Entry<Integer,ThesisDissertation> item: thesis.entrySet()){
                sb.append(StringFormat.fixedLength(item.getKey(),15));
                sb.append(StringFormat.fixedLength(item.getValue().getTitle(),15));
                sb.append(StringFormat.fixedLength(item.getValue().getTopic(),15));
                sb.append(StringFormat.fixedLength(item.getValue().getPublishedDate(),15));
                sb.append(StringFormat.fixedLength(item.getValue().getCreatorName(),15));
                sb.append(StringFormat.fixedLength(item.getValue().getSummary(),15));
                System.out.println(sb);
            }
        }else{
            System.out.println(RED+"No thesis from file."+RESET);
        }

    }
}
