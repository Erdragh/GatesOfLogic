package com.github.erdragh.logicgates;

import java.util.ArrayList;

public interface INode<T> {
    public ArrayList<T> process(ArrayList<T> in);
}
