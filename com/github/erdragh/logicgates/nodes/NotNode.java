package com.github.erdragh.logicgates.nodes;

import java.util.ArrayList;

import com.github.erdragh.logicgates.INode;

public class NotNode implements INode<Boolean> {

    @Override
    public ArrayList<Boolean> process(ArrayList<Boolean> in) {
        boolean temp = !in.get(0);
        ArrayList<Boolean> tempList = new ArrayList<>();
        tempList.add(temp);
        return tempList;
    }
    
}
