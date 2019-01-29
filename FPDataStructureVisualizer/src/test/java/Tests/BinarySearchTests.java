package Tests;

import Algorithms.VisualizerSortsAndSearches;
import GUI.Visualization;
import GUI.Visualizer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTests {
    public static void main(String[] args) {
        //test data as integer list
        ArrayList<Integer> integerList = new ArrayList<>(Arrays.asList(10, 30, 60, 80, 100, 120, 140, 200, 250));

        /*
        //SHOW EXPECTED VISUALIZATION. TURN ON IF YOU NEED TO COMPARE.
        Visualization firstExpectedVisualization = new Visualization("Step 1", integerList);
        firstExpectedVisualization.highlightIndicesInRed(Arrays.asList(0, 8));

        Visualization secondExpectedVisualization = new Visualization("Step 2", integerList);
        secondExpectedVisualization.highlightIndicesInRed(Arrays.asList(4, 8));

        Visualization thirdExpectedVisualization = new Visualization("Step 3", integerList);
        thirdExpectedVisualization.highlightIndicesInRed(Arrays.asList(6, 8));

        Visualization fourthExpectedVisualization = new Visualization("Step 4", integerList);
        fourthExpectedVisualization.highlightIndexInRed(7);

        ArrayList<Visualization> expectedVisualizations = new ArrayList<>();
        expectedVisualizations.add(firstExpectedVisualization);
        expectedVisualizations.add(secondExpectedVisualization);
        expectedVisualizations.add(thirdExpectedVisualization);
        expectedVisualizations.add(fourthExpectedVisualization);
        Visualizer asExample = new Visualizer(expectedVisualizations);
        visualize(asExample);
        */

        //SHOW ACTUAL VISUALIZATION OF ACTUAL BINARY SEARCH VISUALIZATIONS.

        VisualizerSortsAndSearches sorts = new VisualizerSortsAndSearches();
        ArrayList<Visualization> actualVisualizations = sorts.binarySearch(integerList, 0, integerList.size() - 1, 80);
        visualize(new Visualizer(actualVisualizations));
    }

    private static void visualize(Visualizer visualizee) {
        visualizee.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        visualizee.setSize(800, 720);
        visualizee.setVisible(true);
    }


}
