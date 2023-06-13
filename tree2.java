package tree;


public class tree2 {
    
    class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    Node root;

    public void insert(int data){
        
       root= insertHelper(root, data);
    }

    public Node insertHelper(Node current,int data){

        Node newNode=new Node(data);
        if (current==null) {
            return new Node(data);
        }
        if (data<current.data) {
           current.left= insertHelper(current.left, data);
        }else{
           current.right= insertHelper(current.right, data);
        }
        return current;
        
    }

    public void inOrder(){
        inOrderDisplayHelper(root);
    }

    public void inOrderDisplayHelper(Node current){
        if (current==null) {
            return;
        }
        inOrderDisplayHelper(current.left);
        System.out.println(current.data);
        inOrderDisplayHelper(current.right);
    }


    public void remove(int data){

        root=removeHelper(data, root);
    }
    public Node removeHelper(int data,Node current){

        if (current==null) {
            return null;
        }
        if (data<current.data) {
            current.left=removeHelper(data, current.left);
        } else if (data>current.data) {
            current.right=removeHelper(data, current.right);
        }else{
          if(current.right==null && current.left==null){
            current=null;
          }else if (current.left==null) {
            current=current.right;
          }else if(current.right==null){
            current=current.left;
          }else{
            Node temp=min(current.left);
            current.data=temp.data;
           current.left= removeHelper(temp.data, current.left);
          }
        } 
        return current;
    }
    public Node min(Node current){
      while (current.right!=null) {
        current=current.right;
      }
      return current;
    }


    public void contain(int dat){
    
        containsHelper(dat, root);
    }

    public void containsHelper(int data,Node current){
        if (current==null) {
            return;
        }
        if (data==current.data) {
            System.out.println("contains");
            return;
        }else if(data<current.data){
            containsHelper(data, current.left);
        }else if (data>current.data) {
           containsHelper(data, current.right); 
        }
    }


    public static void main(String[] args) {
        tree2  list=new tree2();
        list.insert(10);
        list.insert(9);
        list.insert(11);
        list.insert(8);
        list.insert(12);
        list.insert(13);
 

        list.contain(10);
        list.inOrder();
    }
}
