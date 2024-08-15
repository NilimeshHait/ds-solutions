package ds.dp.knapsack01;

/**
 *
 * 0/1 Knapsack problem:: Variant 1 (Subset Sum problem)
 * Algo:
 * if(arr[i-1]<=j)
 *      t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j]
 * else
 *      t[i][j]=t[i-1][j]
 *
 * Example:
 *  Input: arr[1,3,5,7], sum=10
 *  Output: true ( Sum of 3 and 7 is 10)
 */


public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7};
        int sum = 10;
        // Using top-down approach
        boolean[][]t=new boolean[arr.length+1][sum+1];
        for (int i=0;i<arr.length+1;i++){
            for (int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        for (int i=1;i<arr.length+1;i++){
            for (int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }

        System.out.println("Expected sum("+sum+") is present ? : "+t[arr.length][sum]);
        //Using Recursion
        SubsetSum ss=new SubsetSum();
        System.out.println("Expected sum("+sum+") is present(Using Recursion) ? : "+ss.subsetSum(arr,sum,arr.length));
    }

    boolean subsetSum(int [] arr,int sum,int n){

        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n-1]<=sum){
            return subsetSum(arr,sum-arr[n-1],n-1) || subsetSum(arr,sum,n-1);
        }else {
            return subsetSum(arr,sum,n-1);
        }
    }
}
