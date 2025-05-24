package Java_Bootcamp.DSA.Basic.Patterns;

import java.util.Scanner;

public class Alphabet {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		
		//numberAlphabetShuffle(col,row);
		/*
			A  3  4  5  6  
			3  B  5  6  7  
			4  5  C  7  8  
			5  6  7  D  9  
			6  7  8  9  E  
		*/
		
		//numberAlphabet(col,row);
		/*
			1  2  3  4  5  
			A  B  C  D  E  
			6  7  8  9  10  
			F  G  H  I  J  
			11  12  13  14  15
		*/
		
		//alphaNumeric(col , row);
		/*
			1  2  3  4  5  
			A  B  C  D  E  
			1  2  3  4  5  
			A  B  C  D  E  
			1  2  3  4  5  
		*/
		
		//alphaNumericsquare(col,row);
		/*
			A  B  C  D  E  
			F  G  H  I  J  
			K  L  M  N  O  
			2  4  6  8  10  
			12  14  16  18  20  
		*/
		
	}


	
			
			
          public static void numberAlphabetShuffle(int col , int row) {
				
				//int sum = 3;
				char ch = 'A';
				for(int i=1;i<=row;i++) {
					for(int j=1;j<=col;j++) {
						if(i==j) {
						System.out.print((char)ch++ + "  ");
						}else {
							System.out.print(i+j + "  ");
						}
				}
					System.out.println();
			}	
          }
          
          public static void numberAlphabet(int col , int row) {
				
				int sum = 1;
				char ch = 'A';
				for(int i=1;i<=row;i++) {
					for(int j=1;j<=col;j++) {
						if(i % 2 != 0) {
						System.out.print(sum++ + "  ");
						}else {
						 System.out.print((char)ch++ + "  ");
						}
				}
					System.out.println();

			}	
          }
         
          
          public static void alphaNumeric(int col , int row) {
				
				int sum = 1;
				char ch = 'A';
				for(int i=1;i<=row;i++) {
					for(int j=1;j<=col;j++) {
						
						if(i%2 == 0) {
						System.out.print((char)ch++ + "  ");
						}else {
							System.out.print(sum++ + "  ");
						}
				   }
					sum = 1;
					ch = 'A';
					
					System.out.println();
				}
			}	
          
          
          public static void alphaNumericsquare(int col , int row) {
				
    				int sum = 0;
    				char ch = 'A';
    				
    				for(int i=1;i<=row;i++) {
    					for(int j=1;j<=col;j++) {
    						
    						if(i <= 3) {
    						System.out.print((char)ch++ + "  ");
    						}else {
    							sum += 2;
    							System.out.print(sum + "  ");
    						}
    				   }
    					System.out.println();
    				}
    			}	

}