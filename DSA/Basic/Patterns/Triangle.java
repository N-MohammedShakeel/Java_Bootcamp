package Java_Bootcamp.DSA.Basic.Patterns;
import java.util.Scanner;

public class Triangle {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int col = sc.nextInt();
		int row = sc.nextInt();

		
		//trianglePattern(row , col);
		/* 
		     * 
		    * * 
		   * * * 
		  * * * * 
		 * * * * * 
		 
		*/
		
		//DownwardTrianglePattern(row , col);
		/*
		 
		 * * * * * 
		  * * * * 
		   * * * 
		    * * 
		     * 
		*/
		
		//DownwardTriangleHollowPattern(5,5);
		/*
		 
		 * * * * * 
		  *     * 
		   *   * 
		    * * 
		     * 		
        */
		
		//downwardsRightTrianglePattern(row , col);
		/*
			* * * * * 
			* * * * 
			* * * 
			* * 
			* 
		*/
		
		//RightTrianglePattern(row , col);
		/*
			* 
			* * 
			* * * 
			* * * * 
			* * * * * 
		*/
		
		//diamond(row , col);
		/*
		     * 
		    * * 
		   * * * 
		  * * * * 
		 * * * * * 
		  * * * * 
		   * * * 
		    * * 
		     * 
        */
		
		//rightfacingTriangle(row , col);
		/*
		          * 
		        * * 
		      * * * 
		    * * * * 
		  * * * * * 
		    * * * * 
		      * * * 
		        * * 
		          * 
		 */
		
		//diamondHollow(row , col);
		/*
		     * 
		    * * 
		   *   * 
		  *     * 
		 *       * 
		  *     * 
		   *   * 
		    * * 
		     * 
        */
		
		RightTrianglePatternUsing2D(row,col);
		
	}
	
	public static void trianglePattern(int row ,int col) {
		
		for (int i = 1; i <= row; i++) { 

			for (int j = col; j >= i; j--) { 
				System.out.print(" "); 
			} 

			for (int j = 1; j <= i; j++) { 
				System.out.print("* "); 
			} 

			System.out.println(); 
		} 
	}
	
	public static void DownwardTrianglePattern(int row ,int col) {
		
		for (int i = row; i > 0; i--) { 

			for (int j = col; j >= i; j--) { 
				System.out.print(" "); 
			} 

			for (int j = 1; j <= i; j++) { 
				System.out.print("* "); 
			} 

			System.out.println(); 
		} 
	}
	
	public static void DownwardTriangleHollowPattern(int row ,int col) {
		
		for (int i = row; i > 0; i--) { 

			for (int j = col; j >= i; j--) { 
				System.out.print(" "); 
			} 

			for (int j = 1; j <= i; j++) { 
				
				if ((i == 4 && (j == 2||j == 3)) || (i == 3 && j == 2)) {
					System.out.print("  ");
				}else {
					System.out.print("* ");
				}

			} 

			System.out.println(); 
		} 
	}
	
	public static void downwardsRightTrianglePattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = i ; j <= col ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void RightTrianglePattern(int row ,int col) {
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j <= i  ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}	
	

	public static void diamond(int row ,int col) {
		
		for (int i = 1; i <= row; i++) { 

			for (int j = col; j >= i; j--) { 
				System.out.print(" "); 
			} 

			for (int j = 1; j <= i; j++) { 
				System.out.print("* "); 
			} 

			System.out.println(); 
		} 
		
		for (int i = row - 1 ; i > 0; i--) { 

			for (int j = col; j >= i; j--) { 
				System.out.print(" "); 
			} 

			for (int j = 1; j <= i; j++) { 
				System.out.print("* "); 
			} 

			System.out.println(); 
		} 
	}
	
	public static void rightfacingTriangle(int row ,int col) {
		
		for (int i = 1; i <= row; i++) { 

			for (int j = col; j >= i; j--) { 
				System.out.print("  "); 
			} 

			for (int j = 1; j <= i; j++) { 
				System.out.print("* "); 
			} 

			System.out.println(); 
		} 
		
		for (int i = row - 1 ; i > 0; i--) { 

			for (int j = col; j >= i; j--) { 
				System.out.print("  "); 
			} 

			for (int j = 1; j <= i; j++) { 
				System.out.print("* "); 
			} 

			System.out.println(); 
		} 
	}
	
	
	public static void diamondHollow(int row ,int col) {
		
		for (int i = 1; i <= row; i++) { 

			for (int j = col; j >= i; j--) { 
				System.out.print(" "); 
			} 

			for (int j = 1; j <= i; j++) { 
				if ((i == 4 && (j == 2||j == 3)) || (i == 3 && j == 2) || (i == 5 && (j == 2||j == 3||j == 4))) {
					System.out.print("  ");
				}else {
					System.out.print("* ");
				}
				
			} 

			System.out.println(); 
		} 
		
		for (int i = row - 1 ; i > 0; i--) { 

			for (int j = col; j >= i; j--) { 
				System.out.print(" "); 
			} 

			for (int j = 1; j <= i; j++) { 
				if ((i == 4 && (j == 2||j == 3)) || (i == 3 && j == 2)) {
					System.out.print("  ");
				}else {
					System.out.print("* ");
				}
			} 

			System.out.println(); 
		} 
	}
	
	
	public static void RightTrianglePatternUsing2D(int row ,int col) {
		
		String[][] arr = new String[row][col];
		
		for(int i = 0 ; i < row  ; i++) {
			for(int j = 0 ; j <= i  ; j++) {
				arr[i][j] = "* ";
			}
		}
		
		for(int i = 0 ; i < row  ; i++) {
			for(int j = 0 ; j <= i  ; j++) {
				System.out.print(arr[i][j]);
			}
			
			System.out.println();
		}
		
	}	

}


