package BreadthFirstSearch;

import java.util.*;

public class MinimumHeightTree {
    // traverse the node with degree 1. And update the degree.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n==1){
            result.add(0);
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            if(map.containsKey(edge[0]))
                map.get(edge[0]).add(edge[1]);
            else
                map.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
            if(map.containsKey(edge[1]))
                map.get(edge[1]).add(edge[0]);
            else
                map.put(edge[1], new ArrayList<>(Arrays.asList(edge[0])));
        }
        int[] degree = new int[n];
        for(int i=0;i<n;i++){
            degree[i]=map.get(i).size();
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            result=new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                int cur = queue.poll();
                result.add(cur);
                for(int adjacent: map.get(cur)) {
                    degree[adjacent]--;
                    if(degree[adjacent]==1)
                        queue.add(adjacent);
                }
            }
        }
        return result;
    }
}
