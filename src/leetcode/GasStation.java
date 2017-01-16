package leetcode;

/**
 * Created by ych0112xzz on 2016/11/21.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {4, 4, 2, 1, 4, 5, 6, 3, 7, 1, 8, 9, 15};
        int cost[] = {5, 1, 2, 3, 4, 2, 1, 3, 5, 7, 13, 5, 6};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

   /* public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        boolean isCom = true;
        for (int i = 0; i < gas.length; i++) {
            remain = gas[i] + remain - cost[i];
            int j = 0;
            if (remain >= 0) {
                j = i + 1;
                if (j == gas.length) {
                    j = 0;
                }
                while (j != i) {
                    remain = gas[j] + remain - cost[j];
                    if (remain < 0) {
                        isCom = false;
                        break;
                    }
                    j++;
                    if (j == gas.length) {
                        j = 0;
                    }
                }
            } else {
                isCom = false;
            }
            if (isCom) {
                return i;
            } else {
                isCom = true;
                remain = 0;
            }
        }
        return -1;
    }*/

    /*
    * O(n)
    * */
  /*  public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int remain = 0;
        for (int i = 0; i < gas.length*2-1; i++) {
            remain = gas[i%gas.length] + remain - cost[i%gas.length];
            if(remain<0){
                result = i+1;
                if(result>=gas.length){
                    return -1;
                }
                remain = 0;
            }
        }
        return result;
    }*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, localSum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            localSum += gas[i] - cost[i];
            if(localSum < 0){
                sum += localSum;
                localSum = 0;
                start = i + 1;
            }
        }
        return sum + localSum < 0 ? -1 : start;
    }

}
