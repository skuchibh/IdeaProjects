package trees;

/**
 * Created by Surya Vamsi on 24-Mar-15.
 */
public class BST<Key extends Comparable<Key>,Value> {static int counter;
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;
        public Node(int n){left=null;right=null;}
        public Node(Key key,Value val,int N){
            this.key=key;this.val=val;this.N=N;
        }
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null)return 0;
        else return x.N;
    }
    public boolean contains(Key key){
        return (get(key)!=null);
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        if(x==null)return null;
        int cmp=key.compareTo(x.key);
        if(cmp>0)return get(x.left,key);
        else if(cmp<0)return get(x.right,key);
        else return x.val;
    }
    public void put(Key key,Value val){
        if(val==null) {return;}
        root=put(root,key,val);

    }
    private Node put(Node x,Key key,Value val){

        if(x==null)return new Node(key,val,1);
        int cmp=key.compareTo(x.key);
        if(cmp>0)   x.left=put(x.left,key,val);
        else if(cmp<0)x.right=put(x.right,key,val);
        else x.val=val;

        x.N=1+size(x.left)+size(x.right);return x;
    }

    public int counter(){
        return counter;
    }

}
