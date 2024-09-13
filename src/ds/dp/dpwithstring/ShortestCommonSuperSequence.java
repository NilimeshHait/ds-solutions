package ds.dp.dpwithstring;
/**
 * Print Length of The Shortest common Super Sequence
 * I/P --- Str1 = nilimesh , str2 = hait
 * O/P --- 11 (nilimeshait) Both Str1 and Str2 are present
 *
 */
public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String str1="nilimesh";
        String str2="hait";
        ShortestCommonSuperSequence shortestCommonSuperSequence=new ShortestCommonSuperSequence();
        System.out.println("Minimum number of Char to match both String :: "+shortestCommonSuperSequence.lcs(str1,str2));
    }

    int lcs(String str1,String str2){
        int t[][]=new int[str1.length()+1][str2.length()+1];
        for (int i=0;i<str1.length()+1;i++){
            for (int j=0;j<str2.length()+1;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<= str2.length();j++){
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
        return (str1.length()+str2.length())-t[str1.length()][str2.length()];
    }
}
