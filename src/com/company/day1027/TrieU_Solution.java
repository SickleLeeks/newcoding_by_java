package com.company.day1027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 字典树的实现
 */
public class TrieU_Solution {
    public static class Trie {
        // 定义字典树节点类型
        public static class TrieNode {
            public int path; // 表示有多少个单词共用这个节点
            public int end; // 表示有多少个单词以这个节点结尾
            public HashMap<Character, TrieNode> map; // 一个hash结构，key表示该节点的一条字符路径，value表示字符路径指向的节点

            public TrieNode() {
                path = 0;
                end = 0;
                map = new HashMap<>();
            }
        }

        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            TrieNode node = root;
            // 从左向右遍历word的每个字符
            for (int i = 0; i < word.length(); i++) {
                char chr = word.charAt(i);
                // 如果找的过程中节点不存在，就建立新节点
                if (!node.map.containsKey(chr)) {
                    node.map.put(chr, new TrieNode());
                }
                // 如果节点存在，则令path+1
                node = node.map.get(chr);
                node.path++;
            }
            // 通过最后一个字符word[n-1]找到最后一个节点时，令node.path++,node.end++
            node.end++;
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            TrieNode node = root;
            // 从左到右遍历word中的每个字符，并依次从头节点开始根据每一个word[i]，找到下一个节点。
            for (int i = 0; i < word.length(); i++) {
                char chr = word.charAt(i);
                // 如果节点不存在，说明这个单词的整个部分没有添加进Tries树，返回false
                if (!node.map.containsKey(chr)) {
                    return false;
                }
                node = node.map.get(chr);
            }
            // 如果e.end!=0，表示右单词通过word[n-1]的字符路径，并以节点e结尾，返回true
            return node.end != 0;
        }

        public void delete(String word) {
            // 先调用search函数，判断是否存在
            if (search(word)) {
                TrieNode node = root;
                // 从左到右遍历word中的每个字符
                for (int i = 0; i < word.length(); i++) {
                    char chr = word.charAt(i);
                    // 在找的过程中，把扫过的每一个节点的path值减1，如果发现下一个节点的path值减完之后已经为0，则直接从当前节点的map中删除后续的所有路径
                    if ((node.map.get(chr).path--) == 0) {
                        node.map.remove(chr);
                        return;
                    }
                    node = node.map.get(chr);
                }
                // 如果扫到最后一个节点，令e.path--，e.end--
                node.end--;
            }
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            TrieNode node = root;
            for (int i = 0; i < pre.length(); i++) {
                char chr = pre.charAt(i);
                if (!node.map.containsKey(chr)) {
                    return 0;
                }
                node = node.map.get(chr);
            }
            return node.path;
        }
    }


    /**
     * @param operators string字符串二维数组 the ops
     * @return string字符串一维数组
     */
    public static String[] trieU(String[][] operators) {
        if (operators == null) {
            return new String[]{};
        }
        Trie trie = new Trie();
        ArrayList<String> list = new ArrayList<>();
        for (String[] operator : operators) {
            if ("1".equals(operator[0])) {
                trie.insert(operator[1]);
            }
            if ("2".equals(operator[0])) {
                trie.delete(operator[1]);
            }
            if ("3".equals(operator[0])) {
                if (trie.search(operator[1])) {
                    list.add("YES");
                } else {
                    list.add("NO");
                }
            }
            if ("4".equals(operator[0])) {
                list.add(String.valueOf(trie.prefixNumber(operator[1])));
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }

    public static void main(String[] args) {
        String[][] opers = new String[][]{{"1", "qwer"}, {"1", "qwe"}, {"3", "qwer"}, {"4", "q"}, {"2", "qwer"}, {"3", "qwer"}, {"4", "q"}};
        System.out.println(Arrays.toString(trieU(opers)));
    }
}
