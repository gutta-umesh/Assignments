package nodes;

import Evaluation_Logic.*;

public class NumberNode implements Node{
    public final int value;
    public NumberNode(int value){
        this.value=value;
    }
    public <T> T accept(Visitor<T> V){
        return V.visit(this);
    }
}
