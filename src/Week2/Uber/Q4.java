package Week2.Uber;

import java.util.*;

public class Q4 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Set<Integer> destinations = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            int[] route = routes[i];
            for(int stop:route){
                if(stop == target) destinations.add(i);
                if(!map.containsKey(stop)) map.put(stop,new ArrayList<>());
                map.get(stop).add(i);
            }
        }
        for(List<Integer> list: map.values()){
            for(int i=0; i<list.size(); i++){
                if(!adjList.containsKey(list.get(i))){
                    adjList.put(list.get(i),new ArrayList<>());
                }
                if(i+1<list.size()){
                    if(!adjList.containsKey(list.get(i+1))){
                        adjList.put(list.get(i+1),new ArrayList<>());
                    }
                    adjList.get(list.get(i)).add(list.get(i+1));
                    adjList.get(list.get(i+1)).add(list.get(i));
                }
                if(i-1 > 0 ){
                    if(!adjList.containsKey(list.get(i-1))){
                        adjList.put(list.get(i-1),new ArrayList<>());
                    }
                    adjList.get(list.get(i)).add(list.get(i-1));
                    adjList.get(list.get(i-1)).add(list.get(i));
                }
            }
        }
        boolean[] visited = new boolean[routes.length];
        if(!map.containsKey(source)) return -1;
        Queue<Integer> queue = new LinkedList<>();
        for(int stop : map.get(source)) {
            queue.offer(stop);
            visited[stop] = true;
        }
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int curr = queue.poll();
                if(destinations.contains(curr)) return res+1;
                for(int n:adjList.getOrDefault(curr,new ArrayList<>())){
                    if(!visited[n]){
                        visited[n] = true;
                        queue.offer(n);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
