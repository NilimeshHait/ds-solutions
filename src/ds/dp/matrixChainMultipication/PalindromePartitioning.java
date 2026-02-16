package ds.dp.matrixChainMultipication;

import java.util.Arrays;

/**
 * Given a string s, the task is to find the minimum number of cuts needed
 * for palindrome partitioning of the given string. A partitioning of the
 * string is a palindrome partitioning if every sub-string of the partition
 * is a palindrome.
 * Input: s= "aaaa"
 * Output: 0
 * Explanation: The string is already a palindrome.
 *
 * Input: s = "ababbbabbababa"
 * Output: 3
 * Explanation: We need to make minimum 3 cuts, i.e., "aba | bb | babbab | aba".
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning pp=new PalindromePartitioning();
        String s="ababbbabbababa";
        int [][] t=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length()+1;i++)
            Arrays.fill(t[i],-1);
        int result=pp.solve(s,0,s.length()-1);
        System.out.println(result);

        int result_td=pp.solve_TD(s,0,s.length()-1,t);
        System.out.println(result_td);
    }

    int solve(String s,int i,int j){
        int min=Integer.MAX_VALUE;
        if(i>=j)
            return 0;
        if(isPalindrome(s,i,j))
            return 0;
        for(int k=i;k<j;k++){
            int temp=1+solve(s,i,k)+solve(s,k+1,j);
            if(min>temp){
                min=temp;
            }
        }
        return min;
    }
    int solve_TD(String s,int i,int j,int[][] t){
        int min=Integer.MAX_VALUE;
        if(i>=j)
            return 0;
        if(isPalindrome(s,i,j))
            return 0;
        if(t[i][j]!=-1)
            return t[i][j];
        for(int k=i;k<j;k++){
            int temp=1+solve(s,i,k)+solve(s,k+1,j);
            if(min>temp){
                min=temp;
            }
        }
        t[i][j]=min;
        return min;
    }

    boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;

        }
        return true;
    }
}
