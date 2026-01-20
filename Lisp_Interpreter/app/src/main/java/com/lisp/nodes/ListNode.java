package com.lisp.nodes;

import com.lisp.evaluation.Visitor;

import java.util.*;

public class ListNode implements Node {
    public final List<Node> value;

    public ListNode(List<Node> value) {
        this.value = value;
    }

    public <T> T accept(Visitor<T> V) {
        return V.visit(this);
    }
}
