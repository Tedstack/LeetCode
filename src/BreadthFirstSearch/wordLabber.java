package BreadthFirstSearch;

import java.util.*;

public class wordLabber {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String,Boolean> visit = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count=0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i=0; i< size;i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return count;
                List<String> childList = getChild(word, wordList);
                for (String child : childList) {
                    if (!visit.containsKey(child)) {
                        queue.add(child);
                        visit.put(child, true);
                    }
                }
            }
        }
        return 0;
    }

    private Map<String, Set<String>> graph;
    private List<List<String>> result = new ArrayList<>();
    private Map<String, Integer> distance = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return result;
        wordList.remove(beginWord);
        graph = buildMap(beginWord,endWord,wordList);
        dfs(beginWord, endWord, new ArrayList<>());
        return result;
    }

    public void dfs(String word, String target, List<String> solution){
        solution.add(word);
        if(target.equals(word))
            result.add(new ArrayList<>(solution));
        else{
            if(graph.containsKey(word)) {
                for (String child : graph.get(word)) {
                    if (distance.get(word) + 1 == distance.getOrDefault(child, Integer.MAX_VALUE))
                        dfs(child, target, new ArrayList<>(solution));
                }
            }
        }
    }

    public Map<String, Set<String>> buildMap(String beginWord, String endWord, List<String> wordList){
        boolean found=false;
        Map<String, Set<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);
        while(!queue.isEmpty() && !found){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word = queue.poll();
                Set<String> set = map.getOrDefault(word, new HashSet<>());
                map.put(word, set);
                List<String> childList = getChild(word, wordList);
                for(String child: childList){
                    if(child.equals(endWord))
                        found = true;
                    if(!distance.containsKey(child)){
                        queue.add(child);
                        distance.put(child, distance.get(word)+1);
                    }
                    set.add(child);
                }
            }
        }
        return map;
    }

    public List<String> getChild(String word, List<String> wordList){
        List<String> result = new ArrayList<>();
        for(String target : wordList){
            int diff=0;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)!=target.charAt(i))
                    diff++;
            }
            if(diff==1)
                result.add(target);
        }
        return result;
    }
//    private Map<String, Set<String>> graph;
//    private List<List<String>> result;
//    private Map<String, Integer> distance;
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        distance = new HashMap<>();
//        graph = buildGraph(beginWord, wordList);
//        result = new ArrayList<>();
//        dfs(beginWord, endWord,  new ArrayList<>());
//        return result;
//    }
//
//    private void dfs(String word, String target, List<String> solution) {
//        solution.add(word);
//        if (target.equals(word)) {
//            result.add(solution);
//        } else {
//            for (String child : graph.get(word)) {
//                if (distance.get(word) + 1 == distance.getOrDefault(child, Integer.MAX_VALUE)) {
//                    dfs(child, target, new ArrayList<>(solution));
//                }
//            }
//        }
//    }
//
//    private Map<String, Set<String>> buildGraph(String beginWord, List<String> wordList) {
//        Map<String, Set<String>> map = new HashMap<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        distance.put(beginWord, 0);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String word = queue.poll();
//                Set<String> set = map.getOrDefault(word, new HashSet<>());
//                map.put(word, set);
//                for (String s : wordList) {
//                    int cnt = 0;
//                    for (int j = 0; j < word.length(); j++) {
//                        if (s.charAt(j) != word.charAt(j)) {
//                            cnt++;
//                        }
//                    }
//                    if (cnt == 1) {
//                        if (!distance.containsKey(s)) {
//                            queue.add(s);
//                            distance.put(s, distance.get(word) + 1);
//                        }
//                        set.add(s);
//                    }
//                }
//            }
//        }
//        return map;
//    }
}
