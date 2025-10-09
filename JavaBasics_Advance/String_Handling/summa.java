package Java_Bootcamp.JavaBasics_Advance.String_Handling;

public class summa {
    public static void main(String[] args) {
        permute("", "ABC");
    }

    static void permute(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char c = remaining.charAt(i);
            String next = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(prefix + c, next);
        }
    }
}
