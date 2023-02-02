package Week1.Amazon;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public int minimumOperations(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int num:nums){
            if(num>0)
                unique.add(num);
        }
        return unique.size();

    }
}
