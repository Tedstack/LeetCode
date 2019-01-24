package DepthFirstSearch;

import java.util.*;

public class Itinerary {
    public List<String> findItinerary(String[][] tickets) {
        if(tickets.length==0)
            return new ArrayList<String>();
        Map<String, LinkedList<String>> graph = new HashMap<>();
        for (String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];
            if (!graph.containsKey(from))
                graph.put(from,new LinkedList<>());
            graph.get(from).add(to);
        }
        sort(graph);
        LinkedList<String> path=new LinkedList<>();
        getResult("JFK",path,graph);
        return path;
    }
    void sort(Map<String, LinkedList<String>> graph){
        for (String key: graph.keySet()){
            Collections.sort(graph.get(key));
        }
    }
    public void getResult(String node, LinkedList<String> path, Map<String, LinkedList<String>> graph){
        if(graph.containsKey(node)){
            while(graph.get(node).size()!=0){
                String temp=graph.get(node).poll();
                getResult(temp,path,graph);
            }
        }
        path.addFirst(node);
    }
}
