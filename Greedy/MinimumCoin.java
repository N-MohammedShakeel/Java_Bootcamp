package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.Greedy;

public class MinimumCoin {

    public static void main(String[] args) {

        int[] arr = {1000,500,200,100,50,20,10,5,2,1};
        int sum = 182739712;
        int index = 0;

        while (sum != 0){

            if(sum >= arr[index]){
                System.out.println(arr[index]);
                sum -= arr[index];
            }

            if(sum < arr[index]){
                index++;
            }
        }


        int[] bills = {5,5,5,10,20,20};
        boolean res = lemonadeChange(bills);
        System.out.println(res);
    }

    //https://leetcode.com/problems/lemonade-change/
    public static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        boolean result = true;
        int index = 0;

        while(index < bills.length){

            if(bills[index] == 5){
                five++;
            }else if(bills[index] == 10){
                if(five > 0){
                    five--;
                    ten++;
                }
                else{
                    result = false;
                    break;
                }
            }else{
                if((five > 0) && (ten > 0)){
                    five--;
                    ten--;
                }else if(five >= 3){
                    five -= 3;
                }
                else{
                    result = false;
                    break;
                }
            }
            index++;
        }

        return result;
    }
}
