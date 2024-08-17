package ds.dp.unboundedKnapsack;


/**
 * Unbounded Knapsack problem ( Multiple occurrence possible)
 * Algo: t[i][j]= max(profit[i-1]+t[i][j-weight[i-1]],t[i-1][j])
 *        else
 *        t[i][j]=t[i-1][j];
 */

public class UnboundedKnaksack {
    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 7};
        int[] profit= {4, 3, 6, 8};
        int maxWeight= 8;

        int[][] t =new int[weights.length+1][maxWeight+1];

        for(int i=0;i<=weights.length;i++){
            for(int j=0;j<=maxWeight;j++){
                if(i==0 || j==0) {
                    t[i][j] = 0;
                }
            }
        }
        for (int i=1;i<=weights.length;i++){
            for(int j=1;j<=maxWeight;j++){
                if(weights[i-1]<=j){
                    t[i][j]=Math.max(profit[i-1]+t[i][j-weights[i-1]],t[i-1][j]);
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        System.out.println("Max profit :: "+t[weights.length][maxWeight]);

    }
}
