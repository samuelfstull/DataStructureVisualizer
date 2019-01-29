package Algorithms;

import java.util.ArrayList;
@SuppressWarnings({"WeakerAccess","unused","unchecked"})
public class HeapSort {


    ArrayList<ArrayList<Integer>> listOfArrayListHeap = new ArrayList<>();
    public void HeapSorting(ArrayList<Integer> aryList)
    {
        int size = aryList.size();

        for (int i = size / 2 - 1; i >= 0; i--)
            Heapify(aryList, size, i);


        for (int i=size-1; i>=0; i--)
        {
            // Move current root to end
            int temp = aryList.get(0);
            aryList.set(0,aryList.get(i));
            aryList.set(i,temp);
            Heapify(aryList, i, 0);
        }
        listOfArrayListHeap.add(aryList);
        //System.out.println(listOfArrayListHeap);
    }//end of HeapSorting

    private void Heapify(ArrayList<Integer> aryList, int length, int node){
        ArrayList<Integer> cloningArrayList;
        int largest = node;  // Initialize largest as root
        int l = 2*node + 1;  // left = 2*i + 1
        int r = 2*node + 2;  // right = 2*i + 2

        if (l < length && aryList.get(l) > aryList.get(largest))
            largest = l;

        if (r < length && aryList.get(r) > aryList.get(largest))
            largest = r;

        if (largest != node)
        {
            int swap = aryList.get(node);
            aryList.set(node, aryList.get(largest));
            aryList.set(largest, swap);

            cloningArrayList =(ArrayList<Integer>)aryList.clone();
            listOfArrayListHeap.add(cloningArrayList);
            //System.out.println(listOfArrayListHeap);
            Heapify(aryList, length, largest);
        }
    }//end of Heapify

    public ArrayList<ArrayList<Integer>> getListOfArrayListHeap() {
        return listOfArrayListHeap;
    }
}

