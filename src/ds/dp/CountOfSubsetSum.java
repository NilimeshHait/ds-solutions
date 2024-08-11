package ds.dp;

/**
 *
 * 0/1 Knapsack problem:: Variant 3 (count of subset sum with a given sum)
 * Algo:
 * -----------------------------------------------------
 * if(arr[i-1]<=j)
 *      t[i][j]= t[i-1][j-arr[i-1]] + t[i-1][j]
 * else
 *      t[i][j]=t[i-1][j]
 *
 * Example:
 *  Input: arr[2,3,5,6,8,4], sum=10
 *  Output: 3 ( {2,3,5},{2,8},{6,4})
 */

public class CountOfSubsetSum {

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,5,6,8,4};
        int sum=10;
        int[][] t=new int[arr.length+1][sum+1];

        for(int i=0;i<=arr.length;i++){
            for (int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }

        for(int i=1;i<= arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }

        System.out.println("No. of subset present :: "+t[arr.length][sum]);
    }

}
