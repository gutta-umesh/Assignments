package com.lisp.evaluation;

import com.lisp.globalenv.GlobalEnvironment;
import com.lisp.nodes.*;

import java.util.*;

public class EvaluationVisitor implements Visitor<Integer> {
    private final GlobalEnvironment env = GlobalEnvironment.getInstance();

    public Integer visit(NumberNode node) {
        return node.value;
    }

    public Integer visit(SymbolNode node) {
        return env.lookup(node.value);
    }

    public Integer visit(ListNode node) {
        List<Node> elements = node.value;
        if (elements.isEmpty()) {
            throw new RuntimeException("Empty expression");
        }
        SymbolNode operatorNode = (SymbolNode) elements.get(0);
        String operator = operatorNode.value;
        if (operator.equals("define")) {
            return DefineVar.compute(elements,this);
        }
        if (elements.size() < 3) {
            throw new RuntimeException("Arithmetic operation requires at least 2 operands");
        }
        return ComputeArithmetic.compute(operator, elements,this);
    }

}

