package GlobalEnv;
import Parser.*;
import Evaluation_Logic.*;
import nodes.*;
import java.util.*;
public class GlobalEnvironment {
    private static GlobalEnvironment instance;
    private final Map<String, Integer> variables = new HashMap<>();
    private GlobalEnvironment() {
    }
    public static GlobalEnvironment getInstance() {
        if (instance == null) {
            instance = new GlobalEnvironment();
        }
        return instance;
    }
    public void define(String name, int value) {
        variables.put(name, value);
    }
    public int lookup(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Undefined variable: " + name);
        }
        return variables.get(name);
    }
    public static void main(String[] args) {

        GlobalEnvironment env = GlobalEnvironment.getInstance();

        Scanner sc = new Scanner(System.in);
        InputParser parser = new InputParser();
        EvaluationVisitor evaluator = new EvaluationVisitor();

        System.out.println("Enter LISP input:");
        String input = sc.nextLine();

        try {
            Node ast = parser.parseInput(input);
            int result = ast.accept(evaluator);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
