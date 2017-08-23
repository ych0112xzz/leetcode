package interview.huawei;
import java.util.*;

public class Main {

    private static class Task {
        int taskID;
        int prior;
        int start;
        int time;

        Task(int taskID, int prior, int start, int time) {
            this.taskID = taskID;
            this.prior = prior;
            this.start = start;
            this.time = time;
        }
    }

    static TreeMap<Integer, Task> taskTree = new TreeMap<Integer, Task>();
    static ArrayList<Task> result = new ArrayList();
    static int timeSum = 0;


    public static void getResult(Task[] inTaskArray) {

        Task task0 = new Task(0, 0, 0, inTaskArray[0].start);
        result.add(task0);
        timeSum += task0.time;

        // 处理大部分
        for (int i = 0; i < inTaskArray.length - 1 && timeSum <= 200; i++) {
            if (!taskTree.isEmpty() && timeSum <= 200) {
                Set set = taskTree.descendingKeySet();
                for (Object key : set) {
                    int prior = Integer.parseInt(key.toString());

                    if (prior >= inTaskArray[i].prior) {
                        result.add(taskTree.get(prior));
                        timeSum += taskTree.get(prior).time;
                        taskTree.remove(new Integer(prior));
                    }

                }
            }

            int firstEnd = inTaskArray[i].start + inTaskArray[i].time;
            int nextStart = inTaskArray[i + 1].start;

            if (nextStart >= firstEnd) {
                result.add(inTaskArray[i]);
                timeSum += inTaskArray[i].time;
            } else {
                int reserveTime = firstEnd - nextStart;
                Task taskThis = inTaskArray[i];
                Task taskTmp = new Task(taskThis.taskID, taskThis.prior, taskThis.start, reserveTime);
                taskTree.put(taskThis.prior, taskTmp);
                inTaskArray[i].time = inTaskArray[i + 1].start - inTaskArray[i].start;
                result.add(inTaskArray[i]);
                timeSum += (inTaskArray[i + 1].start - inTaskArray[i].start);
            }

        }

        // 处理最后一个
        Task task = inTaskArray[inTaskArray.length - 1];
        if (!taskTree.isEmpty() && timeSum <= 200) {
            Set set = taskTree.descendingKeySet();
            for (Object key : set) {
                int prior = Integer.parseInt(key.toString());
                if (prior >= task.prior) {
                    result.add(taskTree.get(prior));
                    timeSum += taskTree.get(prior).time;
                    taskTree.remove(new Integer(prior));
                }

            }
        }
        result.add(task);
        timeSum += task.time;


        // 处理剩余
        if (!taskTree.isEmpty() && timeSum <= 200) {
            Set set = taskTree.descendingKeySet();
            for (Object key : set) {
                int prior = Integer.parseInt(key.toString());
                result.add(taskTree.get(prior));
                timeSum += taskTree.get(prior).time;
                taskTree.remove(new Integer(prior));
            }

        }


        //处理优先0
        if (timeSum < 200) {
            result.add(new Task(0, 0, 0, 200 - timeSum));
        }

    }


    public static void print() {
        for(int i =0; i<result.size()-1; i++){
            System.out.print(String.valueOf(result.get(i).taskID) + "." + String.valueOf(result.get(i).time) + "|");

        }
        System.out.print(String.valueOf(result.get(result.size()-1).taskID) + "." + String.valueOf(result.get(result.size()-1).time));

    }


    public static Task[] initial() {

        Task[] inTaskArray = new Task[5];
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tasks = str.split("\\|");
        int count = 0;
        for (String s : tasks) {
            s = s.substring(1, s.length() - 1);
            System.out.println(s);
            String[] tmp = s.split("\\.");
            inTaskArray[count] = new Task(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
            count++;
        }
        return inTaskArray;



    }


    public static void main(String[] args) {
        getResult(initial());
        print();

    }
}







/*
package interview.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();
        Scanner sc = new Scanner(System.in);

//        while(){}
        String line = sc.nextLine();
        int[] num = String2Array(line);

        if (num.length != 3) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (num[i] < 1 || num[i] > 9) {
                System.out.println(-1);
                return;
            }

        }

        if (num[0] == num[1] || num[1] == num[2] || num[2] == num[0]) {
            System.out.println(-1);
            return;
        }

        int max = Math.max(num[0], Math.max(num[1], num[2]));

        helper(num, set);

        String str = line;

        if (str.contains("2") && str.contains("5")) {
            System.out.println(-1);
            return;
        }
        if (str.contains("6") && str.contains("9")) {
            System.out.println(-1);
            return;
        }

        helper(String2Array(str.replace("2", "5")), set);
        helper(String2Array(str.replace("2", "5").replace("6", "9")), set);
        helper(String2Array(str.replace("2", "5").replace("9", "6")), set);

        helper(String2Array(str.replace("5", "2")), set);
        helper(String2Array(str.replace("5", "2").replace("6", "9")), set);
        helper(String2Array(str.replace("5", "2").replace("9", "6")), set);

        helper(String2Array(str.replace("6", "9")), set);
        helper(String2Array(str.replace("6", "9").replace("2", "5")), set);
        helper(String2Array(str.replace("6", "9").replace("5", "2")), set);

        helper(String2Array(str.replace("9", "6")), set);
        helper(String2Array(str.replace("9", "6").replace("2", "5")), set);
        helper(String2Array(str.replace("9", "6").replace("5", "2")), set);

        int count = 0;
        int temp = 0;
        for (int i : set) {
            count++;
            if (count == max) {
                System.out.println(i);
                return;
            }
            temp = i;
        }

        System.out.println(temp);

    }

    public static void helper(int[] num, Set set) {
        Arrays.sort(num);
        set.add(num[0]);
        set.add(num[1]);
        set.add(num[2]);

        set.add(num[0] * 10 + num[1]);
        set.add(num[0] * 10 + num[2]);
        set.add(num[1] * 10 + num[0]);
        set.add(num[1] * 10 + num[2]);
        set.add(num[2] * 10 + num[0]);
        set.add(num[2] * 10 + num[1]);

        set.add(num[0] * 100 + num[1] * 10 + num[2]);
        set.add(num[0] * 100 + num[2] * 10 + num[1]);
        set.add(num[1] * 100 + num[0] * 10 + num[2]);
        set.add(num[1] * 100 + num[2] * 10 + num[0]);
        set.add(num[2] * 100 + num[0] * 10 + num[1]);
        set.add(num[2] * 100 + num[1] * 10 + num[0]);

    }

    public static int[] String2Array(String str) {
        int[] result = new int[3];
        String[] temp = str.split(",");
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }
*/
//}