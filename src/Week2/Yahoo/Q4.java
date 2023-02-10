package Week2.Yahoo;

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double prev = 0;
        double curr = 0;
        int idx1 = 0;
        int idx2 = 0;
        int nums = (nums1.length+nums2.length)/2;
        while(nums>=0){
            if(idx1 == nums1.length){
                prev = curr;
                curr = nums2[idx2];
                idx2++;
            }else if(idx2 == nums2.length){
                prev = curr;
                curr = nums1[idx1];
                idx1++;
            }else if(nums1[idx1] < nums2[idx2] ){
                prev = curr;
                curr = nums1[idx1];
                idx1++;
            }else{
                prev = curr;
                curr = nums2[idx2];
                idx2++;
            }
            nums--;
        }
        return (nums1.length+nums2.length)%2==0?(prev+curr)/2:curr;


    }
}
