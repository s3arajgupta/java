package practice.striversSDE180.arraysPart2;

public class rotateImage90clockwiseOptimal {

    public static void main (String args[]){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        matrix = rotateImage90clockwiseOptimalFunc(matrix);

        for(int[] row : matrix){
            for (int ele : row)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static int[][] rotateImage90clockwiseOptimalFunc(int[][] matrix){

        int n = matrix.length;
        int temp;
        
        for(int i = 0; i < n; i++){
            for (int j = i; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
        return matrix;

    }
}
