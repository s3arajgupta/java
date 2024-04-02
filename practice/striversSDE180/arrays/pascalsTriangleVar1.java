// Time Complexity: O(c), where c = given column number.
// Reason: We are running a loop for r times, where r is c-1.

// Space Complexity: O(1) as we are not using any extra space.

package practice.striversSDE180.arrays;

class pascalsTriangleVar1{
    
    static int pascalsTriangleFunc (int n, int r){

        int res = 1;
        
        for (int i = 1; i <= (n-r); i++){
           res = res*(n-i+1); 
           res = res/i;
        }
        return res;
    }

    public static void main (String args[]){
        
        int n = 5;
        int r = 3;

        int res = pascalsTriangleFunc(n-1, r-1);

        System.out.println(res);

    }
    
}

