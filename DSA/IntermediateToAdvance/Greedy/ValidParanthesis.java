package Java_Bootcamp.DSA.IntermediateToAdvance.Greedy;


public class ValidParanthesis {

    public static void main(String[] args) {

        System.out.println(checkValidStringOptimal("***(()"));
    }

    // Optimal Solution
    //https://leetcode.com/problems/valid-parenthesis-string/
    public static boolean checkValidStringOptimal(String s) {

        char[] arr = s.toCharArray();
        int min = 0 , max = 0;

        for(int i=0 ;  i < arr.length ; i++){

            if(arr[i] == '('){
                min++;
                max++;
            }else if(arr[i] == ')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }

            if(min < 0){
                min = 0;
            }

            if (max < 0){
                return false;
            }
        }

        return min == 0;

    }

    //https://leetcode.com/problems/valid-parenthesis-string/
    public static boolean checkValidString(String s) {

        char[] arr = s.toCharArray();
        int count = 0;
        for(char i=0 ; i < arr.length ; i++){
            if('*' == arr[i] )
                count++;
            else
                break;
        }
        if(count == arr.length){
            return true;
        }
        return check(arr , 0 , 0);
    }

    public static boolean check(char[] arr , int index , int count){

        if(count < 0){
            return false;
        }

        if(index == arr.length){
            return (count == 0);
        }

        if(arr[index] == '(')
            return check(arr , ++index , ++count);
        if(arr[index] == ')')
            return check(arr , ++index , --count);
        if(arr[index] == '*')
            return (check(arr , ++index , ++count) ||
                    check(arr , ++index , --count) ||
                    check(arr , ++index , count));

        return false;

    }
}
