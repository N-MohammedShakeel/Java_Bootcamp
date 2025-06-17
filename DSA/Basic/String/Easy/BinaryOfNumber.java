package Java_Bootcamp.DSA.Basic.String.Easy;

public class BinaryOfNumber {
    public static void main(String[] args) {
        // Test case
        System.out.println("Binary representation: ");
        binaryOfNumber(10);
    }

    public static void binaryOfNumber(int num) {
        String result = "";
        while (num > 0) {
            int rem = num % 2;
            result = rem + result;
            num /= 2;
        }
        System.out.println(result);
    }
}