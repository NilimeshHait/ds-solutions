package ds.dp.miscellaneous;

import java.util.Arrays;

/**
 * No. Of minimum jump to reach the Top
 * input : arr [1,3,5,8,9,2,6,7,6,8,9]
 * Output: 3 --- 1->3->9->9
 */
public class NoOfMinimumJump {
    public static void main(String[] args) {
        int[] arr={1,3,5,8,9,2,6,7,6,8,9};
        int[] jump=new int[arr.length];
        if(arr[0]==0 || arr.length==0){
            System.out.println(Integer.MAX_VALUE);
        }
        jump[0]=0;
        for(int i=1;i<arr.length;i++){
            jump[i]=Integer.MAX_VALUE;
            for (int j=0;j<i;j++){
                if(i<=j+arr[j] && jump[j]!=Integer.MAX_VALUE){
                    jump[i]=Math.min(jump[i],jump[j]+1 );
                    break;
                }
            }

        }
        Arrays.stream(jump).forEach(a-> System.out.print(a+" "));
        System.out.println("\nMinimin jump:: "+jump[arr.length-1]);
    }
}
