package leetcode;


import java.util.*;

/**
 * Created by ych0112xzz on 2016/10/12.
 */
public class FindMedianfromDataStream {

    public static void main(String[] args){
        FindMedianfromDataStream f = new FindMedianfromDataStream();
        f.addNum(1);
        f.addNum(2);
        System.out.println(f.findMedian());
        f.addNum(3);
        System.out.println(f.findMedian());
    }


/*
* 使用优先队列
* */
    /*PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public FindMedianfromDataStream() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

        // Adds a number into the data structure.
    public void addNum(int num) {

        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if(maxSize==0){
            maxHeap.add(num);
            return;
        }

        //int minValue = minHeap.peek();
        int maxValue = maxHeap.peek();
        int minus = maxSize - minSize;
        if(num<=maxValue){
            maxHeap.add(num);
            if(minus>0){
                minHeap.add(maxHeap.poll());
            }
        }else{
            minHeap.add(num);
            System.out.println(maxHeap);
            if(minus<=0){
                maxHeap.add(minHeap.poll());
            }
        }
        System.out.println(minHeap);
        System.out.println(maxHeap);
    }

    public double findMedian() {

        int maxSize = maxHeap.size();
        if(maxSize==0){
            return 0;
        }
        int minSize = minHeap.size();
        int size = minSize + maxSize;
        if(size%2==0){
            return (minHeap.peek() + maxHeap.peek()) * 1.0 / 2;
        }else{
            return maxHeap.peek();
        }

    }*/



/*
* 使用list，但复杂度高
* */
    ArrayList<Integer> list;

    FindMedianfromDataStream(){
        this.list = new ArrayList<>();
    }


    // Adds a number into the data structure.
    public void addNum(int num) {
        int length = list.size();
        list.add(num);
        Collections.sort(list);

//        int index = -1;
//        int start = 0;
//        int end = length;
//        int mid = start + (end - start) / 2;
//        while(start<end){
//            if(list.get(mid)<num){
//                start = start + 1;
//            }else if(list.get(mid)>num){
//                end = mid;
//            }else{
//                start = mid;
//                break;
//            }
//            mid = start + (end - start) / 2;
//        }
//        index = start;
//        list.add(index,num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(list.size()==0){
            return 0;
        }
//        Collections.sort(list);
        if(list.size()%2==0){
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) * 1.0 / 2;
        }else{
            return list.get(list.size() / 2);
        }

    }
}
