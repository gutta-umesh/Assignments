package com.lisp.globalenv;

import com.lisp.evaluation.EvaluationVisitor;
import com.lisp.parser.InputParser;
import com.lisp.nodes.Node;

import java.util.Scanner;

public class EnterInput {
    public String input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "start";
        System.out.println("Welcome to Lisp Interpreter: \nplease enter the input:");
        while (true) {
            input = sc.nextLine();
            if (input.equals("stop")) {
                System.out.println("Closing the lisp interpreter");
                break;
            }
            InputParser parser = new InputParser();
            EvaluationVisitor evaluator = new EvaluationVisitor();
            try {
                Node ast = parser.parseInput(input);
                int result = ast.accept(evaluator);
                System.out.println("Result:" + result);
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
    }
}
