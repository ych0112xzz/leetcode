package leetcode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ych0112xzz on 2016/10/19.
 */
public class DecodeString {


    public static void main(String[] args) {
        String s = "3[a2[c]]3[vb]";
        System.out.println(new DecodeString().decodeString(s));
    }

    /*public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==0){
            return "";
        }
        String result = "";
      //  String prevTmp=""
        char[] data = s.toCharArray();
        for(int i=0;i<data.length;i++) {
            if (data[i] != ']') {
                stack.push(data[i]);
            }else{
                String tmp = "";
                char c = stack.pop();
                while(c!='['){
                    tmp = c + tmp;
                    c = stack.pop();
                }
                //System.out.println(tmp);
                String num = "";
                while(stack.size()>0&&stack.peek()>='0'&&stack.peek()<='9'){
                    num = stack.pop() + num;
                }
                int k = Integer.valueOf(num);
                for(int j=0;j<k;j++){
                    for(int index=0;index<tmp.length();index++){
                        stack.push(tmp.charAt(index));
                    }
                }

            }
        }
        while(stack.size()>0){
            result = stack.pop() + result;
        }
        return result;
    }*/


    /*
    * 用两个stack，一个存次数，一个存字符串
    * */
   /* public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
    }*/


    /*
    * DFS
    * */

    /*int i=0; //i必须设置为全局变量，否则会重复计算s中的某些字符
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }
        return DFS(s, 0);
    }

    private String DFS(String s, int index) {
        if (index >= s.length()) {
            return "";
        }
        int num;
        StringBuilder numStr = new StringBuilder();
        StringBuilder letterStr = new StringBuilder();
        for ( i = index; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numStr.append(s.charAt(i));
            }
            if (Character.isLetter(s.charAt(i))) {
                letterStr.append(s.charAt(i));
            }
            if (s.charAt(i) == '[') {
                String str = DFS(s, i + 1);
                for (int j = 0; j < Integer.valueOf(numStr.toString()); j++) {
                    letterStr.append(str);
                }
                numStr.delete(0, numStr.length());
            } else if (s.charAt(i) == ']') {
                return letterStr.toString();
            }
        }
        return letterStr.toString();
    }*/


    /*
    * 正则表达式+递归
    * */
    Pattern p = Pattern.compile("\\[[a-z]*\\]");

    public String decodeString(String s) {
        Matcher m = p.matcher(s);
        String sub = "";
        if(!m.find()){
            return s;
        }else{
            sub = m.group();
            System.out.println(sub);
        }
        String content = sub.substring(1,sub.length()-1);
        String pattern ="\\d*(?=\\["+content+"\\])";
        Pattern numberCompile = Pattern.compile(pattern);
        Matcher numberMatcher = numberCompile.matcher(s);

        int count = 0 ;
        if(numberMatcher.find()){
            count = Integer.valueOf(numberMatcher.group());
            //System.out.println(numberMatcher.group());
        }
        String instend = "";
        for(int i=0;i<count;i++){
            instend += content;
        }
        return decodeString(s.replace(count+sub,instend));
    }

}
