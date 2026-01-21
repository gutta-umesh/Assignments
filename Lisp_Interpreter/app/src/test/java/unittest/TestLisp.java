package com.lisp.unittest;
import com.lisp.evaluation.EvaluationVisitor;
import com.lisp.nodes.*;
import com.lisp.parser.InputParser;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TestLisp {
    InputParser parser;
    EvaluationVisitor evaluator;

    @BeforeEach
    void setUp(){
        parser=new InputParser();
        evaluator=new EvaluationVisitor();
    }

    @Test
    void testAdd(){
        String inp="(+ 20 10)";
        Node ast=parser.parseInput(inp);
        assertEquals(30,ast.accept(evaluator));
    }

    @Test
    void testSub(){
        String inp="(- 20 1)";
        Node ast=parser.parseInput(inp);
        assertEquals(19,ast.accept(evaluator));
    }

    @Test
    void testMul(){
        String inp="(* 40 10)";
        Node ast=parser.parseInput(inp);
        assertEquals(400,ast.accept(evaluator));
    }

    @Test
    void testDiv(){
        String inp="(/ 20 2)";
        Node ast=parser.parseInput(inp);
        assertEquals(10,ast.accept(evaluator));
    }

    @Test
    void testDinByZero(){
        String inp="(/ 20 0)";
        Node ast=parser.parseInput(inp);
        assertThrows(ArithmeticException.class,()->{ast.accept(evaluator);});
    }

    @Test
    void testDefineExp(){
        String inp="(define y 10)";
        Node ast=parser.parseInput(inp);
        assertEquals(10,ast.accept(evaluator));
    }

    @Test
    void testDEfineWithoutVar(){
        String inp="(define 20)";
        Node ast=parser.parseInput(inp);
        assertThrows(IllegalArgumentException.class,()->{ast.accept(evaluator);});
    }

    @Test
    void testNestedExp(){
        String inp="(+ (- 20 10) (* 10 1))";
        Node ast=parser.parseInput(inp);
        assertEquals(20,ast.accept(evaluator));
    }

    @Test
    void testCompExp(){
        String inp="(> 20 10)";
        Node ast=parser.parseInput(inp);
        assertEquals(1,ast.accept(evaluator));
    }

    public static void main(String[] args){
        new TestLisp();
    }
}
