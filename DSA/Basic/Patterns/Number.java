package Java_Bootcamp.DSA.Basic.Patterns;

import java.util.Scanner;

public class Number {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();

		//easyNum(col,row);
		/*
			1 2 3 4 5 
			1 2 3 4 5 
			1 2 3 4 5 
			1 2 3 4 5 
			1 2 3 4 5 
		*/
		
	}

	public static void easyNum(int col , int row) {
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				
				System.out.print(j+ " ");

				}
			System.out.println();
		}
	}
	

}
