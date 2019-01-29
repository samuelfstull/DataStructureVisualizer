package GUI;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import javax.swing.*;
import java.util.List;
@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class Visualizer extends JFrame {
    private final int ROOT_X_COORDINATE = 50;
    private final int ROOT_Y_COORDINATE = 60;
    private final int CELL_WIDTH = 80;
    private final int CELL_HEIGHT = 30;
    private final int VERTICAL_CELL_PADDING = 140;
    private mxGraph graph;

    public Visualizer(List<Visualization> data) {
       super("Visualization Visualizer");
       mxStylesheet stylesheet = arrowlessStylesheet();
       graph = new mxGraph(stylesheet);
       Object parent = graph.getDefaultParent();
       plotVerticesAndEdges(data, parent);
       //Display Visualizer on screen
       mxGraphComponent graphComponent = new mxGraphComponent(graph);
       graphComponent.setEnabled(false);
       getContentPane().add(graphComponent);
    }

    private mxStylesheet arrowlessStylesheet() {
        mxStylesheet stylesheet = new mxStylesheet();
        stylesheet.getStyles().get("defaultEdge").replace("endArrow", "classic", "none");
        return stylesheet;
    }

    private void plotVerticesAndEdges(List<Visualization> data, Object parent) {
        graph.getModel().beginUpdate();
        try {
            for (int i = 0; i < data.size(); i++) {
                Visualization visualization = data.get(i);
                Object lastVertex = makeFirstVertex(parent, i, visualization);
                for (int j = 1; j < visualization.getIntegers().size(); j++) {
                    Object newVertex = makeLaterVertex(parent, i, visualization, j);
                    graph.insertEdge(parent, null, "", newVertex, lastVertex);
                    lastVertex = newVertex;
                }
            }
        } finally {
            graph.getModel().endUpdate();
        }
    }

    private Object makeFirstVertex(Object parent, int i, Visualization visualization) {
        int HORIZONTAL_CELL_PADDING = 172;
        graph.insertVertex(parent, null, visualization.getLabelTitle(), visualization.getIntegers().size()/2 * HORIZONTAL_CELL_PADDING, 20 + i * VERTICAL_CELL_PADDING, CELL_WIDTH, CELL_HEIGHT);
        Object lastVertex;
        if (visualization.getHighlightedNodesInRed().get(0)) {
            lastVertex = graph.insertVertex(parent, null, visualization.getIntegers().get(0), ROOT_X_COORDINATE,
                    ROOT_Y_COORDINATE + i * VERTICAL_CELL_PADDING, CELL_WIDTH, CELL_HEIGHT, "rounded;fillColor=red");
        } else if (visualization.getHighlightedNodesInGreen().get(0)) {
            lastVertex = graph.insertVertex(parent, null, visualization.getIntegers().get(0), ROOT_X_COORDINATE,
                    ROOT_Y_COORDINATE + i * VERTICAL_CELL_PADDING, CELL_WIDTH, CELL_HEIGHT, "rounded;fillColor=green");
        } else {
            lastVertex = graph.insertVertex(parent, null, visualization.getIntegers().get(0), ROOT_X_COORDINATE,
                    ROOT_Y_COORDINATE + i * VERTICAL_CELL_PADDING, CELL_WIDTH, CELL_HEIGHT);
        }
        return lastVertex;
    }

    private Object makeLaterVertex(Object parent, int i, Visualization visualization, int j) {
        Object newVertex;
        int HORIZONTAL_CELL_PADDING = 160;
        if (visualization.getHighlightedNodesInRed().get(j)) {
            newVertex = graph.insertVertex(parent, null, visualization.getIntegers().get(j), ROOT_X_COORDINATE + j * HORIZONTAL_CELL_PADDING,
                    ROOT_Y_COORDINATE + i * VERTICAL_CELL_PADDING, CELL_WIDTH, CELL_HEIGHT, "rounded;fillColor=red");
        } else if (visualization.getHighlightedNodesInGreen().get(j)) {
            newVertex = graph.insertVertex(parent, null, visualization.getIntegers().get(j), ROOT_X_COORDINATE + j * HORIZONTAL_CELL_PADDING,
                    ROOT_Y_COORDINATE + i * VERTICAL_CELL_PADDING, CELL_WIDTH, CELL_HEIGHT, "rounded;fillColor=green");
        } else {
            newVertex = graph.insertVertex(parent, null, visualization.getIntegers().get(j), ROOT_X_COORDINATE + j * HORIZONTAL_CELL_PADDING,
                    ROOT_Y_COORDINATE + i * VERTICAL_CELL_PADDING, CELL_WIDTH, CELL_HEIGHT);
        }
        return newVertex;
    }
    public mxGraph getGraph() {
        return graph;
    }
}