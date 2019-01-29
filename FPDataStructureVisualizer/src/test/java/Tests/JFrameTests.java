package Tests;

import Algorithms.VisualizerSortsAndSearches;
import GUI.Visualization;
import GUI.Visualizer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JFrameTests {
    //@Test asserts do not work while a JFrame window is open. I need to make each test a main method so that it will show what I want it to show on the screen.
    /*
    public static void main(String[] args) {
        Visualization visualizationOne = new Visualization("one",  new ArrayList<>(Arrays.asList(3, 5, 6, 10, 8, 4)));
        visualizationOne.highlightIndexInRed(2);
        Visualization visualizationTwo = new Visualization("two", new ArrayList<>(Arrays.asList(1, 3, 2, 9)));
        visualizationTwo.highlightIndexInRed(0);
        Visualization visualizationThree = new Visualization("three", new ArrayList<>(Arrays.asList(8, 6, 2, 3)));
        visualizationThree.highlightIndicesInRed(new ArrayList<>(Arrays.asList(0, 3)));
        ArrayList<Visualization> visualizations = new ArrayList<>(Arrays.asList(visualizationOne, visualizationTwo, visualizationThree));
        Visualizer frame = new Visualizer(visualizations);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 720);
        frame.setVisible(true);
    }
    */

    //IF BINARY SORT IS THE MIDDLE CASE
    public static void main(String[] args) {
        VisualizerSortsAndSearches visualizerSortsAndSearches = new VisualizerSortsAndSearches();
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8));
        ArrayList<Visualization> visualizations = visualizerSortsAndSearches.binarySearch(integers, 0, integers.size()-1, 4);
        Visualizer frame = new Visualizer(visualizations);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 720);
        frame.setVisible(true);
    }
}
