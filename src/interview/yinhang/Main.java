package interview.yinhang;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        classfy(url);
        print(hashMap);
    }

    private static void print(HashMap<String, String> hashMap) {
        for(Map.Entry<String,String> entry : hashMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    static HashMap<String, String> hashMap = new HashMap<>();

    public static void classfy(String url) {
        if (url == null || url.length() == 0) {
            return;
        }
        String type = getType(url);
        if (hashMap.containsKey(type)) {
            hashMap.put(type, hashMap.get(type) + "," + url);
        }else{
            hashMap.put(type, url);
        }
        List<String> list = new ArrayList<>();
        list = getUrl(url);
        if (list == null||list.size()==0) {
            return;
        }
        for (String s : list) {
            classfy(s);
        }
    }

    public static String getType(String url) {
        return url;
    }

    public static List<String> getUrl(String url) {
        List<String> list = new ArrayList<>();
        return null;
    }
}
