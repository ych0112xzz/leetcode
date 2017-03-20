package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ych0112xzz on 2017/3/17.
 */
public class PrintNum {
    private static class MyComparator implements Comparator<String> {
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {

            }
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        }
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder builder = new StringBuilder(256);
        for (int s : numbers) {
            builder.append(s);
        }
        return builder.toString();
    }
}
