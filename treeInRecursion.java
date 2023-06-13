package tree;

public class treeInRecursion {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    public void insert(int data) {
        root = insertHelper(root, data);
        
    }

    public Node insertHelper(Node root, int data) {
        if (root == null) {

            root = new Node(data);
            return root;

        }
        if (data < root.data) {
            root.left = insertHelper(root.left, data);
        } else {
            root.right = insertHelper(root.right, data);
        }
        return root;
    }

    public void inOrderDisplay() {
        inOrderDisplayHelper(root);
    }

    public void inOrderDisplayHelper(Node root) {
        if (root == null) {
            return;
        }
        inOrderDisplayHelper(root.left);
        System.out.println(root.data);
        inOrderDisplayHelper(root.right);
    }

    public void preOrderDisplay() {
        preOrderHelper(root);
    }

    public void preOrderHelper(Node root) {
        if (root==null) {
            return;
        }
        System.out.println(root.data);
        preOrderHelper(root.left);
        preOrderHelper(root.right);
    }

    public void postOrderDisplay() {
        postOrderHelper(root);
    }

    public void postOrderHelper(Node root) {
        if (root==null) {
            return;
        }
       
      
        postOrderHelper(root.left);
        postOrderHelper(root.right);
        System.out.println(root.data);

    }


    public void coaints(int data){
        containsHelper(data,root);
    }
    public void containsHelper(int data,Node root){
        if (root==null) {
            System.out.println("not data found");
            return;
        }
        if (root.data==data) {
            System.out.println("cointains");
            return;
        }
       
        if (data<root.data) {
            containsHelper(data, root.left);
        }else{
            containsHelper(data, root.right);
        }
    }


    public void remove(int data){
     root= removeHelper(data, root);
    } 
    public Node removeHelper(int data,Node root){
        if (root==null) {
            return null;
        }
        if (data<root.data) {
           root.left= removeHelper(data, root.left);
        }else if (data>root.data) {
           root.right= removeHelper(data, root.right);
        }else{
            if (root.right==null&&root.left==null) {
                root=null;
            }else if (root.right==null) {
                root=root.left;
            }else if (root.left==null) {
                root=root.right;
            }else{
                Node temp=findMinimum(root.left);
                root.data=temp.data;
                root.left=removeHelper(temp.data, root.left);
            }
        }
        return root;
    }
    public  Node findMinimum(Node root){
        while (root.right!=null) {
            root=root.right;
        } return root;
    }


    public int findClosest(int data){
        Node current=root;
        int clostest=current.data;
        while (current!=null) {
            if (Math.abs(clostest-data)>Math.abs(current.data-data)) {
                clostest=current.data;
            }
            if (data<current.data) {
                current=current.left;
            } else if (data>current.data) {
                current=current.right;
            } else{
               return clostest; 
            }
        }
        return clostest;
    }

    public static void main(String[] args) {
        treeInRecursion list = new treeInRecursion();
        list.insert(10);
        list.insert(9);
        list.insert(11);
        list.insert(8);
        list.insert(12);
        list.insert(13);
       list.inOrderDisplay();
      
        System.out.println(list.findClosest(14));
       
        
    }

}

