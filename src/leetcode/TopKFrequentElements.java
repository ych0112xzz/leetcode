package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/11/16.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int nums[] = {5,1,-1,-8,-7,8,-5,0,1,10,8,0,-4,3,-1,-1,4,-5,4,-3,0,2,2,2,4,-2,-4,8,-7,-7,2,-8,0,-8,10,8,-8,-2,-9,4,-7,6,6,-1,4,2,8,-3,5,-9,-3,6,-8,-5,5,10,2,-5,-1,-5,1,-3,7,0,8,-2,-3,-1,-5,4,7,-9,0,2,10,4,4,-4,-1,-1,6,-8,-9,-1,9,-9,3,5,1,6,-1,-2,4,2,4,-6,4,4,5,-5};
        List<Integer> result = new TopKFrequentElements().topKFrequent(nums, 7);
        for (int val : result) {
            System.out.println(val);
        }
    }

    /*public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }

        });

        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            if (hashMap.containsKey(nums[i])) {
                tmp = hashMap.get(nums[i]) + 1;
            } else {
                tmp = 1;
            }
            hashMap.put(nums[i], tmp);
        }
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()) {
            if (heap.size() < k) {
                heap.add(entry);
            } else {
                if (entry.getValue() >heap.peek().getValue() ) {
                    heap.poll();
                    heap.add(entry);
                }
            }
        }
        while (!heap.isEmpty()) {
            result.add(0,heap.poll().getKey());
        }
        return result;
    }*/

    /*
    * heap
    * */

    private class Node implements Comparable<Node>{
        private int val;
        private int freq;

        public Node(int val,int freq){
            this.val = val;
            this.freq = freq;

        }

        @Override
        public int compareTo( Node o2) {
            return this.freq-o2.freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(k,new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.freq-o2.freq;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
            if (pq.size() > k) pq.poll();
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll().val);
        return result;
    }


    /*
    * 桶排序
    * */
   /* public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int i : nums) {
            if (!frequencyMap.containsKey(i)) frequencyMap.put(i, 1);
            else frequencyMap.put(i, frequencyMap.get(i) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }*/

    /*
    * treeMap
    * */
   /* public List<Integer> topKFrequent(int[] nums, int k) {
        //collect the <nums,count> in a hashmap
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        //sorted the <count,nums_list> using TreeMap
        TreeMap<Integer,List<Integer>> tm=new TreeMap<Integer,List<Integer>>();
        for(int num:map.keySet()){
            int count=map.get(num);
            if(!tm.containsKey(count))
                tm.put(count,new ArrayList<Integer>());
            tm.get(count).add(num);
        }
        //get the top k from TreeMap
        List<Integer> res=new ArrayList<Integer>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = tm.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }*/
}

