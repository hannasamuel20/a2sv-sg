package Week3.Apple;
import java.util.*;

public class Q4 {
    Set<List<Integer>> set;
    List<Integer> list;
    public int numSquarefulPerms(int[] nums) {
        Map<List,Integer> memo = new HashMap<>();
        list = new ArrayList<>();
        set = new HashSet<>();
        return helper(nums,-1,0,new boolean[nums.length],memo);
    }

    public int helper(int[] nums, int idx, int picked,boolean[] visited, Map<List,Integer> memo){
        if(picked == nums.length){
            if(set.contains(new ArrayList<>(list)))
                return 0;
            set.add(new ArrayList<>(list));
            return 1;
        }
        int res = 0;
        if (memo.containsKey(list)) return 0;
        for(int i=0; i<nums.length; i++){
            if(!visited[i] &&  (idx==-1 ||
                    Math.sqrt(nums[idx]+nums[i]) == Math.floor(Math.sqrt(nums[idx]+nums[i])))){
                if(idx==-1 || nums[idx]!=nums[i] || idx<i){
                    list.add(nums[i]);
                    visited[i] = true;
                    res += helper(nums,i,picked+1,visited,memo);
                    visited[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }

        memo.put(list,res);
        return  res;

    }
}
