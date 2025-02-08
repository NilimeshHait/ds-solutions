package ds.dp.dpwithstringLPS;

/**
    * Min number of Deletion required to make a string Palindrome
    * I/P - str=agbcba;
    * O/P - 1 - > longest Palindromes is "abcba" length(palindrome) = 5, (length(str)-Max length(palindrome)
 */


public class MinNoOfDeletionToMakePalindrome {

    public static void main(String[] args) {
        String a="agbcba";
        String b=new StringBuilder(a).reverse().toString();
        MinNoOfDeletionToMakePalindrome m=new MinNoOfDeletionToMakePalindrome();
        System.out.println("No of deletion required :: "+ m.getNumberOfDeletion(a,b));

    }

    int getNumberOfDeletion(String str1,String str2){
        int t[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            for (int j=0;j<=str2.length();j++){
                if(i==0||j==0){
                    t[i][j]=0;
                }
            }
        }
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<= str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return str1.length()-t[str1.length()][str2.length()];
    }
}

