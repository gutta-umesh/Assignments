package com.lisp.nodes;

import com.lisp.evaluation.Visitor;

public class NumberNode implements Node {
    public final int value;

    public NumberNode(int value) {
        this.value = value;
    }

    public <T> int accept(Visitor<T> V) {
        return (int) V.visit(this);
    }
}
