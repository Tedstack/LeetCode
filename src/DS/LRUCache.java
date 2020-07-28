package DS;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int tick_Num = 1;

    class Node{
        public int key;
        public int val;
        public int tick;
        public Node pre;
        public Node next;
        //check whether this node is more recent than #node
        public boolean isRecent(Node node){
            return this.tick>node.tick;
        }

        public Node(int key, int val){
            this.key = key;
            this.val=val;
            this.tick=tick_Num++;
            pre=null;
            next=null;
        }
    }

    //order by the tick
    class DoubleLinkedList{
        public Node head;
        public Node tail;
        public int length;

        public DoubleLinkedList(){
            head=null;
            tail=null;
            length=0;
        }

        public void insert(Node node){
            if(head==null){
                head=node;
                tail=head;
                length++;
            } else {
                node.next=head;
                head.pre = node;
                head=node;
                length++;
            }
        }

        public void remove(Node node){
            if(node == head){
                head=head.next;
            } else if(node ==tail){
                tail=tail.pre;
            } else {
                node.pre.next=node.next;
                node.next.pre=node.pre;
            }
            length--;
            if(head == null || tail == null){
                head=null;
                tail=null;
            }
        }
    }

    Map<Integer, Node> map;
    int capacity;
    DoubleLinkedList list;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();
        list = new DoubleLinkedList();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            touch(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            touch(node);
        } else {
            Node node = new Node(key, value);
            map.put(key,node);
            list.insert(node);
            if(list.length>capacity) {
                map.remove(list.tail.key);
                list.remove(list.tail);
            }
        }
    }

    public void touch(Node node){
        list.remove(node);
        node.tick=++tick_Num;
        list.insert(node);
    }
}
