package Java_Bootcamp.String;


public class Problems {

    public static void main(String[] args) {

        countDigit(12345);
        stringReverse(123567);
    }

    static void countDigit(int a){
        String b = Integer.toString(a);
        System.out.println(b.length());
    }

    static void stringReverse(int a){

        StringBuffer str = new StringBuffer(String.valueOf(a));
        str.reverse();
        int b = Integer.parseInt(String.valueOf(str));
        System.out.println(b);

    }
}
