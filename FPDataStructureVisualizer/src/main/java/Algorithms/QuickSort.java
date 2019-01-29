package Algorithms;

import java.util.ArrayList;

/*
 * This class HeapSorting integer arraylists using a recursive quicksort algorithm
 * Recursive quicksort algorithm, partitioned arraylist into two parts by pivot,
 * and then recursively sorts each arraylist
 * Much credit goes to @author Javin Paul.
 */
@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class QuickSort {
    ArrayList<ArrayList<Integer>> listOfArrayListQuick = new ArrayList<>();
    ArrayList<Integer> cloningArrayList = new ArrayList<>();

    public ArrayList<Integer> quickSort(ArrayList<Integer> aryList) {
        recursiveQuickSort(aryList, 0, aryList.size() - 1);
        listOfArrayListQuick.add(aryList);
        return aryList;
    }

    private void recursiveQuickSort(ArrayList<Integer> aryList, int startIdx, int endIdx) {
        int idx = partition(aryList, startIdx, endIdx);

        //recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            cloningArrayList =(ArrayList<Integer>)aryList.clone();
            listOfArrayListQuick.add(cloningArrayList);
            recursiveQuickSort(aryList, startIdx, idx - 1);
        }

        //recursively call quicksort with right part of the partitioned array
        if (endIdx > idx) {
            cloningArrayList =(ArrayList<Integer>)aryList.clone();
            listOfArrayListQuick.add(cloningArrayList);
            recursiveQuickSort(aryList, idx, endIdx);
        }
    }

    private static int partition(ArrayList<Integer> aryList, int left, int right) {
        int pivot = aryList.get(left); //taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (aryList.get(left) < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (aryList.get(right) > pivot) {
                right--;
            }

            //swap the values
            if (left <= right) {
                int temp = aryList.get(left);
                aryList.set(left, aryList.get(right));
                aryList.set(right, temp);

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }

    public ArrayList<ArrayList<Integer>> getListOfArrayListQuick() {
        return listOfArrayListQuick;
    }
}