package Java_Bootcamp.Leetcode.GreedyAlgorithm;

public class leetcode_860 {
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
