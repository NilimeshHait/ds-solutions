package ds.dp.dpwithstringLCS;

/**
 * Minimum Number of Insertion and Deletion to convert String a to String b;
 * I/P - a=nimmo, b=nim
 * O/P - Insertion - 0, Deletion - 2
 *
 */
public class MinimumNoOfInsertionDeletion {
    public static void main(String[] args) {
        MinimumNoOfInsertionDeletion minimumNoOfInsertionDeletion=new MinimumNoOfInsertionDeletion();
        String str1="nimmo";
        String str2="nim";
        int lcs=minimumNoOfInsertionDeletion.lcs(str1,str2);
        System.out.println("Minimum # of Insertion :: "+(str2.length()-lcs));
        System.out.println("Minimum # of Deletion :: "+(str1.length()-lcs));
    }

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
