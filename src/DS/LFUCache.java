package DS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {

    class Node{
        public int key;
        public int value;
        public int freq;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
            this.freq =1;
        }
    }

    int capacity;
    private HashMap<Integer, Node> cache;
    private TreeMap<Integer, LinkedList<Integer>> freqMap; //freqence-to-key list

    public LFUCache(int capacity) {
       this.capacity = capacity;
       cache = new HashMap<>();
       freqMap = new TreeMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            int freq = cache.get(key).freq;
            LinkedList<Integer> list = freqMap.get(freq);
            list.remove((Integer) key);
            if(list.isEmpty())
                freqMap.remove((Integer) freq);
            setFrequence(freq+1,key);
            cache.get(key).freq = cache.get(key).freq +1;
            return cache.get(key).value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            LinkedList<Integer> list = freqMap.get(node.freq);
            list.remove((Integer) key);
            if(list.isEmpty())
                freqMap.remove((Integer) node.freq);
            setFrequence(node.freq+1,key);
            node.freq = node.freq+1;
            node.value=value;
            cache.put(key,node);
        } else {
            Node node = new Node(key, value);
            if(cache.size()<capacity){
                cache.put(key,node);
                setFrequence(1,key);
            } else {
                Map.Entry<Integer, LinkedList<Integer>> minEntry = freqMap.firstEntry();
                int firstKey=minEntry.getValue().removeFirst();
                if(minEntry.getValue().isEmpty())
                    freqMap.remove(minEntry.getKey());
                cache.remove(firstKey);
                cache.put(key,node);
                setFrequence(1,key);
            }
        }
    }

    private void setFrequence(int frequence, int key){
        if (!freqMap.containsKey(frequence)) {
            freqMap.put(frequence, new LinkedList<>());
        }
        freqMap.get(frequence).addLast((Integer) key);
    }
}
