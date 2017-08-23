package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ych0112xzz on 2017/4/20.
 */
public class FourSum {

    public static void main(String[] args) {
        int nums[] = {0,0,0,0};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                for (int j = i+1; j < nums.length - 2; j++) {
                    if (j == i+1 || (nums[j] != nums[j - 1])) {
                        int lo = j + 1;
                        int hi = nums.length - 1;
                        while (lo < hi) {
                            int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                            if (sum == target) {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[lo]);
                                list.add(nums[hi]);
                                res.add(list);
                                while (lo < hi && nums[lo] == nums[lo + 1]) {
                                    lo++;
                                }
                                while (lo < hi && nums[hi] == nums[hi - 1]) {
                                    hi--;
                                }
                                lo++;
                                hi--;
                            } else if (sum > target) {
                                hi--;
                            } else {
                                lo++;
                            }
                        }
                    }

                }
            }
        }
        return res;
    }
}
