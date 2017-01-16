package leetcode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/9/23.
 */
public class VerifyPreorderSerializationofaBinaryTree {

    public static void main(String[] args){
        String s="1,#,#,#,#";
        //String s = "9,3,4,6,#,#,7,#,#,5,8,9,#,#,10,#,12,#,#,#,#";
        System.out.println(isValidSerialization(s));
    }

    public static boolean isValidSerialization(String preorder){
        if(preorder.length()==0){
            return true;
        }
        if(preorder.length()==1&&preorder.equals("#")){
            return true;
        }

        return false;
    }

//    public static boolean isValidSerialization(String preorder) {
//        if(preorder.length()==0){
//            return false;
//        }
//        Stack<String> result=new Stack<>();
//
//        String[] data = preorder.split(",");
//        result.push(data[0]);
//        for(int i=1;i<data.length;i++){
//            String tmp = result.peek();
//            if(i< data.length-1&&result.isEmpty()){
//                return false;
//            }
//            if(result.peek().equals("#")&&data[i].equals("#")){
//
//                result.pop();
//                if(result.isEmpty()){
//                    return false;
//                }
//                result.pop();
//
//                while(!(result.isEmpty())&&result.peek().equals("#")){
//                    result.pop();
//                    if(result.isEmpty()){
//                        return false;
//                    }
//                    result.pop();
//                }
//                result.push("#");
//            }else{
//                result.push(data[i]);
//            }
//
//        }
//        if(result.size()==1&&result.pop().equals("#")){
//            return true;
//        }
//        return false;
//    }
}
