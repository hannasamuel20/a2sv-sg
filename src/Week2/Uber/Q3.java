package Week2.Uber;

import java.util.*;

public class Q3 {
    Map<String, Map<String,Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        graph = new HashMap<>();
        for(int i=0; i<values.length; i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if(!graph.containsKey(a)){
                graph.put(a,new HashMap<>());
            }
            if(!graph.containsKey(b)){
                graph.put(b,new HashMap<>());
            }
            graph.get(a).put(b,values[i]);
            graph.get(b).put(a,1/values[i]);
        }
        for(int i=0; i<queries.size(); i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if(graph.containsKey(a) && graph.containsKey(b))
                res[i] = helper(a,b,1,new HashSet<>());
            else res[i] = -1;
        }
        return res;


    }

    public double  helper(String start, String end, double res, Set<String> visited){
        if(start.equals(end)) return res;
        if(visited.contains(start)) return -1;
        visited.add(start);
        Map<String,Double> map = graph.get(start);
        double max = -1;
        for(String key: map.keySet()){
            max = Math.max(max,helper(key,end,res*map.get(key),visited));
        }
        return max;
    }
}
