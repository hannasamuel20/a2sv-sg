package Week2.TikTok;
import java.util.*;
public class Q4 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums,k) - count(nums,k-1);
    }

    public int count(int[] nums, int k){
        int res = 0;
        Map<Integer,Integer> set = new HashMap<>();
        int start = 0;
        for(int end = 0; end<nums.length; end++){
            set.put(nums[end],set.getOrDefault(nums[end],0)+1);
            while(set.size() > k){
                set.put(nums[start],set.get(nums[start])-1);
                if(set.get(nums[start]) == 0){
                    set.remove(nums[start]);
                }
                start++;
            }
            res+=end-start+1;
        }
        return res;

    }
}
