package Evaluation_Logic;
import nodes.*;
import GlobalEnv.*;
import java.util.*;
public class EvaluationVisitor implements Visitor<Integer> {
    private final GlobalEnvironment env = GlobalEnvironment.getInstance();
    public Integer visit(NumberNode node) {
        return node.value;
    }
    public Integer visit(SymbolNode node) {
        // 🔹 Look up variable value from global environment
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
            if (elements.size() != 3) {
                throw new RuntimeException("define requires exactly 2 arguments");
            }
            SymbolNode variableNode = (SymbolNode) elements.get(1);
            int value = elements.get(2).accept(this);
            env.define(variableNode.value, value);
            return value;
        }
        if (elements.size() < 3) {
            throw new RuntimeException("Arithmetic operation requires at least 2 operands");
        }
        int result = elements.get(1).accept(this);
        for (int i = 2; i < elements.size(); i++) {
            int value = elements.get(i).accept(this);
            switch (operator) {
                case "+":
                    result += value;
                    break;
                case "*":
                    result *= value;
                    break;
                case "-":
                    result -= value;
                    break;
                case "/":
                    result /= value;
                    break;
                default:
                    throw new RuntimeException("Unknown operator: " + operator);
            }
        }
        return result;
    }
}
