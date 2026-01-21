package com.lisp.nodes;

import com.lisp.evaluation.Visitor;

public interface Node {
    <T> int accept(Visitor<T> V);
}
