package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.*;

public class UniqueFinder {

    public List<Character> uniqueChars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("parameter error");
        }
        Set<Character> result = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.charAt(i));
        }
        return new ArrayList<>(result);
    }
}
