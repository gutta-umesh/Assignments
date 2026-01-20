package com.lisp.globalenv;

import java.util.*;

public class GlobalEnvironment {
    private static GlobalEnvironment instance;
    private final Map<String, Integer> variables = new HashMap<>();

    public GlobalEnvironment() {
    }

    public static GlobalEnvironment getInstance() {
        if (instance == null) {
            instance = new GlobalEnvironment();
        }
        return instance;
    }

    public void define(String name, int value) {
        variables.put(name, value);
    }

    public int lookup(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Undefined variable: " + name);
        }
        return variables.get(name);
    }
}
