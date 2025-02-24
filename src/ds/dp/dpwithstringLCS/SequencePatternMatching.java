package ds.dp.dpwithstringLCS;

/**
    * Sequence Pattern Matching
    * I/P --- Str1 = axy , str2 = abxcpy
    * O/P --- true/false (matching string  axy)
    * Note: checking String str1 is present or not in Str2 ...
    */

public class SequencePatternMatching {
    public static void main(String[] args) {
        String str1="axy";
        String str2="abxcpy";

        int [][] t=new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<=str1.length();i++){
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
                }
            }
        }
        if(t[str1.length()][str2.length()]==str1.length()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
