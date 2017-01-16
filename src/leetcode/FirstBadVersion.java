package leetcode;

/**
 * Created by ych0112xzz on 2016/10/19.
 */
public class FirstBadVersion {

    public static void main(String[] args){
        int n = 2126753390;
        //int n=3;
        int value = 1702766719;
        //int value = 1;

    }

    public int firstBadVersion(int n) {
        int start=1;
        int end = n;

        while(start<end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid+1;
            }

        }

        return start;
    }

    private boolean isBadVersion(int mid) {
        if(mid>1){
            return true;
        }
        return false;
    }
}
