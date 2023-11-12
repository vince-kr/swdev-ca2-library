package LibrarySystem.util.format;

public class StringFormat {
    public static String fixedLength(String toPad, int length) {
        int strLen = toPad.length();
        String formatted;

        if (strLen == length)
            formatted = toPad;
        else if (strLen < length)
            formatted = String.format("%1$-" + length + "s", toPad);
        else
            formatted = toPad.substring(0, length - 3) + "...";

        return formatted;
    }

    public static String fixedLength(int toPad, int length) {
        return fixedLength("" + toPad, length);
    }
}
