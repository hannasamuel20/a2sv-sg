package Week2.Google;

import java.util.Arrays;

public class Q2 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(String word1, String word2)->word1.length() - word2.length());
        int[] dp = new int[words.length];
        int max = 0;
        for(int i=1; i<words.length; i++){
            for(int j=0; j<i; j++){
                if(words[i].length()-1 == words[j].length() && dp[j]+1 > dp[i] && isPredecessor(words[j],words[i])){
                    dp[i] = dp[j]+1;
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max+1;
    }

    public boolean isPredecessor(String word1, String word2){
        boolean check = false;
        int i = 0;
        int j = 0;
        while(j < word2.length() && i<word1.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;j++;
            }else if(check){
                return false;
            }else{
                check = true;
                j++;
            }
        }
        return i == word1.length();
    }
}
