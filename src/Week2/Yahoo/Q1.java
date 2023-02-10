package Week2.Yahoo;

public class Q1 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[left]*nums[left] > nums[right]*nums[right]){
                res[i] = nums[left]*nums[left++];
            }else{
                res[i] = nums[right]*nums[right--];
            }
        }
        return res;

    }
}
