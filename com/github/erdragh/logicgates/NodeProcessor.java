package com.github.erdragh.logicgates;

import java.util.ArrayList;

public class NodeProcessor<T> {
    private INode<T>[] nodes;
    private int[][] steps;

    public NodeProcessor(INode<T>[] nodes, int[][] steps) {
        this.nodes = nodes;
        this.steps = steps;
    }

    public ArrayList<T> process(ArrayList<T> in) {
        //This is a list used to store the values between steps and in the end return the values
        ArrayList<T> save = in;
        // Loops through each step in the steps array to process them
        for (int i = 0; i < steps.length; i++) {
            //Storing the currently base index for values for the current step and the current node
            int valueIndexBase = 0;
            //initiating the actual valueIndex as the baseIndex
            int valueIndex = valueIndexBase;
            //setting the node index based on what the current step is and to what node the current value should be sent (this is set via the steps array)
            int nodeIndex = steps[i][valueIndex];
            //A temporary array list to store the output values of the last step
            ArrayList<T> values = new ArrayList<>();
            //A temporary array list to store the output values of the current step
            ArrayList<T> nodeSave = new ArrayList<>();
            //looping through all values until it would reference a non existing value. this basically loops through all nodes
            while (valueIndexBase < save.size()) {
                //looping through each value while the value still references the same nodeIndex (basically loops through the entire list of values for a node)
                while (nodeIndex == steps[i][valueIndex]) {
                    //adds the values to the temporary array list to store them for later use
                    values.add(save.get(valueIndex));
                    //increases the valueIndex so the while loop can check the next position in the array, wether the value still references the same node
                    valueIndex++;
                }
                //uses the stored values in a node's process method. The node is selected via the nodeIndex which itself is selected via valueIndex in the steps array
                ArrayList<T> output = nodes[nodeIndex].process(values);
                //adds all the values from the current output into the save for use with a later step
                nodeSave.addAll(output);
                //resets the values array for use with the next node
                values = new ArrayList<>();
                //increases the base value index to the next value after the one currently used by the node. (This will begin the next loop for the next node)
                valueIndexBase = (valueIndex + 1);
                //sets the actual value Index to the new base index so the loop begins at the right place.
                valueIndex = valueIndexBase;
            }
            //Puts the output of the current step into the arrayList used for the input of the next step
            save = nodeSave;
            //resets the nodeSave ArrayList so the next step has a clean slate to start adding values to save.
            nodeSave = new ArrayList<>();
        }
        //returns the values after the last step has gone through
        return save;
    }
}
