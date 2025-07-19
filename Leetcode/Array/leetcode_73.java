package Java_Bootcamp.Leetcode.Array;

public class leetcode_73 {

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] temp = new int[row][col];


        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                temp[i][j] = matrix[i][j];
            }
        }


        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(matrix[i][j] == 0){
                    for(int n = 0 ; n < col ; n++){
                        temp[i][n] = 0;
                    }
                    for(int n = 0 ; n < row ; n++){
                        temp[n][j] = 0;
                    }
                }
            }
        }

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                matrix[i][j] = temp[i][j];
            }
        }

    }
}
