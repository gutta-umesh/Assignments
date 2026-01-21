package com.lisp.nodes;

import com.lisp.evaluation.Visitor;

import java.util.*;

public class ListNode implements Node {
    public final List<Node> value;

    public ListNode(List<Node> value) {
        this.value = value;
    }

    public <T> int accept(Visitor<T> V) {
        return (int) V.visit(this);
    }
}
