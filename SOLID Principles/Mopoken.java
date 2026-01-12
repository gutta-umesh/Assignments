package com.mopokens.battle;

public class Mopoken {
String type;
int level;
public Mopoken(String type,int level) {
	this.type=type;
	this.level=level;
}
String getMopokenType() {
	return type;
}
int getMopokenLevel() {
	return level;
}
public String toString() {
    return type + "#" + level;
}
}
