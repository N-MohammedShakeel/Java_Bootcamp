package Java_Bootcamp.DSA.Basic.String.Easy;

public class ValidGmail {
    public static void main(String[] args) {
        // Test case
        String[] emails = {"test@gmail.com", "invalid@xyz.com", "user@yahoo.com", "abc@hotmail.com"};
        System.out.println("Valid email count: ");
        validGmail(emails);
    }

    public static void validGmail(String[] str) {
        int validCount = 0;
        for (String s : str) {
            if (s.matches("^[a-zA-Z0-9]+@(gmail|yahoo|hotmail)\\.com")) validCount++;
        }
        System.out.println(validCount);
    }
}