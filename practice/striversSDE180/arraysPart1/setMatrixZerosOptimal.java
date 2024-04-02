package practice.striversSDE180.arraysPart1;

class setMatrixZerosOptimal {
    
    static int[][] setZeroes(int[][] matrix, int m, int n) {
        
        int col = 1;
        
        for(int i = 0; i < m; i++)
            if (matrix[0][i] == 0){
                col = 0;
                break;
            }

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    
                    // matrix[0][j] = 0;
                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col = 0;
                }
            }
        }

        // for (int[] row : matrix){
        //     for (int ele : row){
        //         System.out.print(ele + " ");
        //     }
        //     System.out.println();
        // }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] != 0){
                    if (matrix[0][i] == 0 || matrix[j][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        if (col == 0)
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;

        return matrix;
    }

    public static void main (String args[]){

        int[][] matrix = {{1,1,1},{0,1,1},{1,1,0}};

        int m = matrix.length;
        int n = matrix[0].length;
        
        matrix = setZeroes(matrix, m, n);
        
        System.out.println("Answer");
        // System.out.println(ans);
        // OR
        for (int[] row : matrix){
            for (int ele : row){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}