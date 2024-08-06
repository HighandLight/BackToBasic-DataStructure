package Queue;

public class IndexedPQ {

public int size;
//public int countChild;
//  Key값이 index로
    //integer 지원 확대

public int[] values;
public int[] positionMap; // key를 매핑
public int[] indexMap; //힙의 index를 매핑
//public int[] parent;
//public int[] child;
public IndexedPQ(int maxSize){
    if (maxSize < 0 ) throw new IllegalArgumentException("size must bigger than 0");

    positionMap = new int[maxSize];
    indexMap = new int[maxSize];
    values = new int[maxSize];

    for(int i = 0; i < maxSize; ++i){
        positionMap[i] = indexMap[i] = -1;
    }

}

public int size(){
    return size;
}

public boolean isEmpty(){
    return size() == 0;
}

public boolean contains(int value){
    if(value < 0 || value > size) throw new IllegalArgumentException("Invalid Value!");
    return positionMap[value] != -1;
}

public void insert(int key, int value){
    if(contains(key)) throw  new IllegalArgumentException("key index arleady exist!");
    positionMap[key] = size;
    indexMap[size] = value;
    values[key] = value;
    swim(size++);
}

public void swim(int i){
    //i가 부모보다 작은 조건을 만족하는 동안, i와 부모를 교체 후 i를 부모로 만들기
    while(values[i] < values[i /2]){
        swap(i, i / 2);
        i = i / 2;
    }
}

public void swap(int i, int j){
    positionMap[indexMap[j]] = i;
    positionMap[indexMap[i]] = j;
    int tmpIndex = indexMap[i];
    indexMap[i] = indexMap[j];
    indexMap[j] = tmpIndex;

    int tmpValue = values[i];
    values[i] = values[j];
    values[j] = tmpValue;
}






}






