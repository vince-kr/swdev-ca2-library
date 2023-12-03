package LibrarySystem.util;

import LibrarySystem.library.Searchable;

import java.util.regex.Pattern;

public abstract class Search {
    public static boolean matchQuery(Searchable haystack, String needle) {
        String needleLower = needle.toLowerCase();

        // Create regex pattern, replacing glob '*' with regex wildcard '.*'
        Pattern pattern = Pattern.compile(needle.replace("*", ".*"));

        boolean match = false;
        // Iterate over searchable fields in the object we're matching
        for (String field : haystack.getSearchableFields())
            if (pattern.matcher(field.toLowerCase()).find())
                match = true;

        return match;
    }
}
