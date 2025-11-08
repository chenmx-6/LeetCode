package Solution;

import java.util.HashMap;
import java.util.Map;

public class Solution0146 {
    static class LRUCache {
        class DLinkedNode{
            public int key;
            public int value;
            public DLinkedNode pre;
            public DLinkedNode next;

            public DLinkedNode(int key,int value){
                this.key=key;
                this.value=value;
            }

            public DLinkedNode(){

            }
        }

        public Map<Integer,DLinkedNode> cache=new HashMap<>();
        public int size,capacity;
        public DLinkedNode head,tail;

        public LRUCache(int capacity) {
            this.size=0;
            this.capacity=capacity;
            head=new DLinkedNode();
            tail=new DLinkedNode();
            head.next=tail;
            tail.pre=head;
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            DLinkedNode dLinkedNode = cache.get(key);
            moveToHead(dLinkedNode);
            return dLinkedNode.value;
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                DLinkedNode dLinkedNode = cache.get(key);
                dLinkedNode.value=value;
                moveToHead(dLinkedNode);
            }else{
                DLinkedNode dLinkedNode = new DLinkedNode(key, value);
                if(size>=capacity){
                    removeTail();

                }
                addToHead(dLinkedNode);
            }

        }

        public void moveToHead(DLinkedNode dLinkedNode){
            dLinkedNode.pre.next=dLinkedNode.next;
            dLinkedNode.next.pre=dLinkedNode.pre;
            dLinkedNode.next=head.next;
            dLinkedNode.pre=head;
            dLinkedNode.next.pre=dLinkedNode;
            head.next=dLinkedNode;
        }

        public void removeTail(){
            cache.remove(tail.pre.key);
            tail.pre=tail.pre.pre;
            tail.pre.next=tail;
            size--;
        }

        public void addToHead(DLinkedNode node){
            node.next=head.next;
            node.pre=head;
            head.next.pre=node;
            head.next=node;
            size++;
            cache.put(node.key,node);
        }

    }

    public static void main(String[] args) {
        Solution0146 solution0146 = new Solution0146();
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
    }

}
