package com.lisp.nodes;

import com.lisp.evaluation.Visitor;

public class SymbolNode implements Node {
    public final String value;

    public SymbolNode(String value) {
        this.value = value;
    }

    public <T> int accept(Visitor<T> V) {
        return (int) V.visit(this);
    }
}
