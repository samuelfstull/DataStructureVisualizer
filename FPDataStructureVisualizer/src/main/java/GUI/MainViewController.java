package GUI;

import Algorithms.HeapSort;
import Algorithms.QuickSort;
import Algorithms.SortsAndSearches;
import Algorithms.VisualizerSortsAndSearches;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class MainViewController {
    @FXML private TextField searchInput;
    @FXML private TextField searchTokenInput;
    @FXML private TextField sortInput;
    @FXML private TextArea sortInfoBox;
    @FXML private TextArea searchInfoBox;
    SortsAndSearches sorter = new SortsAndSearches();
    QuickSort quickSort = new QuickSort();
    private ArrayList<Visualization> quickVisualizations = new ArrayList<>();
    HeapSort heapSort = new HeapSort();
    private ArrayList<Visualization> heapVisualizations = new ArrayList<>();


    public void displayArray(){
        ArrayList<Integer> userArrayList = stringToArrayList(sortInput);
        Visualization unsortedVisualizations = new Visualization("Unsorted", (ArrayList<Integer>) userArrayList.clone());
        ArrayList<Integer> sortedArrayList = (ArrayList<Integer>) userArrayList.clone();
        sorter.SelectionSort(sortedArrayList, 0);
        Visualization sortedVisualizations = new Visualization("Sorted", (ArrayList<Integer>) sortedArrayList.clone());
        ArrayList<Visualization> visualizations = new ArrayList<>(Arrays.asList(unsortedVisualizations, sortedVisualizations));
        Visualizer frame = new Visualizer(visualizations);
        visualize(frame);
    }

    private void visualize(Visualizer frame) {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void binarySearch() {
        Integer key;
        ArrayList<Integer> integers = stringToArrayList(searchInput);
        String tokenString = searchTokenInput.getText();
        VisualizerSortsAndSearches sorts = new VisualizerSortsAndSearches();
        try{
            key = Integer.parseInt(tokenString);
        } catch (NumberFormatException e){
            MainViewController.infoBox("Enter search term", "NOTICE!");
            return;
        }

        integers = sorter.SelectionSort(integers, 0);
        try{
            ArrayList<Visualization> actualVisualizations = sorts.binarySearch(integers, 0, integers.size() - 1, key);
            visualize(new Visualizer(actualVisualizations));
        } catch (Exception e){
            MainViewController.infoBox("Search token not found. Please enter new token.", "NOTICE!");
        }

    }

    public void linearSearch() {
        Integer key;
        ArrayList<Integer> integers = stringToArrayList(searchInput);
        String tokenString = searchTokenInput.getText();
        List<Visualization> visualizations = new ArrayList<>();
        try{
            key = Integer.parseInt(tokenString);
        } catch (NumberFormatException e){
            MainViewController.infoBox("Enter search term", "NOTICE!");
            return;
        }
        int soughtAfterIndex = sorter.linearSearch(integers, key);
        if (soughtAfterIndex == -20) {
            MainViewController.infoBox("Search token not found. Please enter new token.", "NOTICE!");
        }
        else {
            for (int i = 0; i <= soughtAfterIndex; i++) {
                String label = String.format("Step %d", i + 1);
                Visualization visualization = new Visualization(label, integers);
                if (i == soughtAfterIndex) {
                    visualization.highlightIndexInGreen(i);
                } else {
                    visualization.highlightIndexInRed(i);
                }
                visualizations.add(visualization);
            }
            Visualizer frame = new Visualizer(visualizations);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }
    }

    public void visualizeSelectionSort(){
        VisualizerSortsAndSearches sorts = new VisualizerSortsAndSearches();
        ArrayList<Integer> integers = stringToArrayList(sortInput);
        ArrayList<Visualization> actualVisualizations = sorts.selectionSort(integers, 0);
        Visualizer frame = new Visualizer(actualVisualizations);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void visualizeBubbleSort(){
        VisualizerSortsAndSearches sorts = new VisualizerSortsAndSearches();
        ArrayList<Integer> integers = stringToArrayList(sortInput);
        ArrayList<Visualization> actualVisualizations = sorts.BubbleSort(integers, integers.size());
        Visualizer frame = new Visualizer(actualVisualizations);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void visualizeInsertionSort() {
        VisualizerSortsAndSearches sorts = new VisualizerSortsAndSearches();
    ArrayList<Integer> integers = stringToArrayList(sortInput);
    ArrayList<Visualization> actualVisualizations = sorts.InsertionSort(integers, integers.size());
    Visualizer frame = new Visualizer(actualVisualizations);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void visualizeQuickSort(){
        ArrayList<Integer> integers = stringToArrayList(sortInput);
        quickSort.quickSort(integers);
        ArrayList<ArrayList<Integer>> quickList = quickSort.getListOfArrayListQuick();
        for(int counter=0;counter<quickList.size();counter++ ) {
            Visualization currentStepSnapshot = new Visualization(String.format("Step %d", counter+1), quickList.get(counter));
            quickVisualizations.add(currentStepSnapshot);
        }
            Visualizer frame = new Visualizer(quickVisualizations);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);

    }

    public void visualizeHeapSort(){
        ArrayList<Integer> integers = stringToArrayList(sortInput);
        heapSort.HeapSorting(integers);
        ArrayList<ArrayList<Integer>> heapList = heapSort.getListOfArrayListHeap();
        for(int counter=0;counter<heapList.size();counter++ ) {
            Visualization currentStepSnapshot = new Visualization(String.format("Step %d", counter+1), heapList.get(counter));
            heapVisualizations.add(currentStepSnapshot);
        }
        Visualizer frame = new Visualizer(heapVisualizations);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }

    private ArrayList<Integer> stringToArrayList(TextField textField){
        ArrayList<Integer> tokens = new ArrayList<>();

        try{
            String userInput = textField.getText();
            Scanner scanner = new Scanner(userInput);
            scanner.useDelimiter("[,]");

            while (scanner.hasNext()){
                String string = scanner.next();
                string = string.replace(" ", "");
                string = string.replace("{", "");
                string = string.replace("}", "");
                string = string.replace(" ", "");
                string = string.replaceAll("\\p{P}", "");
                int integer = Integer.parseInt(string);
                tokens.add(integer);
            }
        } catch (Exception e){
            MainViewController.infoBox("Invalid input", "NOTICE!");
            return tokens;
        }
        if (tokens.size() == 0){
            MainViewController.infoBox("Enter array", "NOTICE!");
        }
        return tokens;
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public void displaySelectionSortInfo(){
        sortInfoBox.setText("Selection sort works by finding the smallest element in the array and putting it at " +
                "the beginning of the list and then repeating that process on the unsorted remainder of the data.");
    }

    public void displayBubbleSortInfo(){
        sortInfoBox.setText("Bubble sort repeatedly steps through the list to be sorted, compares each " +
                "pair of adjacent items and swaps them if they are in the wrong order");
    }

    public void displayInsertionSortInfo(){
        sortInfoBox.setText("Insertion sort iterates, consuming one input element each repetition, " +
                "and growing a sorted output list. At each iteration, insertion sort removes one " +
                "element from the input data, finds the location it belongs within the sorted list, " +
                "and inserts it there. It repeats until no input elements remain.");
    }

    public void displayQuickSortInfo(){
        sortInfoBox.setText("Quick sort first divides a large array into two smaller sub-arrays: the low " +
                "elements and the high elements. Quick sort can then recursively sort the sub-arrays.");
    }

    public void displayHeapSortInfo(){
        sortInfoBox.setText("Heapsort sorts an array by first converting the array into a heap. It then sorts" +
                " the data in reverse by repeatedly placing the largest unsorted element into its correct place. ");
    }

    public void displayBasicSortInfo(){
        sortInfoBox.setText("Displays the unsorted and sorted arrays");
    }

    public void displayLinearSearchInfo(){
        searchInfoBox.setText("Linear search sequentially checks each element of the list for the target " +
                "value until a match is found or until all the elements have been searched.");
    }

    public void displayBinarySearchInfo(){
        searchInfoBox.setText("Binary search compares the target value to the middle element of the array; " +
                "if they are unequal, the half in which the target cannot lie is eliminated and the search" +
                " continues on the remaining half until it is successful. If the search ends with the remaining" +
                " half being empty, the target is not in the array.");
    }
}
