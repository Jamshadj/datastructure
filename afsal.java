package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class afsal {
    
    List<Integer> heap=new ArrayList<>();

    public afsal(List<Integer>  array){
        buildHeap(array);
    }

    public void buildHeap(List<Integer> array){
        heap=array;

        for (int i = parent(heap.size()-1); i >=0; i--) {
            heapifyDown(i);
        }
    }

    public void heapifyDown(int i){
        int left=left(i);
        int right=right(i);
        int largest=i;
        if (left<heap.size() && heap.get(largest)<heap.get(left)) {
            largest=left;
        }
        if (right<heap.size() && heap.get(largest)<heap.get(right)) {
            largest=right;
        }
        if(i!=largest){
            Collections.swap(heap, i, largest);
            heapifyDown(largest);
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

    public void display(){
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.get(i));
        }
    }
  public void heapifyUp(int data){

    int child=data;
    int parent=parent(data);

    while (child>0 && heap.get(child)>heap.get(parent)) {
        Collections.swap(heap, child, parent);
        child=parent;

        parent=parent(child);
    }
}

public void insert(int data){
    heap.add(data);
    heapifyUp(heap.size()-1);
}


public void remove(){
    int last=heap.size()-1;
    Collections.swap(heap, 0, last);
    heap.remove(last);
    heapifyDown(0);
}


    public static void main(String[] args) {
        List<Integer> array=new ArrayList<>(Arrays.asList(32,35,43,23,12,1,2,12));
        afsal heap= new afsal(array);
        heap.remove();
        heap.display();
    }

}
