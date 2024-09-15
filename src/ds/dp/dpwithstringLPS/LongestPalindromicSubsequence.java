package ds.dp.dpwithstringLPS;

/**
 * Longest Palindromic Subsequence
 * I/P - str=ambcba;
 * O/P - 5 - > Possible Palindromes are - abcba,bcb,aba,aca,ama,a,b,m,c
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str="ambcba";
        LongestPalindromicSubsequence longestPalindromicSubsequence=new LongestPalindromicSubsequence();
        String revStr=new StringBuilder(str).reverse().toString();
        int longestCount=longestPalindromicSubsequence.lcs(str,revStr,str.length(),revStr.length());
        System.out.println("Length of Longest Palindromic Subsequence : "+longestCount);

    }
    //Using Recursion LCS
    public int lcs(String str1,String str2,int m,int n){
        if(m==0 || n==0){
            return 0;
        }else {
            if(str1.charAt(m-1)==str2.charAt(n-1)){
                return 1+lcs(str1,str2,m-1,n-1);
            }else {
                return Math.max(lcs(str1,str2,m-1,n),lcs(str1,str2,m,n-1));
            }
        }
    }


    //top-down approch -LCS
    int lcs(String str1,String str2){
        int[][] t=new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<str1.length()+1;i++){
            for (int j=0;j<str2.length()+1;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else {
                    if(t[i-1][j]>t[i][j-1]){
                        t[i][j]=t[i-1][j];
                    }else {
                        t[i][j]=t[i][j-1];
                    }
                }
            }
        }
        return t[str1.length()][str2.length()];
    }
}
