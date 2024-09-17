package ds.dp.dpwithstringLCS;

/**
 * Print Shortest common Super Sequence
 * I/P --- Str1 = nilimesh , str2 = hait
 * O/P --- nilimeshait (Both Str1 and Str2 are present)
 *
 */
public class ShortestCommonSuperSequenceType2 {
    public static void main(String[] args) {
        String str1="nilimesh";
        String str2="hait";
        ShortestCommonSuperSequenceType2 shortestCommonSuperSequenceType2=new ShortestCommonSuperSequenceType2();

        System.out.println(shortestCommonSuperSequenceType2.getSCSS(str1,str2));

    }

    public String getSCSS(String str1,String str2){
        int[][] t=new int[str1.length()+1][str2.length()+1];
        for (int i=0;i<=str1.length();i++){
            for (int j=0;j<=str2.length();j++){
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
                   /* if(t[i-1][j]>t[i][j]){
                        t[i][j]=t[i-1][j];
                    }else {
                        t[i][j]=t[i][j-1];
                    }*/
                }
            }
        }
        StringBuffer sb=new StringBuffer();
        int m=str1.length();
        int n=str2.length();
        while(m>0 && n>0){
            if(str1.charAt(m-1)==str2.charAt(n-1)){
                sb.append(str1.charAt(m-1));
                m--;
                n--;
            }else{
                if(t[m-1][n]>t[m][n-1]){
                    sb.append(str1.charAt(m-1));
                    m--;
                }else {
                    sb.append(str2.charAt(n-1));
                    n--;
                }
            }
        }
        while (m>0){
            sb.append(str1.charAt(m-1));
            m--;
        }
        while(n>0){
            sb.append(str2.charAt(n-1));
            n--;
        }
        String rev=sb.reverse().toString();
        return rev;
    }

}
