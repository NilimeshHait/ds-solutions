package ds.dp.dpwithstringLCS;

/**
 * LCS-Longest Repeating Subsequence
 * I/P --- Str1 = aabebcdd , str2 = aabebcdd
 * O/P --- 3 (matching string  abd- 2 times)
 * Note: String that is repeating maximum number : aabebcdd -1 , abd -2 ...
 */

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str1="aabebcdd";//aacbfbdd
        String str2=str1;
        int[][] t=new int[str1.length()+1][str2.length()+1];
        for (int i=0;i<str1.length()+1;i++){
            for (int j=0;j<str2.length()+1;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }
        for (int i=1;i<str1.length()+1;i++){
            for (int j=1;j<str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1) && (i!=j)){
                    t[i][j]=1+t[i-1][j-1];
                }else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        System.out.println(" Longest length "+t[str1.length()][str2.length()]);
    }
}
