package nodes;

import Evaluation_Logic.*;

public class SymbolNode implements Node{
    public final String value;
    public SymbolNode(String value){
        this.value=value;
    }
    public <T> T accept(Visitor<T> V) {
        return V.visit(this);
    }
}
