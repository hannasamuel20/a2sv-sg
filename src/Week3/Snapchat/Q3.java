package Week3.Snapchat;

import java.util.*;

public class Q3 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            res+=map.getOrDefault(sum%k,0);
            res+=map.getOrDefault((sum%k)-k,0);
            res+=map.getOrDefault((k+sum%k),0);
            map.put(sum%k,map.getOrDefault(sum%k,0)+1);

        }
        return res;

    }
}
