package com.lisp.factory;

import com.lisp.nodes.ListNode;
import com.lisp.nodes.Node;
import com.lisp.nodes.NumberNode;
import com.lisp.nodes.SymbolNode;

import java.util.*;

public class NodeFactory {
    public SymbolNode createSymbol(String value) {
        return new SymbolNode(value);
    }

    public NumberNode createNumber(int value) {
        return new NumberNode(value);
    }

    public ListNode createList(List<Node> value) {
        return new ListNode(value);
    }
}
