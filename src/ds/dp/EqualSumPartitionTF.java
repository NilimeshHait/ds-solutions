package ds.dp;

/**
 *
 * 0/1 Knapsack problem:: Variant 2 (Equal sum partition problem)
 * Algo:
 * do sum of all the elements in arr,
 * if sum%2==0 return false
 * else apply subset sum logic for equal sum (sum/2)
 * -----------------------------------------------------
 * if(arr[i-1]<=j)
 *      t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j]
 * else
 *      t[i][j]=t[i-1][j]
 *
 * Example:
 *  Input: arr[5,1,11,5]
 *  Output: true ( Sum = 22 , partition sum is 22/2 == 11 , Two subset are {5,1,5} and {11} with equal sum)
 */

public class EqualSumPartitionTF {

    public static void main(String[] args) {
        int[] arr=new int[]{1,5,11,5};
        int eqSum=0;

        int sum=0;
        for(int i=0 ;i<arr.length;i++){
            sum=sum+arr[i];
        }
        eqSum=sum/2;
        boolean[][] t=new boolean[arr.length+1][eqSum+1];
        if(sum%2==0){
            for (int i=0;i< arr.length+1;i++){
                for (int j=0;j<eqSum+1;j++){
                    if(i==0){
                        t[i][j]=false;
                    }
                    if(j==0){
                        t[i][j]=true;
                    }
                }
            }

            for (int i=1;i<= arr.length;i++){
                for(int j=1;j<=eqSum;j++){
                    if(arr[i-1]<=j){
                        t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                    }else{
                        t[i][j]=t[i-1][j];
                    }
                }
            }
            if(t[arr.length][eqSum]==true){
                System.out.println("Equal sum partition is possible?: Yes");
            }else {
                System.out.println("Equal sum partition is possible?: No");
            }

        }else {
            System.out.println("Equal sum partition is possible?: No");
        }

        System.out.println("-----------Using Recursion---------------");
        EqualSumPartitionTF equalSumPartitionTF=new EqualSumPartitionTF();
        if(sum%2==0) {
            System.out.println("Equal sum partition is possible?: " + equalSumPartitionTF.subsetSum(arr, eqSum, arr.length));
        }else {
            System.out.println("Equal sum partition is possible?: No");
        }
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
        }else{
            return subsetSum(arr,sum,n-1);
        }
    }
}
