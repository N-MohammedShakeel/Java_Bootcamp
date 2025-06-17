package Java_Bootcamp.DSA.Basic.String.Easy;

public class LastWordLength {
    public static void main(String[] args) {
        // Test case
        System.out.println("Length of last word: ");
        lastWordLength();
    }

    public static void lastWordLength() {
        String str = "  hello everyone     programming  ";
        int length = 0;
        int i = str.length() - 1;

        while (str.charAt(i) == ' ')
            i--;

        while (str.charAt(i) != ' ') {
            length++;
            i--;
        }

        System.out.println(length);
    }
}