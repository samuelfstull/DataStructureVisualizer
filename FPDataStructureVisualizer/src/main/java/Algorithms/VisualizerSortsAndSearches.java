package Algorithms;

import GUI.Visualization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class VisualizerSortsAndSearches {
    private ArrayList<Visualization> binaryVisualizations = new ArrayList();
    ArrayList<Integer> holdingList = new ArrayList<>();
    ArrayList<Integer> cloningArrayList = new ArrayList<>();
    private ArrayList<Visualization> bubbleVisualizations = new ArrayList<>();
    private ArrayList<Visualization> insertionVisualizations = new ArrayList<>();
    private int binaryCounter = 0;
    public ArrayList<Visualization> binarySearch(ArrayList<Integer> aryList, int start, int end, int key) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            Visualization currentStepSnapshot = new Visualization(String.format("Step %d", ++binaryCounter), aryList);
            currentStepSnapshot.highlightIndicesInRed(Arrays.asList(start, end));
            binaryVisualizations.add(currentStepSnapshot);
            if (key < aryList.get(mid)) {
                return binarySearch(aryList, start, mid, key);
            }
            else if (key > aryList.get(mid)) {
                return binarySearch(aryList, mid, end, key);
            } else {
                Visualization midVisualization = new Visualization("Step " + ++binaryCounter, aryList);
                midVisualization.highlightIndexInRed(mid);
                binaryVisualizations.add(midVisualization);
                return binaryVisualizations;
            }
        }
        return null;
    }

    private ArrayList<Visualization> selectionVisualizations = new ArrayList();
    public ArrayList<Visualization> selectionSort(ArrayList<Integer> integers, int startIndex) {
        String title = String.format("Step %d", startIndex + 1);
        Visualization currentVisualization = new Visualization(title, copyIntegers(integers));
        if (startIndex >= integers.size() - 1) { //if sorted
            for (int i = 0; i < integers.size(); i++) {
                currentVisualization.highlightIndexInGreen(i);
            }
            selectionVisualizations.add(currentVisualization);
        } else { //if at least partially unsorted
            int minIndex = startIndex;
            for (int i = 0; i < minIndex; i++) {
                currentVisualization.highlightIndexInGreen(i); //highlight sorted part Green
            }
            for (int index = startIndex + 1; index < integers.size(); index++) {
                if (integers.get(index) < integers.get(minIndex)) {
                    minIndex = index;
                }
            }
            currentVisualization.highlightIndexInRed(minIndex);
            int temp = integers.get(startIndex);
            integers.set(startIndex, integers.get(minIndex));
            integers.set(minIndex, temp);
            selectionVisualizations.add(currentVisualization);
            selectionSort(integers, startIndex + 1);
            }
            return selectionVisualizations;
    }

    private ArrayList<Integer> copyIntegers(ArrayList<Integer> ancestralIntegers) {
        return (ArrayList<Integer>) ancestralIntegers.clone();
    }

    int bubbleCounter=0;
    public ArrayList<Visualization> BubbleSort(ArrayList<Integer> aryList, int maxValue) {
        // Base case
        int counter=0;

        if (maxValue == 1)
            return bubbleVisualizations;
        for (int index=0; index < maxValue - 1; index++) {
            holdingList = aryList;
            if (aryList.get(index) > aryList.get(index + 1)) {
                int temp = aryList.get(index);
                aryList.set(index, aryList.get(index + 1));
                aryList.set(index + 1, temp);
            }
            Visualization currentStepSnapshot = new Visualization(String.format("Step %d", ++bubbleCounter), holdingList);
            if (counter+1>aryList.size()){
                counter=0;
            }
            else {
                currentStepSnapshot.highlightIndicesInRed(Arrays.asList(counter, counter+1));
                counter++;
            }
            bubbleVisualizations.add(currentStepSnapshot);
        }
        BubbleSort(aryList, maxValue - 1);

        return bubbleVisualizations;
    }//end of bubble


    public ArrayList<Visualization> InsertionSort(ArrayList<Integer> aryList, int maxValue)
    {
        if (maxValue <= 1)
            return insertionVisualizations;
        InsertionSort( aryList, maxValue-1 );
        int last = aryList.get(maxValue-1);
        int j = maxValue-2;
        while (j >= 0 && aryList.get(j) > last)
        {
            aryList.set(j+1, aryList.get(j));
            j--;
        }
        aryList.set(j+1,last);
        cloningArrayList = (ArrayList<Integer>)aryList.clone();
        Visualization currentStepSnapshot = new Visualization(String.format("Step %d", ++bubbleCounter), cloningArrayList);
        currentStepSnapshot.highlightIndicesInRed(Collections.singletonList(j + 1));
        insertionVisualizations.add(currentStepSnapshot);
        return insertionVisualizations;
    }//end of Insertion HeapSorting


}
