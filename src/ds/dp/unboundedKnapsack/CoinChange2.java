package ds.dp.unboundedKnapsack;

/**
 * Unbounded Knapsack problem :: variant 3 :: Coin Change II ( Multiple occurrence possible)
 * Find Minimum number of coin required to get Sum.
 * Algo: t[i][j]= min(t[i][j-coin[i-1]],t[i-1][j])
 *        else
 *        t[i][j]=t[i-1][j];
 *
 * I/P : coin[] ={1,2,3}, sum = 5
 * O/P: 2 ==> {1,1,1,1,1},{1,1,1,2},{1,2,2},{3,2},{1,1,3} , ==> {3,2} 2 coin required.
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coin = {1,2,3};
        int sum = 5;
        int[][] t=new int[coin.length+1][sum+1];
        for(int i=0;i<=coin.length;i++){
            for (int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j]=Integer.MAX_VALUE-1;
                }
                if(j==0 && i!=0){
                    t[i][j]=0;
                }
            }
        }
        for(int j=1;j<=sum;j++){
            if(j%coin[0]==0){
                t[1][j]=j/coin[0];
            }else {
                t[1][j] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i=2;i<=coin.length;i++){
            for(int j=2;j<=sum;j++){
                if(coin[i-1]<=j){
                    t[i][j]=Math.min(t[i][j-coin[i-1]]+1,t[i-1][j]);
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }

        System.out.println("Minimum No. of coin required to get sum "+sum +" is :: "+t[coin.length][sum]);
    }
}
