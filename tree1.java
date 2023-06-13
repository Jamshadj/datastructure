package tree;

public class tree1 {
    class Node{
        Node left,right;
        int data;

        Node(int data){
            this.data=data;
        }
    }

    Node root;

    public void addData(int data){
        Node newNode=new Node(data);
        Node current=root;
        while (true) {
            if (newNode.data<current.data) {
                if (current.left==null) {
                    current.left=newNode;
                    return;
                }else{
                    current=current.left;
                }
            }else{
                if (current.right==null) {
                    current.right=newNode;
                    return;
                }else{
                    current=current.right;
                }
            }
        }
    }
    
}
