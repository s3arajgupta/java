package practice.striversSDE180.arrays;

class pascalsTriangleVar1Optimal{
    
    public static void main (String args[]){
        
        int n = 11;
        int r = 8;

        int res = pascalsTriangleFunc(n-1, r-1);

        System.out.println(res);
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

