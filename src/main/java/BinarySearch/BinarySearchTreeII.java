package BinarySearch;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeII<T extends Comparable<T>> {

    private int nodeCount = 0;
    private Node root = null;

    private class Node{
        private T data;
        private Node left;
        private Node right;

        public Node(T data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public int size(){
        return nodeCount;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean contains(Node node, T data){
        if(node == null) return false;

        int compare = data.compareTo(node.data);

        if(compare < 0) return contains(node.left, data);
        else if(compare > 0) return contains(node.right, data);
        else return true;
    }

    public boolean add(T data){
        if(contains(root, data)) return false;
        else {
            root = add(root, data);
            nodeCount ++;
            return true;
        }
    }

    public Node add(Node node, T data){
        if(node == null){
            node = new Node(data, null, null);
        }else{
            if(data.compareTo(node.data) < 0 ){
                node.left = add(node.left, data);
            }else{
                node.right = add(node.right, data);
            }
        }
        return node;
    }

    public boolean remove(T data){
        if(!contains(root, data)) return false;
        else{
            root = remove(root, data);
            nodeCount --;
            return true;
        }
    }

    public Node remove(Node node, T data){
//        if(node == null) return null;

        int compare = data.compareTo(node.data);

        if(compare < 0) remove(node.left, data);
        else if(compare > 0) remove(node.right, data);
        else{
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }else{
                Node minNode = minNode(node.right);
                node.data = minNode.data;
                node.right = remove(node.right, minNode.data);
            }
        }
        return node;
    }

    public Node minNode(Node node){
        while(node.left != null) node = node.left;
        return node;
    }

    public int height(Node node){
        if(node == null) return 0;
        else{
            int height = Math.max(height(node.left), height(node.right))+1;
            return height;
        }
    }




}
