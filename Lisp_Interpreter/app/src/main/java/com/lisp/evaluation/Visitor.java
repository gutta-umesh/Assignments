package com.lisp.evaluation;

import com.lisp.nodes.ListNode;
import com.lisp.nodes.NumberNode;
import com.lisp.nodes.SymbolNode;

public interface Visitor<T> {
    T visit(NumberNode node);

    T visit(SymbolNode node);

    T visit(ListNode node);

}
