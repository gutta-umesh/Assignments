package Evaluation_Logic;
import nodes.*;
public interface Visitor<T> {
    T visit(NumberNode node);
    T visit(SymbolNode node);
    T visit(ListNode node);

}
