package ds.dp.dpwithstringLCS;

/**
 * Print Longest common Sub-String (with Continuous )
 * I/P --- Str1 = abcde , str2 = ababcde
 * O/P --- abcde
 *
 */
public class LongestCommonSubStringType2 {
    public static void main(String[] args) {
        String str1="abcde";
        String str2="ababcde";
        StringBuilder builder=new StringBuilder();
        int t[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length();i++){
            for(int j=0;j< str2.length();j++){
                if(i==0||j==0)
                    t[i][j]=0;
            }
        }
        int maxI=0;
        int maxJ=0;
        int max=0;
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else {
                    t[i][j]=0;
                }
                //Find the index of Max Value within the t[][] to get length of The Longest Common String
                if(t[i][j]>max){
                    max=t[i][j];
                    maxI=i;
                    maxJ=j;
                }
            }
        }

        while (maxI>0&&maxJ>0){
            if(str1.charAt(maxI-1)==str2.charAt(maxJ-1)) {
                builder.append(str1.charAt(maxI-1));
                maxI--;
                maxJ--;
            }
        }
        System.out.println("longest common String is :: "+builder.reverse());
    }
}
