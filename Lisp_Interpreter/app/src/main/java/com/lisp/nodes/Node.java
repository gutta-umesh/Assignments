package com.lisp.nodes;

import com.lisp.evaluation.Visitor;

public interface Node {
    <T> T accept(Visitor<T> V);
}
