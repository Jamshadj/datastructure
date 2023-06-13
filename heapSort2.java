package tree;

import java.util.Arrays;

/**
 * heapSort2
 */
public class heapSort2 {

    public void display(int [] arr){
        int n=arr.length;
        for (int i = parent(arr.length-1); i>=0; i--) {
            buildHeap(i, arr,n);
        }
        for (int i = arr.length-1; i >0; i--) {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            buildHeap(0, arr,i);
        }
   
    }
    public void buildHeap(int i,int [] arr,int n){
        int parent=parent(i);
        int left=left(i);
        int right=right(i);
        if (left<arr.length && arr[parent]<arr[left]) {
            parent=left;
        }
        if (right<arr.length && arr[parent]<arr[right]) {
            parent=right;
        }
        if(parent!=i){
            int temp=arr[parent];
            arr[parent]=arr[i];
            arr[i]=temp;
            buildHeap(parent, arr,arr.length);
        }
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public int left(int i){
        return 2*i+1;
    }
    public int right(int i){
        return 2*i+2;
    }
    public static void main(String[] args) {
        int [] arr={21,32,4,23,3,322};
       heapSort2 heapSort2=new heapSort2();
       heapSort2.display(arr);
       System.out.println(Arrays.toString(arr));
    }
}