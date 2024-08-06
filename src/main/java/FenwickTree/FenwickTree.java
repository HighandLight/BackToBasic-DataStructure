package FenwickTree;

public class FenwickTree {
    private long[] tree;

    public FenwickTree(int size){
        tree = new long[size];
    }

    public FenwickTree(long[] values){
        if(values == null) throw new IllegalArgumentException("Illegal Values!");

        this.tree = values.clone();

        for(int i = 1; i < tree.length; ++i){
            int j = i + lsb(i);
            if(j < tree.length) tree[j] += tree[i];
        }
    }

    public int lsb(int i){
        return i & -i;
    }

    public long prefixSum(int i){
        long sum = 0L;

        while(i != 0){
            sum += tree[i];
            i -= lsb(i);
        }
        return sum;
    }

    public long sum(int i, int j){
        if(i > j) throw new IllegalArgumentException("i는 j보다 작아야 합니다 ."); //i랑 j는 같아도 ok
        return prefixSum(j) - prefixSum(i-1);
    }

    public void add(int i, long j){
        while(i < tree.length){
            tree[i] += j;
            i += lsb(i);
        }
    }

}
