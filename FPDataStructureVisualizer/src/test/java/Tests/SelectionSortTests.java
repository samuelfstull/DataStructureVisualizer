package Tests;

import Algorithms.VisualizerSortsAndSearches;
import GUI.Visualization;
import GUI.Visualizer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSortTests {
    public static void main(String [] args) {
        ArrayList<Integer> integerList = new ArrayList<>(Arrays.asList(23,45,21,55,234,1,34,90));
        VisualizerSortsAndSearches sorts = new VisualizerSortsAndSearches();
        ArrayList<Visualization> actualVisualizations = sorts.selectionSort(integerList, 0);
        Visualizer visualizer = new Visualizer(actualVisualizations);
        visualize(visualizer);
    }

    private static void visualize(Visualizer visualizee) {
        visualizee.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        visualizee.setSize(800, 720);
        visualizee.setVisible(true);
    }
}
