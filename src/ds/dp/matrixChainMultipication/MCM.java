package ds.dp.matrixChainMultipication;
/*
Given an array arr[] which represents the dimensions of a sequence of matrices
where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the
most efficient way to multiply these matrices together. The efficient way is
the one that involves the least number of multiplications.

Example:

Input: arr[] = [1, 2, 3, 4, 3]
Output: 30
Explanation: There are 4 matrices of dimensions 1 × 2, 2 × 3, 3 × 4, 4 × 3.
Let this 4 input matrices be M1, M2, M3 and M4. The minimum number of
multiplications are obtained by ((M1 x M2) x M3) x M4). The minimum number
is (1 x 2 x 3) + (1 x 3 x 4) + (1 x 4 x 3) = 30.

 */

import java.util.Arrays;

public class MCM {

    public static void main(String[] args) {
        int arr[]={1, 2, 3, 4, 3};
        //recursive
        int result=solve(arr,1,arr.length-1);
        System.out.println("Minimum value(recursive) :: "+result);
        //DP - Bottom-Up Approach
        int [][] t=new int[arr.length+1][arr.length+1];
        for(int i=0;i<arr.length+1;i++)
            Arrays.fill(t[i],-1);
        int resultDP=solve_DP(arr,1,arr.length-1,t);
        System.out.println("Minimum value(DP) :: "+resultDP);

    }

    static int solve(int arr[],int i,int j){
        if(i>=j)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solve(arr,i,k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(temp<min){
                min=temp;
            }
        }
        return min;
    }
    //---------------------------------------------------
    static int solve_DP(int arr[],int i,int j,int [][] t){
        if(i>=j)
            return 0;
        if(t[i][j]!=-1)
            return t[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solve_DP(arr,i,k,t)+solve_DP(arr,k+1,j,t)+arr[i-1]*arr[k]*arr[j];
            if(temp<min){
                min=temp;
            }
        }
        t[i][j]=min;
        return min;
    }
}
