package interview.souhu;

import java.util.*;
import java.util.concurrent.SynchronousQueue;


public class Main {


    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int k = sc.nextInt();
        int target = sc.nextInt();
       // ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = combinationSum3(k, target);
        for(int i=0;i<result.size();i++) {
            String rt = "";
            for(int j=0;j<result.get(i).size();j++) {
                rt += result.get(i).get(j)+" ";
            }
            System.out.println(rt.trim());
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

   public static void combination(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            ArrayList<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
       if (comb.size() == k && n != 0) {
           return;
       }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i, n-i);
            comb.remove(comb.size() - 1);
        }
    }
*/
    /*public static void sumOfK(int sum, int n, ArrayList<Integer> tmp) {
        if (n <= 0) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>(tmp);
        if (sum == n) {
            list.add(0,n);
            result.add(list);
        }
        tmp.add(0,n);
        sumOfK(sum - n, n - 1, tmp);
        tmp.remove(0);
        sumOfK(sum, n - 1, tmp);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(",");
       // ArrayList<String> result = groupAnagrams(data);
        //ate,tae,hello,bro,tea,olleh
        HashSet<String> hashSet = groupAnagrams(data);
        String rt = "";
        for (int i=0;i<data.length;i++) {
            char[] data1 = data[i].toCharArray();
            Arrays.sort(data1);
            String tmp = new String(data1);
            if (hashSet.contains(tmp)) {
                    rt += data[i] + ",";

            }
        }
       /* for (int i = 0; i < result.size(); i++) {
            if (i < result.size() - 1) {
                rt += result.get(i) + ",";
            } else {
                rt += result.get(i);
            }
        }*/
        System.out.println(rt.substring(0,rt.length()-1));
    }



    public static HashSet<String> groupAnagrams(String[] strs) {
        LinkedHashMap<String, ArrayList<String>> hashmap = new LinkedHashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // boolean isKey = false;
//            byte[] b = strs[i].getBytes();
            char[] data = strs[i].toCharArray();
            Arrays.sort(data);
            String tmp = new String(data);
            //System.out.println(tmp);


            //String tmp = strs[i].substring(j, strs[i].length()) + strs[i].substring(0, j);
            if (hashmap.containsKey(tmp)) {
                ArrayList<String> list = hashmap.get(tmp);
                list.add(strs[i]);
                hashmap.put(tmp, list);
                // isKey = true;

            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashmap.put(tmp, list);
            }

        }

        ArrayList<ArrayList<String>> listValue = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        Iterator it = hashmap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            if(hashmap.get(key).size()>1)
                hashSet.add(key);
        }
        return hashSet;

    }
}
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String before = sc.nextLine();
        String after = sc.nextLine();
        boolean result=isRight(before, after);
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isRight(String before, String after) {
        int[] bef = new int[26];
        int[] aft = new int[26];
        for (char c : before.toCharArray()) {
            bef[c - 'A'] += 1;
        }
        for (char c : after.toCharArray()) {
            aft[c - 'A'] += 1;
        }
        Arrays.sort(bef);
        Arrays.sort(aft);
        int i=25;
        int j = 25;
        while (i >=0) {
            if (bef[i] == aft[i]) {
                i--;
            }else{
                return false;
            }
        }

        return true;
    }
}*/

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getBit(n));
    }



    public static int getBit(int n) {
        StringBuilder sb = new StringBuilder("1");
        int result = 1;
        BigInteger  cur= new BigInteger(sb.toString());
        while (cur.mod(BigInteger.valueOf(n)).intValue() != 0) {
            sb.append("1");
            cur = new BigInteger(sb.toString());
            result++;
        }
        return result;
    }

}*/
   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target=sc.nextInt();
        int len = sc.nextInt();
        int num[] = new int[len];
        for(int i=0;i<len;i++) {
            num[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> dp = combinationSum(num, target);
        for(int i=0;i<dp.size();i++) {
            String result = "";
            //Collections.sort(dp.get(i));
            for(int j=0;j<dp.get(i).size();j++) {
                result += dp.get(i).get(j)+" ";
            }
            System.out.println(result.trim());
        }
    }*/


    /*public static List<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int start = 0;
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<Integer>();
        DFS(result,list,candidates,target,start);
        return result;
    }
    public static void DFS(List<ArrayList<Integer>> result,ArrayList<Integer> list,int[] candidates,int target,int start){

        if(target == 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>(list);
            if(!result.contains(tmp))
                result.add(tmp);
            // result.add(list); 这样加入不成功，不明白
            return;
        }
        for(int i = start;i< candidates.length;i++){
            if(target < candidates[i]  )
                return;
            target -= candidates[i];
            list.add(candidates[i]);
            DFS(result,list,candidates,target,i);// 从i 开始 说明 可以重复选取
            target += candidates[i];// 恢复上一次的值
            list.remove(list.size() - 1);//恢复上一次的值
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        int numIntegers = Integer.parseInt(sc.nextLine());
        String[] integers = sc.nextLine().trim().split(" ");
        int[] candidates = new int[numIntegers];
        for (int i = 0 ; i < integers.length ; i ++) {
            candidates[i] = Integer.parseInt(integers[i]);
        }
        List<ArrayList<Integer>> results = combinationSum(candidates , target);
        for (int i = 0 ; i < results.size(); i ++) {
            String resultToPrint = "";
            ArrayList<Integer> result = results.get(i);
            for (int j = 0 ; j < result.size() ; j ++) {
                resultToPrint = resultToPrint + result.get(j) + " ";
            }
            System.out.println(resultToPrint.trim());
        }
    }*/

   /* public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, 0);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int start) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <target) {
                for (List<Integer> ar : combinationSum(candidates, target - candidates[i], i)) {
                    ar.add(0, candidates[i]);
                    res.add(ar);
                }
            } else if (candidates[i] == target) {
                List<Integer> lst = new ArrayList<>();
                lst.add(candidates[i]);
                res.add(lst);
            } else
                break;
        }
        return res;
    }*/

   /* public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int i=0, size = candidates.length, sum=0;
        Stack<Integer> combi = new Stack<>(), indices = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (i < size) {
            if (sum + candidates[i]>= target) {
                if (sum + candidates[i] == target) {
                    combi.push(candidates[i]);
                    result.add(new ArrayList<>(combi));
                    combi.pop();
                }
                // indices stack and combination stack should have the same size all the time
                if (!indices.empty()){
                    sum -= combi.pop();
                    i = indices.pop();
                    while (i == size-1 && !indices.empty()) {
                        i = indices.pop();
                        sum -= combi.pop();

                    }
                }
                i++;
            } else {
                combi.push(candidates[i]);
                sum +=candidates[i];
                indices.push(i);
            }
        }
        return result;
    }*/

   /* public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private static void getResult(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur, int candidates[], int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if(target == 0 ){
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }*/

    /*public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] dp =new ArrayList[target+1] ;
        for(int i=1;i<=target;i++) {
            List<List<Integer>> result = new ArrayList<>();
            for(int j=0;j<candidates.length&&candidates[j]<=i;j++) {
                if (candidates[j] == i) {
                    result.add(Arrays.asList(candidates[j]));
                }else{
                    for (List<Integer> list : dp[i - candidates[j]]) {
                        if (candidates[j] <= list.get(0)) {//用来排除重复组合如[2,2,3],[2,3,2]
                            List<Integer> cur = new ArrayList<>();
                            cur.add(candidates[j]);
                            cur.addAll(list);
                            result.add(cur);
                        }
                    }
                }
            }
            dp[i] = result;
        }
        return dp[target];
    }*/
//}
