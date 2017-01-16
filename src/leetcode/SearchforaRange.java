package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/9/8.
 */
public class SearchforaRange {

    public static void main(String[] args) {
        int[] nums = {8,8, 8,9};
        int[] result = searchRange(nums, 8);
        System.out.println(result[0] + "\t" + result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int[] result = new int[2];
        int mid = nums.length / 2;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int low = findLow(nums, target, 0, nums.length);
        int high = findHigh(nums, target, 0, nums.length);

        result[0] = low;
        result[1] = high;


        return result;
    }

    private static int findLow(int[] nums, int target, int start, int end) {
        int mid = 0;
        int result = -1;
        while (start < end) {
            mid = (start + end) / 2;
            if (mid >= nums.length) {
                return result;
            }
            if (nums[mid] == target) {
                result = mid;
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return result;
    }

    private static int findHigh(int[] nums, int target, int start, int end) {
        int mid = 0;
        int result = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid >= nums.length) {
                return result;
            }
            if (nums[mid] == target) {
                result = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;


    }


    /*
    * 以下为循环方法
    * */
    private static int findEnd(int[] nums, int target, int start, int end) {
        int mid = 0;
        int result = -1;
        // int mid = (start + end) / 2;
        if (start <= end) {
            mid = (start + end) / 2;
            if (mid >= nums.length) {
                return result;
            }
            if (nums[mid] == target) {
                result = mid;
                //System.out.println(result);
                int next = findEnd(nums, target, mid + 1, end);
                if (next != -1) {
                    result = next;
                }
            } else if (nums[mid] < target) {
                result = findEnd(nums, target, mid + 1, end);
            } else {
                result = findEnd(nums, target, start, mid - 1);
            }
        }
//        if(result>=end-1){
//            return end-1;
//        }
        return result;
    }


    private static int findStart(int[] nums, int target, int start, int end) {
        int mid = 0;
        int result = -1;
        // int mid = (start + end) / 2;
        if (start <= end) {
            mid = (start + end) / 2;
            if (mid >= nums.length) {
                return result;
            }
            if (nums[mid] == target) {
                result = mid;
                // System.out.println(mid);
                int next = findStart(nums, target, start, mid - 1);
                // System.out.println(next);
                if (next != -1) {
                    result = next;
                }
            } else if (nums[mid] < target) {
                result = findStart(nums, target, mid + 1, end);
            } else {
                result = findStart(nums, target, start, mid - 1);
            }
        }
        return result;
    }

//    public static int findStart(int[] nums, int target, int middle) {
//        int start = 0;
//        int end = nums.length;
//
//        if (end == 0) {
//            return middle;
//        }
//        int mid = (start + end) / 2;
//        int result = 0;
//        while (start < mid && mid <= end) {
//            if (nums[mid] < target) {
//                start = mid;
//                mid = (start + end) / 2;
//            } else {
//                result = mid;
//                end = mid;
//                mid = (start + end) / 2;
//            }
//        }
//        if (nums[start] == target) {
//            return start;
//        }
//        return result != 0 ? result : middle;
//    }
//
//    public static int findEnd(int[] nums, int target, int middle) {
//        int start = 0;
//        int end = nums.length;
//        if (end == 0) {
//            return middle;
//        }
//        int mid = (start + end) / 2;
//        int result = 0;
//        while (start < mid && mid < end) {
//            if (nums[mid] == target) {
//                result = mid;
//                start = mid;
//                mid = (start + end) / 2;
//            } else {
//                end = mid;
//                mid = (start + end) / 2;
//            }
//        }
//
//        return nums[result] == target ? middle + result + 1 : middle;
//        //return target;
//    }
}
