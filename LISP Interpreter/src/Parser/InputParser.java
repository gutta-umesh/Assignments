package Parser;
import Factory.*;
import nodes.*;
import java.util.*;
public class InputParser {
    private final NodeFactory factory = new NodeFactory();
    private List<String> tokens;
    private int index = 0;
    public Node parseInput(String input) {
        tokenize(input);
        return parseExpression();
    }
    private void tokenize(String input) {
        tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == ')') {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else if (Character.isWhitespace(c)) {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            tokens.add(current.toString());
        }
    }
    private Node parseExpression() {

        String token = tokens.get(index++);

        if (token.equals("(")) {
            List<Node> elements = new ArrayList<>();

            while (!tokens.get(index).equals(")")) {
                elements.add(parseExpression());
            }
            index++;
            return factory.createList(elements);
        }
        if (token.matches("-?\\d+")) {
            return factory.createNumber(Integer.parseInt(token));
        }
        return factory.createSymbol(token);
    }
}
