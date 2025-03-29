package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.Infosys;

import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int energy = sc.nextInt();
        int size = sc.nextInt();
        int res = 0 ;

        int[] arr = new int[size];
        int[] dummy = new int[size];

        for(int i=0 ; i < size ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0 ; i < size ; i++){
            if(energy == arr[i]){
                res = 1;
                System.out.println(res);
                return;
            }
        }

        int index = 0;

        while(!(energy <= 0)){

            if(index == size){
                res = -1;
                break;
            }

            energy = energy - arr[index];
            res++;
            dummy[index] = dummy[index] + 1;

            if(dummy[index] == 2){
                index =  index + 1;
            }


        }

        System.out.println(res);

    }
}
