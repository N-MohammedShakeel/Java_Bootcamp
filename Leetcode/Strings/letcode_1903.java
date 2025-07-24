package Java_Bootcamp.Leetcode.Strings;

public class letcode_1903 {
    public String largestOddNumber(String num) {
        int index = num.length()-1;
        while (index >= 0){

            if(Integer.parseInt("" + num.charAt(index)) % 2 == 1){
                return num.substring(0,index+1);
            }
            index--;
        }
        return "";
    }
}
