package com.github.erdragh.logicgates.nodes;

import java.util.ArrayList;

import com.github.erdragh.logicgates.INode;
import com.github.erdragh.logicgates.NodeProcessor;

public class NorNode implements INode<Boolean> {

    @Override
    public ArrayList<Boolean> process(ArrayList<Boolean> in) {
        // boolean temp = !in.get(0);
        // ArrayList<Boolean> tempList = new ArrayList<>();
        // tempList.add(temp);
        // return tempList;
        INode<Boolean>[] nodes = new INode[]{new OrNode(), new NotNode()};
        int[][] steps = {};
        NodeProcessor<Boolean> np = new NodeProcessor<Boolean>(nodes, steps);
        return np.process(in);
    }
    
}
