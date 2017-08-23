package interview.ali;

import java.util.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static int[] wordCount(String doc, int m, int n, String[] filterWords, String[] countwords) {


        return new int[0];
    }

    public static ArrayList<String> getSet(String[] filterWords) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < filterWords.length; i++) {
            int size = list.size();
            List<Integer> tmp=new ArrayList<>();
            list.add("flag");
            for (int j = 0; j < size; j++) {
                if (list.get(j).contains(filterWords[i]) && list.get(j).length() > filterWords[i].length()) {
                    tmp.add(j);
                    list.add(filterWords[i]);
                } else {
                    list.add(filterWords[i]);
                }
            }
            for(int k=0;k<tmp.size();k++) {
                list.remove(tmp.get(k));
            }
        }
        return list;
    }

    public static String filter(String doc, ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            doc.replaceAll(list.get(i), " ");
        }
        return doc;
    }

    public static int[] wordCount(String doc, String[] countWords) {
        int result[] = new int[countWords.length];

        for (int i = 0; i < countWords.length; i++) {
            for (int j = 0; j < doc.length(); j++) {
                String tmp = doc.substring(j, doc.length());
                if (tmp.contains(countWords[i])) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        String _doc;
        try {
            _doc = in.nextLine();
        } catch (Exception e) {
            _doc = null;
        }
        String tm = in.nextLine();

        int _m;
        _m = Integer.parseInt(tm.split(" ")[0]);

        int _n;
        _n = Integer.parseInt(tm.split(" ")[1]);

        int _filterWords_size = _m;
        //  _filterWords_size = Integer.parseInt(in.nextLine().trim());
        String[] _filterWords = new String[_m];
        String _filterWords_item;
        for (int _filterWords_i = 0; _filterWords_i < _filterWords_size; _filterWords_i++) {
            try {
                _filterWords_item = in.nextLine();
            } catch (Exception e) {
                _filterWords_item = null;
            }
            _filterWords[_filterWords_i] = _filterWords_item;
        }

        int _countwords_size = _n;
        // _countwords_size = Integer.parseInt(in.nextLine().trim());
        String[] _countwords = new String[_n];
        String _countwords_item;
        for (int _countwords_i = 0; _countwords_i < _countwords_size; _countwords_i++) {
            try {
                _countwords_item = in.nextLine();
            } catch (Exception e) {
                _countwords_item = null;
            }
            _countwords[_countwords_i] = _countwords_item;
        }

        ArrayList<String> list = getSet(_filterWords);
        String doc = filter(_doc, list);
        res = wordCount(doc, _countwords);
        // res = wordCount(_doc, _m, _n, _filterWords, _countwords);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}