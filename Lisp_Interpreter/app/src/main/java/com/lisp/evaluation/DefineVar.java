package com.lisp.evaluation;

import com.lisp.globalenv.GlobalEnvironment;
import com.lisp.nodes.Node;
import com.lisp.nodes.SymbolNode;

import java.util.List;

public class DefineVar {

    public static Integer compute(List<Node> elements, EvaluationVisitor visitor) {
        if (elements.size() != 3) {
            throw new RuntimeException("Define requires three arguments");
        }
        SymbolNode var = (SymbolNode) elements.get(1);
        int value = elements.get(2).accept(visitor);
        GlobalEnvironment env = new GlobalEnvironment();
        env.define(var.value, value);
        return value;
    }
}
