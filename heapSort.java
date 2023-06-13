package tree;

import java.util.Arrays;

public class heapSort {
    
    public void array(int[] array) {
        int n = array.length;
        
        for (int i = parent(n - 1); i >= 0; i--) {
            heapifyDown(array, i, n);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            heapifyDown(array, 0, i);
        }
    }
    
    public void heapifyDown(int[] array, int i, int n) {
        int parent = i;
        int left = left(i);
        int right = right(i);
        
        if (left < n && array[parent] < array[left]) {
            parent = left;
        }
        
        if (right < n && array[parent] < array[right]) {
            parent = right;
        }
        
        if (parent != i) {
            int change = array[i];
            array[i] = array[parent];
            array[parent] = change;
            
            heapifyDown(array, parent, n);
        }
    }
    
    public int parent(int i) {
        return (i - 1) / 2;
    }
    
    public int left(int i) {
        return 2 * i + 1;
    }
    
    public int right(int i) {
        return 2 * i + 2;
    }
    
    public static void main(String args[]) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        heapSort heapSort = new heapSort();
        heapSort.array(arr);

        System.out.println(Arrays.toString(arr));
    }
}
