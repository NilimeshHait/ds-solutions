package ds.dp.knapsack01;

/**
 * 0/1 Knapsack problem
 * Algo: t[i][j]= max(value[i-1]+t[i-1][j-w[i-1]],t[i-1][j])
 */
public class KnapsackProblem {
    public static void main(String[] args) {

        int[] weight = new int[]{1, 3, 5, 7};
        int[] profit = new int[]{4, 3, 6, 8};
        int max = 8;
        //Using Top-Down Approach
        int[][] t = new int[5][9];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= max; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }

            }
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= max; j++) {
                if (weight[i - 1] <= j) {
                    t[i][j] = Math.max(profit[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        System.out.println("Max profit :: "+t[4][8] + "\n");

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        //---------------------------------------------
        //Using Recursive approach
        KnapsackProblem np=new KnapsackProblem();
        System.out.println("Max profit( Using Recursive):: "+ np.knapsack(weight,profit,max,4));

        int a=np.knapsack(max,profit,weight);
    }

    //Recursive Function
    int knapsack(int[] wt,int[] value,int w, int n){
        if(n==0 || w==0)
            return 0;
        if(wt[n-1]<=w){
            return Math.max(value[n-1]+knapsack(wt,value,w-wt[n-1],n-1),
                    knapsack(wt,value,w,n-1));
        }else {
            return knapsack(wt,value,w,n-1);
        }
    }

    //Space-Optimized 1D DP
    public int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            int wi = wt[i], vi = val[i];
            // IMPORTANT: iterate w backward for 0/1 knapsack
            for (int w = W; w >= wi; w--) {
                dp[w] = Math.max(dp[w], vi + dp[w - wi]);
                /*for(int k=0;k<dp.length;k++) {
                    System.out.print(dp[k]+ " ");
                }
                System.out.println();*/
            }
        }
        return dp[W];
    }

}
