package UnionFind;

public class UnionFindIII {

    private int size;
    private int[] sz;
    private int[] id;
    private int numComponents;

    public UnionFindIII(int size){
        if(size < 0) throw new IllegalArgumentException("Size must bigger than 0");

        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for(int i = 0; i < size; ++i){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p){
        // id = [0, 1, 2, 2, 2, 5, 6, 7, 7, 8]

        int root = p;
        while(root != id[root]) root = id[root];

        while (p != root){
            int next = id[p];
            id[p] = root;
            p = next;
        }
                //최악의 경우에는 log(n), 거의 상수에 수렴함.
        return root;
    }

//    private int root(int i) {
//        while (i != id[i]) {
//            id[i] = id[id[i]];  //이 한 줄만 추가하면 됨!
//            i = id[i];
//        }
//        return i;
//    }  ==> Coursera


    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void unify(int p, int q){

        if(connected(p,q)) return;

        int root1 = find(p);
        int root2 = find(q);

        if(sz[root1] < sz[root2]){
            sz[root2] += sz[root1];
            id[root1] = root2;
            sz[root1] = 0;
        }else{
            sz[root1] += sz[root2];
            id[root2] = root1;
            sz[root2] = 0;
        }
        numComponents--;
    }


}
