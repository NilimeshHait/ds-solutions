package ds.dp.unboundedKnapsack;

/**
 * Unbounded Knapsack problem :: variant 1 ( Multiple occurrence possible)
 * Algo: t[i][j]= max(profit[i-1]+t[i][j-weight[i-1]],t[i-1][j])
 *        else
 *        t[i][j]=t[i-1][j];
 *
 *  Maximize the Profit
 */

public class RodCutting {

    public static void main(String[] args) {
        int[] length={1,2,3,4,5};
        int[] profit={8,3,5,6,7};
        int maxLength=8;

        int[][] t=new int[length.length+1][maxLength+1];

        for(int i=0;i<=length.length;i++){
            for(int j=0;j<=maxLength;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1;i<=length.length;i++){
            for(int j=1;j<=maxLength;j++){
                if(length[i-1]<=j){
                    t[i][j]=Math.max(profit[i-1]+t[i][j-length[i-1]],t[i-1][j]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        System.out.println("Maximum Profit ::"+t[length.length][maxLength]);
    }
}
