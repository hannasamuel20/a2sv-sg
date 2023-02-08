package Week2.Uber;

import java.util.*;
public class Q2 {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] res  = new int[adjacentPairs.length+ 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair:adjacentPairs){
            if(!map.containsKey(pair[0]))
                map.put(pair[0],new ArrayList<>());
            if(!map.containsKey(pair[1]))
                map.put(pair[1],new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int start = 0;
        for(int key:map.keySet()){
            if(map.get(key).size() == 1){
                start = key;break;
            }
        }
        for(int i=0; i<res.length; i++){
            res[i] = start;
            if(map.get(start).size() == 1 || res[i-1] != map.get(start).get(0)){
                start = map.get(start).get(0);
            }else{
                start = map.get(start).get(1);
            }
        }
        return res;


    }
}
