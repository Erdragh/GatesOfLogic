package com.github.erdragh.logicgates;

import com.github.erdragh.logicgates.nodes.NotNode;
import com.github.erdragh.logicgates.nodes.OrNode;

public class Nodes {
    public static INode<Boolean>[] bool;

    static {
        bool = new INode[2];
        bool[0] = new NotNode();
        bool[1] = new OrNode();
    }
}
