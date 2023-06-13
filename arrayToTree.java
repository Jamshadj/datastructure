package tree;

/**
 * arrayToTree
 */
public class arrayToTree {

    class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    Node root;
    public void addData(int [] arr){
        
      for (int i = 0; i < arr.length; i++) {
        Node newNode=new Node(arr[i]);
            if(root==null){
                root=newNode;
            }else{
                Node current=root;
                while (true) {
                 
                    if (newNode.data<current.data) {
                        if (current.left==null) {
                            current.left=newNode;
                            break;
                        }else{
                            current=current.left;
                        }
                    }else{
                        if (current.right==null) {
                            current.right=newNode;
                            break;
                        }else{
                            current=current.right;
                        }
                    }
                }
              
            }
        
      }
    }


    public static void main(String[] args) {
        arrayToTree list=new arrayToTree();
        int arr[]={32,242,32,434,4,4,3,43};
        list.addData(arr);
        
    }
}