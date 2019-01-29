package Algorithms;

import GUI.Visualization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class SortsAndSearches {
ArrayList<Object> listOfArrayListsSelection = new ArrayList<>();
ArrayList<Object> listOfArrayListBubble = new ArrayList<>();
ArrayList<Object> listOfArrayListInsertion = new ArrayList<>();
ArrayList<Integer> cloningArrayList = new ArrayList<>();
ArrayList<Object> listOfArrayListsLinearSearch = new ArrayList<>();

private ArrayList<Visualization> selectionVisualizations = new ArrayList();
private ArrayList<Visualization> bubbleVisualizations = new ArrayList();
private ArrayList<Visualization> insertionVisualizations = new ArrayList();
int selectionCounter = 0;
int bubbleCounter =0;
int insertionCounter=0;


    int linearSearchCounter = 0;
    public int linearSearch(ArrayList<Integer> aryList, int key) {
        for(int index=0; index<aryList.size(); index++) {
            if (aryList.get(index)==null){
                return 0;
            }
            else{
                if(aryList.get(index) == key){
                    return index;
                }
            }
            linearSearchCounter += 1;
        }
        return -20;
    }//end of linear search

    public int binarySearch(ArrayList<Integer> aryList, int start, int end, int key) {
        List<Integer> steps = new ArrayList<>();
        if (start < end) {
            int mid = start + (end - start) / 2;
            if (key < aryList.get(mid)) {
                return binarySearch(aryList, start, mid, key);
            }
            else if (key > aryList.get(mid)) {
                return binarySearch(aryList, mid+1, end, key);
            }
            else {
                return mid;
            }
        }
        return -(start + 1);
    }

    public ArrayList<Integer> SelectionSort(ArrayList<Integer> aryList, int startIndex)
    {
        if (startIndex >= aryList.size() - 1)
            return aryList;
        int minIndex = startIndex;
        for ( int index = startIndex + 1; index < aryList.size(); index++ )
        {
            if (aryList.get(index) < aryList.get(minIndex))
                minIndex = index;
        }
        int temp = aryList.get(startIndex);
        aryList.set(startIndex, aryList.get(minIndex));
        aryList.set(minIndex, temp);

        cloningArrayList =(ArrayList<Integer>)aryList.clone();
        listOfArrayListsSelection.add(cloningArrayList);
        SelectionSort(aryList, startIndex + 1);
        return aryList;
    }//end of selection HeapSorting

    public ArrayList<Integer> BubbleSort(ArrayList<Integer> aryList, int n)
    {
        // Base case
        if (n == 1)
            return aryList;
        for (int index=0; index<n-1; index++) {
            if (aryList.get(index) > aryList.get(index + 1)) {
                int temp = aryList.get(index);
                aryList.set(index, aryList.get(index + 1));
                aryList.set(index + 1, temp);
            }

            cloningArrayList = (ArrayList<Integer>) aryList.clone();
            System.out.println(cloningArrayList);
            listOfArrayListBubble.add(cloningArrayList);
        }
        BubbleSort(aryList, n-1);
        return aryList;
    }//end of bubble HeapSorting

    public void InsertionSort(ArrayList<Integer> aryList, int n)
    {
        if (n <= 1)
            return;
        InsertionSort( aryList, n-1 );
        int last = aryList.get(n-1);
        int j = n-2;
        while (j >= 0 && aryList.get(j) > last)
        {
            aryList.set(j+1, aryList.get(j));
            j--;
        }
        aryList.set(j+1,last);
        cloningArrayList = (ArrayList<Integer>) aryList.clone();
        listOfArrayListInsertion.add(cloningArrayList);
    }//end of Insertion HeapSorting

    public ArrayList<Object> getListOfArrayListsSelection() {
        return listOfArrayListsSelection;
    }//end of getListOfArrayListsSelection

    public ArrayList<Object> getListOfArrayListBubble() {
        return listOfArrayListBubble;
    }//end of getListOfArrayListBubble

    public ArrayList<Object> getListOfArrayListInsertion() {
        return listOfArrayListInsertion;
    }//end of getListOfArrayListInsertion

}