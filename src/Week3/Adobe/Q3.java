package Week3.Adobe;
import java.util.*;
public class Q3 {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        if(changed.length%2 != 0) return new int[]{};
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:changed)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int[] result = new int[changed.length/2];
        int idx = 0;
        for(int i=0; i<changed.length&&idx<result.length; i++){
            if(map.get(changed[i])==0) continue;
            map.put(changed[i],map.get(changed[i])-1);
            if(map.containsKey(changed[i]*2) && map.get(changed[i]*2)>0){
                result[idx++] =  changed[i];
                map.put(changed[i]*2,map.get(changed[i]*2)-1);
            }
        }
        return idx == result.length?result:new int[]{};



    }
}
