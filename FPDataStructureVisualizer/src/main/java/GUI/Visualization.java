package GUI;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class Visualization {
    private String labelTitle;
    private List<Integer> integers;
    private List<Boolean> highlightedNodesInRed;
    private List<Boolean> highlightedNodesInGreen;

    //Initializes Visualization which has a label title, a list of integers, and a list of booleans that determines whether the nodes are highlighted or not.
    public Visualization(String labelTitle, ArrayList<Integer> integers) {
        this.labelTitle = labelTitle;
        this.integers = integers;
        highlightedNodesInRed = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            highlightedNodesInRed.add(false);
        }
        highlightedNodesInGreen = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            highlightedNodesInGreen.add(false);
        }
    }

    //Nodes can be highlighted by a list of indices or a singular index.
    public void highlightIndicesInRed(List<Integer> indices) {
        for (Integer index : indices) highlightIndexInRed(index);
    }

    //Highlights any given index that is displayable through an instance of the Visualizer class.
    public void highlightIndexInRed(int index) {
            highlightedNodesInRed.set(index, true);
    }

    public void highlightIndicesInGreen(List<Integer> indices) {
        for (Integer index : indices) highlightIndexInGreen(index);
    }

    //Highlights any given index that is displayable through an instance of the Visualizer class.
    public void highlightIndexInGreen(int index) {
            highlightedNodesInGreen.set(index, true);
    }

    public void unhighlightIndices(List<Integer> indices) {
        for (Integer index : indices) unhighlightIndex(index);
    }

    public void unhighlightIndex(int index) {
        if (highlightedNodesInRed.get(index)) {
            highlightedNodesInRed.set(index, false);
        } else if (highlightedNodesInGreen.get(index)) {
            highlightedNodesInGreen.set(index, false);
        }
    }

    public List<Boolean> getHighlightedNodesInRed() {
        return highlightedNodesInRed;
    }

    public List<Boolean> getHighlightedNodesInGreen() {
        return highlightedNodesInGreen;
    }

    public String getLabelTitle() {
        return labelTitle;
    }

    public List<Integer> getIntegers() {
        return integers;
    }
}
