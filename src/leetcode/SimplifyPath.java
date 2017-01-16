package leetcode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/10/11.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(new SimplifyPath().simplifyPath(path));
        String s = "///";
        String a[] = s.split("/");
        System.out.println(a.length);
    }

    public String simplifyPath(String path){
        if(path.length()==0||path.equals("/")){
            return path;
        }
        Stack<String> stack=new Stack<>();
        String[] array = path.split("/");
        for(int i=0;i<array.length;i++){
            System.out.println(stack.toString());
            if(array[i].equals("..")){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else if(array[i].equals("")||array[i].equals(".")){

            }else{
                stack.push(array[i]);
            }
        }

        String result="";
        if(stack.isEmpty()){
            return "/";
        }else{
            while(!stack.isEmpty()){
                result = "/"+stack.pop()+result;
            }
            return  result;
        }
}
   /*public String simplifyPath(String path){
       Stack<String> stack = new Stack<>();
       String tmp = "";
       for (int i = 0; i < path.length(); i++) {
           tmp += path.charAt(i);
           if (path.charAt(i) == '/') {
                if(tmp.equals("./")||tmp.equals("/")){
                    if(stack.isEmpty()){
                        stack.push("/");
                    }
                }else if(tmp.equals("../")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else{
                    stack.push(tmp);
                    tmp = "";
                }
           }
       }
       if(stack.isEmpty()){
           return "/";
       }else{
           String result = stack.pop();
           for(int i=0;i<stack.size();i++){
               result = stack.pop() + result;
           }
           return result.substring(0,result.length()-1);
       }
    }*/
}
