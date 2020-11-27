package com.nc.util;

import java.util.HashMap;

public class TrieNode {
    public int path;
    public int end;
    public HashMap<Character,TrieNode> map;

    public TrieNode() {
        path = 0;
        end = 0;
        map = new HashMap<>();
    }
}
