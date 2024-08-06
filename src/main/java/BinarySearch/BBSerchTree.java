package BinarySearch;

public class BBSerchTree<T> {

    public class Node{
        public int value;
        public Node left, right;
        public int height;

        public Node(int value){
            this.value = value;
        }
    }
    public Node root;
    public int size = 0;

    public int size(){
        return size;
    }

    public int height(){
        return root.height;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Node node, int value){
        if(node == null) return false;

        if(value > node.value) return contains(node.right, value);
        else if(value < node.value) return contains(node.left, value);

        return true;
    }





}
