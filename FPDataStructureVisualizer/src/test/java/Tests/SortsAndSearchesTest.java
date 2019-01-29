package Tests;

import Algorithms.HeapSort;
import Algorithms.QuickSort;
import Algorithms.SortsAndSearches;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;


public class SortsAndSearchesTest {
    @Test
    public void testLinearSearch() {
        final SortsAndSearches sortsAndSearches = new SortsAndSearches();
        ArrayList<Integer> arrayOne = new ArrayList<>(Arrays.asList(23,45,21,55,234,1,34,90));
        int searchKey = 55;
        int index = 3;
        int actual = sortsAndSearches.linearSearch(arrayOne, searchKey);
        Assert.assertEquals(index, actual);
    }//end of linear search test
    @Test
    public void testBinarySearch() {
        final SortsAndSearches sortsAndSearches = new SortsAndSearches();
        ArrayList<Integer> arrayOne = new ArrayList<>(Arrays.asList(23,45,21,55,234,1,34,90));
        int key = 55;
        int start = 0;
        int end = arrayOne.size();
        int index = 3;
        int actual = sortsAndSearches.binarySearch(arrayOne, start, end, key);
        Assert.assertEquals(index, actual);
    }//end of Binary search test
    @Test
    public void TestSelectionSort(){
        SortsAndSearches sorting = new SortsAndSearches();
        ArrayList<Integer> outputList = new ArrayList<>(Arrays.asList(23,45,21,55,234,1,34,90));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 21, 23, 34, 45, 55, 90, 234));
        outputList=sorting.SelectionSort(outputList,0);
        Assert.assertEquals(outputList, testList);

    }//end of selection test
    @Test
    public void TestBubbleSort(){
        SortsAndSearches sorting = new SortsAndSearches();
        ArrayList<Integer> outputList = new ArrayList<>(Arrays.asList(23,45,21,55,234,1,34));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 21, 23, 34, 45, 55, 234));
        outputList=sorting.BubbleSort(outputList,outputList.size());
        Assert.assertEquals(outputList, testList);

    }//end of bubble test
    @Test
    public void TestInsertionSort(){
        SortsAndSearches sorting = new SortsAndSearches();
        ArrayList<Integer> outputList = new ArrayList<>(Arrays.asList(23,45,21,55,234,1,34));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 21, 23, 34, 45, 55, 234));
        sorting.InsertionSort(outputList,outputList.size());
        Assert.assertEquals(outputList, testList);
    }//end of insertion test
    @Test
    public void TestQuickSort() {
        QuickSort quickSort = new QuickSort();
        ArrayList<Integer> outputList = new ArrayList<>(Arrays.asList(95,23,1,12,56,34,76,44,20));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1,12,20,23,34,44,56,76,95));
        outputList=quickSort.quickSort(outputList);
        Assert.assertEquals(outputList, testList);
    }//end of quick test
    @Test
    public void TestHeapSort(){
        HeapSort sorting = new HeapSort();
        ArrayList<Integer> outputList = new ArrayList<>(Arrays.asList(23,45,21,55,234,1,34));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 21, 23, 34, 45, 55, 234));
        sorting.HeapSorting(outputList);
        Assert.assertEquals(outputList, testList);
    }//end of heap test

    @Test
    public void testSelectionSortReturnsVisualizationList() {


    }
}

