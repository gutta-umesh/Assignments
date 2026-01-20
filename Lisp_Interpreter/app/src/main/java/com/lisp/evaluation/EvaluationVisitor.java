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
            return evaluateDefine(elements);
        }
        if (elements.size() < 3) {
            throw new RuntimeException("Arithmetic operation requires at least 2 operands");
        }
        return evaluate(operator, elements);
    }

    public Integer evaluateDefine(List<Node> elements) {
        if (elements.size() != 3) {
            throw new RuntimeException("Define requires three arguments");
        }
        SymbolNode var = (SymbolNode) elements.get(1);
        int value = elements.get(2).accept(this);
        env.define(var.value, value);
        return value;
    }

    Integer evaluate(String opr, List<Node> elements) {
        if (elements.size() < 3) {
            throw new RuntimeException("Arithmetic operation requires at least 2 operands");
        }
        int result = elements.get(1).accept(this);
        for (int i = 2; i < elements.size(); i++) {
            int value = elements.get(i).accept(this);
            switch (opr) {
                case "+":
                    result += value;
                    break;
                case "-":
                    result -= value;
                    break;
                case "*":
                    result *= value;
                    break;
                case "/":
                    result /= value;
                    break;
                case "%":
                    result %= value;
                    break;
                case ">":
                    if (result > value) result = 1;
                    else result = 0;
                    break;
                case ">=":
                    if (result >= value) result = 1;
                    else result = 0;
                    break;
                case "<":
                    if (result < value) result = 1;
                    else result = 0;
                    break;
                case "<=":
                    if (result <= value) result = 1;
                    else result = 0;
                    break;
                default:
                    throw new RuntimeException("Unknown operator" + opr);
            }
        }
        return result;
    }
}

