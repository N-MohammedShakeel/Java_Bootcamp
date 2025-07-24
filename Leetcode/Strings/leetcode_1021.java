package Java_Bootcamp.Leetcode.Strings;

public class leetcode_1021 {
    public String removeOuterParentheses(String s) {

        char[] arr = s.toCharArray();
        String res = "";
        int left = 0;
        int right = 0;
        int count = 0;
        int i = 0;


        while(right < arr.length-1){

            if(arr[i] == '('){
                count++;
            }else if(arr[i] == ')'){
                count--;
            }

            while (count != 0) {
                i++;

                if (arr[i] == '(') {
                    count++;
                } else if (arr[i] == ')') {
                    count--;
                }

                if (count == 0) {
                    right = i;
                }

            }

            for (int j=left+1 ; j<right ; j++){
                res += arr[j];
            }

            left = right+1;
            i++;

        }
        return res;
    }
}
