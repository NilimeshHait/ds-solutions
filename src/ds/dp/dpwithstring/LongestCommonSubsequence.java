package ds.dp.dpwithstring;

/**
 * LCS-Longest common Subsequence (without Continuous )
 * I/P --- Str1 = absdygjgk , str2 = abrhjuigklolllll
 * O/P --- 5 (matching letters are abjgk)
 *
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1="absdygjgk";
        String str2="abrhjuigklolllll";
        LongestCommonSubsequence lcs=new LongestCommonSubsequence();
        int count = lcs.Lcs(str1,str2,str1.length(),str2.length());
        System.out.println("--------USING RECURSION--------");
        System.out.println("Longest Common Subsequence : "+count);
        System.out.println("--------USING TOP-DOWN Approach--------");
        System.out.println("Longest Common Subsequence : "+lcs.LcsTopDownApproch(str1,str2,str1.length(),str2.length()));

    }

    public int Lcs(String str1,String str2,int m,int n){
        if(m==0 || n==0)
            return 0;
        if(str1.charAt(m-1)==str2.charAt(n-1))
            return 1+Lcs(str1,str2,m-1,n-1);
        else
            return Math.max(Lcs(str1,str2,m-1,n),Lcs(str1, str2, m,n-1));
    }

    public int LcsTopDownApproch(String str1,String str2,int m,int n){
        int[][] t=new int[m+1][n+1];
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str2.length();j++){
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
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }

            }
        }
        return t[m][n];
    }
}
