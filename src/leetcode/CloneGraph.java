package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/12/6.
 */
public class CloneGraph {


    /*
    * DFS
    * */
    /*HashMap<Integer,UndirectedGraphNode> hashMap = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (hashMap.containsKey(node.label)) {
            return hashMap.get(node.label);
        }
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        hashMap.put(result.label,result);
        ArrayList<UndirectedGraphNode> list = new ArrayList<>();
        for (UndirectedGraphNode tmp : node.neighbors) {
            UndirectedGraphNode cur = cloneGraph(tmp);
            list.add(cur);

        }
        result.neighbors = list;
        return result;
    }*/


    /*
    * BFS
    * */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        if (node == null) {
            return null;
        }

        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        hashMap.put(node,result);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            ArrayList<UndirectedGraphNode> list = new ArrayList<>();
            for (UndirectedGraphNode neighbor : tmp.neighbors) {
                if (!hashMap.containsKey(neighbor)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    list.add(newNode);
                    hashMap.put(neighbor, newNode);
                    queue.add(neighbor);
                }else{
                    UndirectedGraphNode newNode = hashMap.get(neighbor);
                    list.add(newNode);
                }
            }
            tmp.neighbors = list;
        }
        return result;
    }
}
