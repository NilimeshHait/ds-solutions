package ds.dp.dpwithstringLCS;
/**
 * Print LCS-Longest common Subsequence (without Continuous )
 * I/P --- Str1 = absdygjgk , str2 = abrhjuigklolllll
 * O/P --- abjgk
 *
 */
public class LongestCommonSubsequenceType2 {
    public static void main(String[] args) {
        String str1="absdygjgk";
        String str2="abrhjuigklolllll";
        int[][] t=new int[str1.length()+1][str2.length()+1];
        for (int i=0;i<=str1.length();i++){
            for (int j=0;j<=str2.length();j++){
                if(i==0||j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                }
                else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        StringBuffer matchString=new StringBuffer();
        int lenStr1=str1.length();
        int lenStr2=str2.length();
        while (lenStr1>0 && lenStr2>0){
            if(str1.charAt(lenStr1-1)==str2.charAt(lenStr2-1)){
                matchString.append(str1.charAt(lenStr1-1));
                lenStr1--;
                lenStr2--;
            }else{
                if(t[lenStr1-1][lenStr2]>t[lenStr1][lenStr2-1]){
                    lenStr1--;
                }else {
                    lenStr2--;
                }
            }
        }
        System.out.println("LC-Subsequence :: "+matchString.reverse());
    }
}
