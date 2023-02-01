package Week1;

import java.util.Arrays;

public class Q3 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] players = new int[scores.length][2];
        for(int i=0; i<scores.length; i++){
            players[i][0] = scores[i];
            players[i][1] = ages[i];
        }

        Arrays.sort(players,(int[] a, int[] b)->{
            if(a[1] == b[1])return a[0]-b[0];
            return a[1] - b[1];
        });

        int[] dp = new int[scores.length];
        int res = players[0][0];
        dp[0] =  players[0][0];
        for(int i = 1; i<players.length; i++){
            dp[i] = players[i][0];
            for(int j=0; j<i; j++){
                if(players[i][1] == players[j][1] || players[i][0]>=players[j][0]){
                    dp[i] = Math.max(dp[i],players[i][0]+dp[j]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;




    }
}
