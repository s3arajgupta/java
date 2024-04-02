package practice.striversSDE180.arraysPart1;

class setMatrixZerosBetterNormal {
    
    static int[][] setZeroes(int[][] matrix, int m, int n) {

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        // System.out.println(matrix);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }

        return matrix;
    }

    public static void main (String args[]){

        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        System.out.println(matrix);
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] ans = setZeroes(matrix, m, n);
        
        System.out.println("Answer");
        // System.out.println(ans);
        // OR
        for (int[] row : ans){
            for (int ele : row){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}