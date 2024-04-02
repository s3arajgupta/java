package practice.striversSDE180.arrays;

class pascalsTriangleVar2Brute{
    
    public static void main (String args[]){
        
        int n = 5;

        for(int i = 1; i <= n; i++)
            System.out.print(pascalsTriangleFunc(n-1, n-i) + " ");
        
    }
    
    static int pascalsTriangleFunc(int n, int r){
         
        int res = 1;

        for(int i = 0; i < r; i++){
            res*=(n-i);
            res/=(i+1);
        }
        return res;

    }
}

