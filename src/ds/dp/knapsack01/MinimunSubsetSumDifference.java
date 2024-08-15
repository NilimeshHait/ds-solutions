package ds.dp.knapsack01;

import java.util.ArrayList;
import java.util.List;

/**
 * 0/1 Knapsack problem:: Variant 4 (Minimum Subset sum difference)
 * input : arr[1,6,11,5]
 * output : 1 ===> {1,6,5},{11} ==>12-11 ==> 1
 *
 */

public class MinimunSubsetSumDifference {

    public static void main(String[] args) {
        int[] arr={1,6,11,5}; //input any array value
        int range=0;
        for(int i=0;i<arr.length;i++){
            range=range+arr[i];
        }
        boolean[][] t=new boolean[arr.length+1][range+1];
        for (int i=0;i<=arr.length;i++){
            for(int j=0;j<=range;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=range;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }

        List<Integer> subsetValue=new ArrayList<>();

        for (int i=0;i<=range;i++){
            if(t[arr.length][i]==true){
                subsetValue.add(i);
            }
        }

        int min=range;
        for(int i=0;i<subsetValue.size()/2;i++){
            if(min>range-2*subsetValue.get(i)){
                min=range-2*subsetValue.get(i);
            }
        }
        System.out.println("Minimum subset sum diff :: "+min);
    }
}
