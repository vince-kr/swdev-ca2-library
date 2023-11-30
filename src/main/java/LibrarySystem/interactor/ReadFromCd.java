package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.CdDvd;
import LibrarySystem.util.format.StringFormat;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class ReadFromCd extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        HashMap<Integer, CdDvd> cds = Files.readCdFromCsv("cds.csv");
        var sb = new StringBuilder();
        sb.append(StringFormat.fixedLength(GREEN+"ID", 12));
        sb.append(StringFormat.fixedLength("TITLE", 24));
        sb.append(StringFormat.fixedLength("PRODUCER", 15));
        sb.append(StringFormat.fixedLength("YEAR", 12));
        sb.append(StringFormat.fixedLength("DIRECTOR", 24));
        sb.append(StringFormat.fixedLength("PLAYTIME", 12));
        sb.append(StringFormat.fixedLength("QUANTITY"+RESET, 12));
        sb.append("\n");
        if (!cds.isEmpty()){
            for (Map.Entry<Integer,CdDvd> cd: cds.entrySet()){
               sb.append(StringFormat.fixedLength(cd.getKey(),12));
               sb.append(StringFormat.fixedLength(cd.getValue().getTitle(),24));
               sb.append(StringFormat.fixedLength(cd.getValue().getProducer().getName(),15));
               sb.append(StringFormat.fixedLength(cd.getValue().getProductionYear(),12));
               sb.append(StringFormat.fixedLength(cd.getValue().getDirector().getName(),24));
               sb.append(StringFormat.fixedLength(cd.getValue().getPlayTime(),12));
               sb.append(StringFormat.fixedLength(cd.getValue().getQuantity(),12));
                sb.append("\n");
            }
            System.out.println(sb);
        }else{
            System.out.println(RED+"No cds from file."+RESET);
        }

    }
}
