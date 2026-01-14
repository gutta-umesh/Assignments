package nodes;

import Evaluation_Logic.*;

public interface Node {
    <T> T accept (Visitor<T> V);
}
