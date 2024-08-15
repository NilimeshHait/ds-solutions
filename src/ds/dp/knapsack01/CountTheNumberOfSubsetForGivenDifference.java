package ds.dp.knapsack01;


/**
 * 0/1 Knapsack problem:: Variant 5 (Count The Number Of Subset For a Given Difference)
 * input : arr[1,2,1,3] , diff =1
 * output : 3 ===> [{1,2},{1,3}], [{1,2,1},{3}],[{3,1}{2,1}]
 *
 */

public class CountTheNumberOfSubsetForGivenDifference {

    public static void main(String[] args) {
        CountTheNumberOfSubsetForGivenDifference  ctnosfgd=new CountTheNumberOfSubsetForGivenDifference();
        int[] arr = {1,2,1,3};
        int diff=1;
        int sumOfArr=0;
        for (int i=0;i<arr.length;i++){
            sumOfArr+=arr[i];
        }
        int subsetSum_1=(diff+sumOfArr)/2;
        int noOfSubset=ctnosfgd.countSubset(arr,subsetSum_1);
        System.out.println("No of Subset :: "+noOfSubset);

    }

    int countSubset(int[] arr,int sum){
        int [][] t=new int[arr.length+1][sum+1];
        for(int i=0;i<= arr.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }
        for (int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}
