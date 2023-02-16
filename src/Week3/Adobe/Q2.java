package Week3.Adobe;

public class Q2 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0; i<nums.length; i++){
            if(curr + nums[i] >= nums[i]){
                curr+=nums[i];
            }else{
                curr = nums[i];
            }
            res = Math.max(res,curr);
        }
        return res;
    }
}
