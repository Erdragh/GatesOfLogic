package com.github.erdragh.logicgates.nodes;

import java.util.ArrayList;

import com.github.erdragh.logicgates.INode;

public class OrNode implements INode<Boolean> {

    @Override
    public ArrayList<Boolean> process(ArrayList<Boolean> in) {
        ArrayList<Boolean> tempList = new ArrayList<>();
        tempList.add((in.get(0) || in.get(1)));
        return tempList;
    }
    
}
