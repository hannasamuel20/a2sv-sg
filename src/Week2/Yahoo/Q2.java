package Week2.Yahoo;
import java.util.*;
public class Q2 {
    public int numOfPairs(String[] nums, String target) {
        Map<String,Integer> map = new HashMap<>();
        int res = 0;
        for(String num:nums){
            if(target.startsWith(num)){
                String str1 = target.substring(num.length());
                res+= map.getOrDefault(str1,0);
            }
            if(target.endsWith(num)){
                String str2 = target.substring(0,target.length()-num.length());
                res+= map.getOrDefault(str2,0);
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return res;

    }
}
