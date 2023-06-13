package tree;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class maxHeap {
    
    List<Integer> heap=new ArrayList<>();


    public  maxHeap(List<Integer> array){

        buildHeap(array);
    }

    public void buildHeap(List<Integer> array){

        heap=array;
        for (int i =parent(heap.size()-1) ; i >=0; i--) {
            heapfiydown(i);
        }
    }


    public void heapfiydown(int i){
        int left=left(i);
        int right=right(i);
        int current=i;
        if (left<heap.size() && heap.get(current)<heap.get(left)) {
            current=left;
        }
        if (right<heap.size() && heap.get(current)<heap.get(right)) {
            current=right;
        }
        if (current!=i) {
            Collections.swap(heap, i, current);
            heapfiydown(current);
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


    public void heapfiyUp(int i){
        int child=i;
        int parent=parent(child);
        while (child>0 && heap.get(child)>heap.get(parent)) {
            Collections.swap(heap, child, parent);
            child=parent;
            parent=parent(child);

        }
    }
    public void insert(int data){
        heap.add(data);
    
        heapfiyUp(heap.size()-1);
    }


    public void remove(){
        int lastIdx=heap.size()-1;
        Collections.swap(heap, 0, lastIdx);
        heap.remove(lastIdx);
        heapfiydown(0);
    }

    public static void main(String[] args) {
        
        List<Integer> array= new ArrayList<>(Arrays.asList(3,44,23,42,43,34));
        maxHeap heap=new maxHeap(array);

        heap.insert(4334);
        heap.display();
        System.out.println("yefiuw");
        heap.remove();
        heap.display();
    }
}
