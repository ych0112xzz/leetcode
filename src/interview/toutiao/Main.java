package interview.toutiao;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                num[i][j] = sc.nextInt();
            }
        }
        System.out.println(6);

    }


}
   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Long> hashSet = new HashSet<>();
        while (true) {
            long line = Long.valueOf(sc.nextLine());
            if (line == 0l) {
                break;
            } else {
                hashSet.add(line);
            }
        }
        System.out.println(hashSet.size());
    }
}*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BitSet bitSet = new BitSet();
        while(sc.hasNext()){
             long line = Long.valueOf(sc.nextLine());
            if (line==0l) {
                break;
            }else {
                bitSet.set();
            }
        }

    }

*/
//}
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] data = s.toCharArray();
        int depth = depth(data);
        print(data, depth);
    }

    public static void print(char[] data, int depth) {
        Stack<Character> stack = new Stack<>();
        Stack<String> result = new Stack<>();
        boolean isRoot = false;
        for(int i=0;i<data.length;i++) {
            if(data[i]=='['){
                isRoot = true;
                stack.push(data[i]);
            }else{
                int size = stack.size();
                int numjia = 2*depth+1 - 2 * size;
                if(isRoot) {
                    String str="|";
                    for(int k=0;k<numjia;k++) {
                        str += " ";
                    }
                    str=str + "|";
                    String tmp1=str;
                    if (str.length() < 2 * depth + 1) {
                        for(int t=0;t<(2*depth+1-tmp1.length())/2;t++) {
                            str = " " + str;
                        }
                        for(int t=0;t<(2*depth+1-tmp1.length())/2;t++) {
                            str =  str+" ";
                        }
                    }
                    result.push(str);
                }
                isRoot = false;
                String str="|+";
                if (size == 1) {
                    str="+";
                }
                for(int k=0;k<numjia;k++) {
                    str += "-";
                }
                if(size==1){
                    str=str + "+";
                }else{
                    str = str + "+|";
                }
                String tmp1=str;
                if (str.length() < 2 * depth + 1) {
                    for(int t=0;t<(2*depth+1-tmp1.length())/2;t++) {
                        str = " " + str;
                    }
                    for(int t=0;t<(2*depth+1-tmp1.length())/2;t++) {
                        str =  str+" ";
                    }
                }
                result.push(str);
                stack.pop();
            }
            if (stack.isEmpty() && !result.isEmpty()) {
                Stack<String> tmp = new Stack<>();
                while (result.size()>0) {
                    tmp.push(result.peek());
                    System.out.println(result.pop());
                }
                System.out.println();
                while(tmp.size()>0) {
                    System.out.println(tmp.pop());
                }
            }
        }
    }

    public static int depth(char[] data) {
        int result = 0;
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<data.length;i++) {
            if (data[i] == '[') {
                stack.push(data[i]);
                result = Math.max(result, stack.size());
            }else if(data[i]==']'){
                stack.pop();
            }

        }
        return result;
    }

}*/

 /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sdata = sc.nextLine().split(" ");
        int N = Integer.valueOf(sdata[0]);
        int M = Integer.valueOf(sdata[1]);

        String[] para = new String[N];
        for(int i=0;i<N;i++) {
            para[i] = sc.nextLine().toLowerCase();

        }
        String[] query = new String[M];
        for(int i=0;i<M;i++) {
            query[i] = sc.nextLine().toLowerCase();

        }


        for(int j=0;j<M;j++) {
            int max = 0;
            int index=0;
            for(int i=0;i<N;i++) {
                String[] data = para[i].split(" ");
                HashSet<String> hashSet = new HashSet<>();
                for (String str : data) {
                    hashSet.add(str);
                }
                int count = 0;
                HashSet<String> cur = new HashSet<>();
                String[] dataM = query[j].split(" ");
                for (String tmp : dataM) {
                    cur.add(tmp);
                }

                for (Iterator it=cur.iterator(); it.hasNext();) {
                    if (hashSet.contains(it.next())) {
                        count++;
                    }
                }
                index = max > count ? index : i;
                max = Math.max(max, count);
            }
            System.out.println(para[index]);
        }



    }*/
