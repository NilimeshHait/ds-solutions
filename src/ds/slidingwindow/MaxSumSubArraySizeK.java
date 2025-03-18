package ds.slidingwindow;

/**
 * Find the Maximum sum with in Sub array of Size K.
 * Input: Arr[] , sub array size (k).
 * Output :: Max Sum.
 *
 * Example:
 * arr[2,3,4,7,1,5,3,0,6], k=3
 * Output: 14 , Sub Arrays [2,3,4],[3,4,7],[4,7,1],[7,1,5],[1,5,3],[5,3,0],[3,0,6]
 * sub array with Max Sum is [3,4,7] = 14.
 */

public class MaxSumSubArraySizeK {
    public static void main(String[] args) {
        int[] arr={2,3,4,7,1,5,3,0,6};
        int windowSize=3;
        int i=0;
        int j=0;
        int maxSum=0;
        int sum=0;
        while(j<arr.length){
            sum=sum+arr[j];
            if(j-i+1<windowSize){
                j++;
            }
            else if(j-i+1==windowSize){
                maxSum=Math.max(maxSum,sum);
                sum=sum-arr[i];
                i++;
                j++;

            }
        }
        System.out.println("Max Sum :: "+maxSum);
    }
}
