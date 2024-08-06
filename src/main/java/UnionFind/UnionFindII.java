package UnionFind;

public class UnionFindII {

    private int size;
    private int[] sz;
    private int[] id;
    private int numComponents;


    public UnionFindII(int size){
        if(size <=0) throw new IllegalArgumentException("size must be more than 0");
        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for (int i = 0; i < size; ++i){
            id[i] = i;
            sz[i] = 1;
        }
    }
}
