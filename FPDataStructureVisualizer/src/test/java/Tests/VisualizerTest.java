package Tests;

import GUI.Visualization;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class VisualizerTest {
    @Test
    public void testStyleSpreadsheetInitialization() {
        Visualization visualizationOne = new Visualization("one",  new ArrayList<>(Arrays.asList(3, 5, 6, 10, 8, 4)));
        GUI.Visualizer visualizer = new GUI.Visualizer(Collections.singletonList(visualizationOne));
        mxGraph graph = visualizer.getGraph();
        mxStylesheet stylesheet = graph.getStylesheet();
        stylesheet.getStyles().get("defaultEdge").replace("endArrow", "classic", "none");
        String got = stylesheet.getStyles().get("defaultEdge").get("endArrow").toString();
        Assert.assertEquals("none", got);
    }

    @Test
    public void testHasChildrenCells() {
        Visualization visualizationOne = new Visualization("one",  new ArrayList<>(Arrays.asList(3, 5, 6, 10, 8, 4)));
        GUI.Visualizer visualizer = new GUI.Visualizer(Collections.singletonList(visualizationOne));
        mxGraph graph = visualizer.getGraph();
        Object parent = graph.getDefaultParent();
        Object [] children = graph.getChildCells(parent);
        Assert.assertNotNull(children);
    }

    @Test
    public void testHasExpectedAmountOfChildCells() {
        Visualization visualizationOne = new Visualization("one",  new ArrayList<>(Arrays.asList(3, 5, 6, 10, 8, 4)));
        GUI.Visualizer visualizer = new GUI.Visualizer(Collections.singletonList(visualizationOne));
        mxGraph graph = visualizer.getGraph();
        Object parent = graph.getDefaultParent();
        Object [] children = graph.getChildCells(parent);
        Assert.assertEquals((visualizationOne.getIntegers().size()) * 2, children.length);
    }

}
