package Factory;

import nodes.*;
import java.util.*;
public class NodeFactory {
    public SymbolNode createSymbol(String value){
        return new SymbolNode(value);
    }
    public NumberNode createNumber(int value){
        return new NumberNode(value);
    }
    public ListNode createList(List<Node> value){
        return new ListNode(value);
    }
}
