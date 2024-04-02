package practice.striversSDE180.arraysPart1;

class pascalsTriangleVar3Optimal{
    
    public static void main (String args[]){
        
        int n = 10;
        int ans = 1;

        for (int rows = 1; rows <= n; rows++){
            ans = 1;
            for (int i = 1; i <= rows; i++){
                System.out.print(ans + " ");
                ans = ans * (rows-i)/i;
            }
            System.out.println();
        }
        
    }
}

