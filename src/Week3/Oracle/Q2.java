package Week3.Oracle;
import java.util.*;
public class Q2{

}
class LRUCache {

    int time = 0;
    int capacity;
    Queue<int[]> queue = new LinkedList<>();
    Map<Integer,Integer> keyValue = new HashMap<>();
    Map<Integer,Integer> keyTime = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        queue.offer(new int[]{key,++time});
        if(keyTime.containsKey(key)){
            keyTime.put(key,time);
            return keyValue.get(key);
        }
        return -1;

    }

    public void put(int key, int value) {
        if(!keyTime.containsKey(key)){
            while(keyTime.size() >= capacity){
                int[] curr = queue.poll();
                if(keyTime.containsKey(curr[0]) && keyTime.get(curr[0]) == curr[1]){
                    keyTime.remove(curr[0]);
                }
            }
        }

        keyTime.put(key,++time);
        keyValue.put(key,value);
        queue.offer(new int[]{key,time});

    }
}
