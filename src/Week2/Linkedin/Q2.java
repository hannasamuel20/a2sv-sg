package Week2.Linkedin;

import java.util.PriorityQueue;

public class Q2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:nums){
            if(minHeap.size() == k){
                if(minHeap.peek()< num){
                    minHeap.remove();
                    minHeap.add(num);
                }
            }else{
                minHeap.add(num);

            }
        }
        return minHeap.peek();

    }
}
