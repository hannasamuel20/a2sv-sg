package Week2.TikTok;
import java.util.*;
public class Q2 {
        public int maximumSwap(int num) {
            char[] n = String.valueOf(num).toCharArray();
            int[] max = new int[n.length];
            for(int i=n.length-1; i>=0; i--){
                max[i] = i;
                if(i+1<n.length && n[max[i+1]] >= n[max[i]])
                    max[i] = max[i+1];
            }
            for(int i=0; i<n.length; i++){
                if(n[i] < n[max[i]]){
                    char val1 = n[max[i]];
                    n[max[i]] = n[i];
                    n[i] = val1;
                    break;
                }
            }
            int res = 0;
            for(char digit:n) res=res*10 + (digit-'0');

            return res;

    }
}
