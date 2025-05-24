package Java_Bootcamp.DSA.Basic.Patterns;
import java.util.Scanner;

public class Rectangle {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//rectanglePattern(5,5);
		/*
			* * * * * 
			* * * * * 
			* * * * * 
			* * * * * 
			* * * * * 
		*/
		
		//rectangleSpaceInEvenPattern(5,5);
		/*
			*   *   * 
			*   *   * 
			*   *   * 
			*   *   * 
			*   *   *  
		*/
		
		//rectangleCenterSpacePattern(5,5);
		/*
			* * * * * 
			*       * 
			*       * 
			*       * 
			* * * * * 
		*/
		
	    //hashPattern(5,5);
		/*
			  *   *   
			* * * * * 
			  *   *   
			* * * * * 
			  *   *    
		*/
		
		//excludingHashPattern(5,5);
		/*
			*   *   * 
			          
			*   *   * 
			          
			*   *   * 
		*/
		
		//diagonalPattern(5,5);
		/*
			*         
			  *       
			    *     
			      *   
			        * 
		*/
		
		//oppositeDiagonalPattern(5,5);
		/*
			        * 
			      *   
			    *     
			  *       
			*         
		*/
		
		//crossDiagonalPattern(5,5);
		/*
			*       * 
			  *   *   
			    *     
			  *   *   
			*       * 
		*/
		
		//plusPattern(5,5);
		/*
			    *     
			    *     
			* * # * * 
			    *     
			    *     
		*/
		
	}
	
	public static void rectanglePattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void rectangleSpaceInEvenPattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<= col ; j++) {
				
				if(j % 2 == 0) {
					System.out.print("  ");
				}else {
					System.out.print("* ");
				}
				
			}
			System.out.println();
		}
	}
	
	public static void rectangleCenterSpacePattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				
				if(i==1 || j==1  || i== row || j == row) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	
	
	public static void hashPattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				
				if(i % 2 == 0 || j % 2 == 0) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}	
	
	public static void excludingHashPattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				
				if(i % 2 != 0 && j % 2 != 0) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}	
	
	public static void diagonalPattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				
				if(i == j) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}	
	
	public static void oppositeDiagonalPattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				
				if(i+j == 6) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}		
	
	public static void crossDiagonalPattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				
				if(i == j || i+j == 6) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}		
	
	public static void plusPattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j<=col ; j++) {
				
				if(i == 3 || j == 3) {
					if( i == j) {
						System.out.print("# ");
					}else {
						System.out.print("* ");
					}
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}	
	
	
	

}
