// ?
package practice.striversSDE180.arraysPart2;

public class rotateImage90anticlockwiseBrute {

    public static void main (String args[]){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        matrix = rotateImage90anticlockwiseBruteFunc(matrix);

        for(int[] row : matrix){
            for (int ele : row)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static int[][] rotateImage90anticlockwiseBruteFunc(int[][] matrix){

        int n = matrix[0].length;
        int[][] rotated = new int[n][n];
        // int[][] rotated = matrix; ?
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                rotated[j][n-i-1] = matrix[i][j];
                // rotated[i][j] = matrix[j][n-i-1];
            }
        }
        return rotated;
    }
}
