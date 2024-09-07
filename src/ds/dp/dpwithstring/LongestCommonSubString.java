package ds.dp.dpwithstring;

/**
 * Longest common Sub-String (with Continuous )
 * I/P --- Str1 = abcde , str2 = ababcde
 * O/P --- 5 (matching letters are abcde)
 *
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        String str1="abcde";
        String str2="ababcde";
        int[][] t=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
            for (int j=0;j<str2.length()+1;j++){
                if(i==0 || j==0)
                    t[i][j] = 0;
            }
        }
        int max=0;
        for(int i=1;i<str1.length()+1;i++){
            for (int j=1;j<str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else {
                    t[i][j]=0;
                }
                //Find the Max Value within the t[][] to get length of The Longest Common String
                if(t[i][j]>max){
                    max=t[i][j];
                }
            }
        }
        System.out.println("Length of longest common String is :: "+max);
    }
}
