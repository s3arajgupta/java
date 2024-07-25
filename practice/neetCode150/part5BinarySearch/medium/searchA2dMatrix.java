package practice.neetCode150.part5BinarySearch.medium;

public class searchA2dMatrix {

    public static void main (String args[]){

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 0));
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 10));
        System.out.println(searchMatrix(matrix, 11));
        System.out.println(searchMatrix(matrix, 20));
        System.out.println(searchMatrix(matrix, 34));
        System.out.println(searchMatrix(matrix, 61));
        
    }

    public static boolean searchMatrix (int[][] matrix, int target){

        int top = 0, bot = matrix.length-1, mid = 0;

        while (top <= bot) {

            mid = bot + (top - bot)/2;
            if (target > matrix[mid][matrix[0].length-1]) top = mid + 1; 
            else if (target < matrix[mid][0]) bot = mid - 1; 
            else break;
        }
        // System.out.println(mid);

        if (top > bot) return false;

        int l = 0, r = matrix[0].length - 1, m = 0;
        while (l <= r){
            m = r + (l-r)/2;
            if (target > matrix[mid][m]) l = m+1;
            else if (target < matrix[mid][m]) r = m-1;
            else return true;
        }

        return false;
    }
}
