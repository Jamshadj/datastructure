package tree;

import java.util.Arrays;

public class hello {
    
    public void  heapSort(int [] arr){
        int n=arr.length-1;
        for (int i = parent(n); i>=0; i--) {
            heapifyDown(arr, i, n);
        }

        for (int i = n-1; i >0; i--) {
            int temp=arr[0];
            arr[0]=arr[n];
            arr[n]=temp;
            heapifyDown(arr, 0, i);
        }
    }
    public void heapifyDown(int [] arr,int i,int n){
        int left=left(i);
        int right=right(i);
        int largest=i;
        if (left<n && arr[largest]<arr[left]) {
            largest=left;
        }
        if (right<n && arr[largest]<arr[right]) {
            largest=right;
        }
        if (largest!=i) {
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapifyDown(arr, largest, n);
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
        hello sort=new hello();
        int [] arr={1,2,23,32,42,32};
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
