package BinarySearch;

public class AVLTreeRecursiveII {
    public class Node{
        public int balance;
        public int value;
        public int height = 1;
        public Node left, right;

        public Node(int value){
            this.value = value;
        }
    }

    public Node root;
    public int nodeCount = 0;

    public int height(){
        if(root == null) return 0;
        return root.height;
    }

    public int size(){
        return nodeCount;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    public boolean contains(Node node, int value){
        if(node == null) return false;

        if(node.value > value) return contains(node.right, value);
        else if(node.value < value) return contains(node.left, value);
        else return true;

        //if - else if - else 문으로 적는 것이 return 값 실수 적을 듯

    }

    public boolean insert(int value){
        if(!contains(value)){
            root = insert(root, value);
            nodeCount++;
            return true;
        }
        return false;
    }

    public Node insert(Node node, int value){
        if(node == null) return new Node(value);
        if(node.value > value) node.right = insert(node.right, value);
        if(node.value < value) node.left = insert(node.left, value);

        update(node);

        return balance(node);
    }

    public void update(Node node){
        int leftHeight = (node.left == null) ? 0 : node.left.height;
        int rightHeight = (node.right == null) ? 0 : node.right.height;
        node.height = Math.max(leftHeight, rightHeight) + 1;
        node.balance = rightHeight - leftHeight;
    }

    public Node balance(Node node){
        if(node.balance == -2 ){
            if(node.left.balance == -1) return ll(node);
            else if(node.left.balance == 1) return lr(node);
        }else if (node.balance == 2){
            if(node.right.balance == -1) return rl(node);
            else if (node.right.balance == 1) return rr(node);
        }
        return node;
    }

    public Node ll(Node node){
        return rightRotation(node);
    }

    public Node lr(Node node){
        node.left = leftRotation(node.left);
        return rightRotation(node);
        // left를 죄회전 -> ll
        // 우회전
    }

    public Node rr(Node node){
        return leftRotation(node);
    }

    public Node rl(Node node){
        node.right = rightRotation(node.right);
        return leftRotation(node);

        //right를 우회전 -> rr
        //좌회전
    }

    public Node leftRotation(Node node){
        Node rChild = node.right;
        Node rlChild = rChild.left;
        rChild.left = node;
        node.right = rlChild;

        update(node);
        update(rChild);
        return rChild;
    }

    public Node rightRotation(Node node){
        Node lChild = node.left;
        Node lrChild = lChild.right;
        lChild.right = node;
        node.left = lrChild;

        update(node);
        update(lChild);

        return lChild;
    }

    /*
        왼쪽 >= 오른쪽 + 2
            LL : T.l.l 가 가장 긴 경우
            LR : T.L.R
        오른쪽 >= 왼쪽 + 2
            RR : 오른쪽 > 왼쪽
            RL : 오른쪽 <= 왼쪽
     *
     * balance == 0 -> 균형
       balance > 0 -> 오른쪽이 더 큼
       balance < 0 -> 왼쪽이 더 큼
     */














}
