package ds.dp.unboundedKnapsack;

/**
 * Unbounded Knapsack problem :: variant 2 :: Coin Change I ( Multiple occurrence possible)
 * Algo: t[i][j]= t[i][j-coin[i-1]],t[i-1][j])
 *        else
 *        t[i][j]=t[i-1][j];
 *
 * I/P : coin[] ={1,2,3}, sum = 5
 * O/P: 5 ==> {1,1,1,1,1},{1,1,1,2},{1,2,2},{3,2},{1,1,3}
 */
public class CoinChange1 {
    public static void main(String[] args) {
        int[] coin={1,2,3};
        int sum=5;
        int[][] t=new int[coin.length+1][sum+1];

        for (int i=0;i<=coin.length;i++){
            for (int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }
        for(int i=1;i<=coin.length;i++){
            for (int j=1;j<=sum;j++){
                if(coin[i-1]<=j){
                    t[i][j]=t[i][j-coin[i-1]]+t[i-1][j];
                }else {
                    t[i][j]= t[i-1][j];
                }
            }
        }
        System.out.println("Total no. of ways we can achieve Sum "+sum+ " is :: "+t[coin.length][sum]);
    }
}
