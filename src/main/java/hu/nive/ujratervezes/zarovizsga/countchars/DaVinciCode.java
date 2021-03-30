package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DaVinciCode {
    public int encode(String input, Character c) {
        List<Character> chars = List.of('0', '1', 'x');
        int sum = 0;
        if (!chars.contains(c)) {
            throw new IllegalArgumentException("parameter error");
        }
        try (BufferedReader bf = Files.newBufferedReader(Path.of(input))) {
            String line;
            while ((line = bf.readLine()) != null) {
                int count = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (c == line.charAt(i)) {
                        count++;
                    }
                }
                sum += count;
            }
            return sum;
        } catch (IOException e) {
            throw new IllegalStateException("file error");
        }
    }
}
