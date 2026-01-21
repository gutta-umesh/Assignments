package com.lisp.evaluation;

import com.lisp.nodes.Node;

import java.util.List;

public class ComputeArithmetic {
    public static Integer compute(String opr, List<Node> elements, EvaluationVisitor visitor) {
        if (elements.size() < 3) {
            throw new RuntimeException("Arithmetic operation requires at least 2 operands");
        }
        int result = elements.get(1).accept(visitor);
        for (int i = 2; i < elements.size(); i++) {
            int value =  elements.get(i).accept(visitor);
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
