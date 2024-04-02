package practice.striversSDE180.arrays;

class pascalsTriangleVar2Optimal{
    
    public static void main (String args[]){
        
        int n = 10;
        int ans = 1;

        for (int i = 1; i <= n; i++){
            System.out.print(ans + " ");
            ans = ans * (n-i)/i;
        }
        System.out.println();
        
    }
}

