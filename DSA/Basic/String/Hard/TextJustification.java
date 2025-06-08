package Java_Bootcamp.DSA.Basic.String.Hard;

import java.util.*;

// TextJustification.java
// Justifies text by distributing spaces to meet max width
// Time: O(n^2), Space: O(n)

public class TextJustification {
    public static void main(String[] args) {
        // Test case
        System.out.println("Text Justification: " + fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)); // [This    is    an, example  of text, justification.  ]
    }

    // Justifies text by distributing spaces to meet max width
    // Time: O(n^2), Space: O(n)
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int count = words[i].length();
            int last = i + 1;
            while (last < words.length && count + words[last].length() + 1 <= maxWidth) {
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder line = new StringBuilder();
            if (last == words.length || last - i == 1) {
                for (int j = i; j < last; j++) {
                    line.append(words[j]);
                    if (j < last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");
            } else {
                int spaces = (maxWidth - count + (last - i - 1)) / (last - i - 1);
                int extra = (maxWidth - count + (last - i - 1)) % (last - i - 1);
                for (int j = i; j < last; j++) {
                    line.append(words[j]);
                    if (j < last - 1) {
                        for (int k = 0; k < spaces + (j - i < extra ? 1 : 0); k++) {
                            line.append(" ");
                        }
                    }
                }
            }
            result.add(line.toString());
            i = last;
        }
        return result;
    }
}