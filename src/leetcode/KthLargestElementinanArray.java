package leetcode;

/**
 * Created by ych0112xzz on 2016/10/12.
 */
public class KthLargestElementinanArray {

    public static void main(String[] args) {
        int[] nums = {7, 2, 9, 8, 5, 6, 4, 7};
        System.out.println(new KthLargestElementinanArray().findKthLargest(nums, 5));
    }


    /*
    * 使用count
    * */
   /* public int findKthLargest(int[] nums, int k){
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){//求出最大最小值
            if(nums[i]>max) max=nums[i];
            else if(nums[i]<min) min=nums[i];
        }
        int[] counts=new int[max-min+1];
        for(int i=0;i<nums.length;i++){//
            counts[nums[i]-min]++;
        }
        int large=0;
        for(int i=counts.length-1;i>=0;i--){
            k-=counts[i];
            if(k<=0) {
                large = i+min;
                break;
            }
        }
        return large;
    }*/


    /*
    * 使用优先队列
    * */
   /* public int findKthLargest(int[] nums, int k){
        if(nums.length==1){
            return nums[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue(k);
        //System.out.println(minHeap.size());
        minHeap.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(minHeap.size()<k){
                minHeap.add(nums[i]);
            }else{
                int value = minHeap.peek();
                if(nums[i]>value){
                    minHeap.poll();
                    minHeap.add(nums[i]);
                    System.out.println(minHeap.size());
                }
            }
        }
        return minHeap.peek();
    }*/


    /*
    * 排序
    * */
    /*public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }*/

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);
        }
        swap(nums, left, end);// Finally, swap A[end] with A[left]

        if (left == k)// Found kth smallest number
            return nums[left];
        else if (left < k)// Check right part
            return findKthLargest(nums, left + 1, end, k);
        else // Check left part
            return findKthLargest(nums, start, left - 1, k);
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    /*
    * quickselect
    * */
   /* public Integer findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length)
            return null;
        int len = nums.length;
        int index = len - k;
        return quickSelect(nums, 0, len - 1, index);
    }

    private int quickSelect(int[] nums, int left, int right, int index) {
        if (left == right)
            return nums[left];
        int mid = (left + right) / 2;
        int pivot = nums[mid];
        nums[mid] = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > pivot) j--;
            if (i == j) break;
            nums[i] = nums[j];
            i++;
            while (i < j && nums[i] < pivot) i++;
            if (i == j) break;
            nums[j] = nums[i];
            j--;
        }
        nums[i] = pivot;
        if (i == index) return nums[index];
        if (i > index) return quickSelect(nums, left, i - 1, index);
        return quickSelect(nums, i + 1, right, index);
    }*/



    /*public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        quicksort(nums, 0, n - 1, target);
        return nums[n - k];
    }

    private void quicksort(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int pivot = choosePivot(nums[mid], nums[start], nums[end]);
        //int pivot = nums[mid];
        int i = start;
        int j = end;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (nums[i] != nums[j]) {
                    swap(nums, i, j);
                }
                i++;
                j--;
            }
        }
        if (target <= i - 1) {
            quicksort(nums, start, i - 1, target);
        } else {
            quicksort(nums, i, end, target);
        }
    }

    private int choosePivot(int a, int b, int c) {
        if (a > b) {
            if (c > a) {
                return a;
            } else if (c > b) {
                return c;
            } else {
                return b;
            }
        } else {
            if (c > b) {
                return b;
            } else if (c > a) {
                return c;
            } else {
                return a;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }*/


}
