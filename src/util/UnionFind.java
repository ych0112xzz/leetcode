package util;

/**
 * Created by ych0112xzz on 2017/1/11.
 */
public class UnionFind {
    private int id[];
    private int count;
    int[] sz;//加权quickunion

    public UnionFind(int N) {
        this.count = N;
        id = new int[N];
        for(int i=0;i<N;i++) {
            id[i] = i;
        }
        sz = new int[N];
        for(int i=0;i<N;i++) {
            sz[i]=1;
        }
    }

    public int count(){
        return count;
    }

    public boolean connnected(int p,int q){
        return find(p)==find(q);
    }


    /*
    * quickfind
    * */
    /*public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for(int i=0;i<id.length;i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }*/

    /*
    * quickunion
    * */
    /*public void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    public int find(int p){
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }*/

     /*
    * 加权quickunion
    * */
     public void union(int p, int q) {
         int pRoot = find(p);
         int qRoot = find(q);
         if (pRoot == qRoot) {
             return;
         }
         if (sz[pRoot] < sz[qRoot]) {
             id[pRoot] = qRoot;
             sz[qRoot] += sz[pRoot];
         } else {
             id[qRoot] = pRoot;
             sz[pRoot] += sz[qRoot];
         }
         count--;

     }

      public int find(int p) {
          while (p != id[p]) {
//              id[p] = id[id[p]];//路径压缩
              p = id[p];
          }
          return p;
      }


}
