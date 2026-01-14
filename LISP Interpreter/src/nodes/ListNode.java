package nodes;
import Evaluation_Logic.*;

import java.util.*;
public class ListNode implements Node{
    public final List<Node> value;
    public ListNode(List<Node> value){
        this.value=value;
    }
    public <T> T accept(Visitor<T> V){
        return V.visit(this);
    }
}
