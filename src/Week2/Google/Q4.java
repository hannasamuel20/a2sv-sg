package Week2.Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q4 {
    class Solution {
        public int racecar(int target) {
            Queue<int[]> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(new int[]{0,1});
            int res = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0; i<size; i++){
                    int[] curr = queue.poll();
                    if(curr[0] == target) return res;
                    int newPos = curr[0]+curr[1];
                    int newSpeed = curr[1]*2;
                    String p1 = newPos+","+newSpeed;
                    if(!visited.contains(p1) && newPos>0 && (curr[0]<=target*2 || newSpeed<0) ){
                        queue.offer(new int[]{curr[0]+curr[1],curr[1]*2});
                        visited.add(p1);
                    }
                    int newPos2 = curr[0];
                    int newSpeed2 = (curr[1]>0?-1:1);
                    String p2 = newPos2+","+newSpeed2;
                    if(!visited.contains(p2)&& newPos2>0 ){
                        queue.offer(new int[]{curr[0],(curr[1]>0?-1:1)});
                        visited.add(p2);
                    }

                }
                res++;
            }

            return res;

        }
    }
}
