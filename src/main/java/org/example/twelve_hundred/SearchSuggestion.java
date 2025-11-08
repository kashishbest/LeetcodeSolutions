package org.example.twelve_hundred;

import java.util.*;

/**
 * https://leetcode.com/problems/search-suggestions-system/description/
 */
public class SearchSuggestion {
    class Node {
        char ch;
        List<String> words;
        Map<Character, Node> children;

        public Node(char ch) {
            this.ch = ch;
            words = new ArrayList<>();
            children = new HashMap<>();
        }
    }
    Node process(String[] products) {
        Node parent = new Node('/');
        Node node = parent;
        for(String product : products) {
            node = parent;
            for(char ch : product.toCharArray()) {
                node.words.add(product);
                if(node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    Node nn = new Node(ch);
                    node.children.put(ch,nn);
                    node = nn;
                }
            }
            node.words.add(product);
        }
        return parent;
    }
    List<List<String>> search(Node parent, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Node node = parent;
        for(char ch : searchWord.toCharArray()) {
            if(node == null) {
                result.add(Collections.EMPTY_LIST);
                continue;
            }
            Node nn = node.children.get(ch);
            if(nn == null) {
                result.add(Collections.EMPTY_LIST);
                node= null;
                continue;
            }
            List<String> temp = nn.words;
            temp.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            result.add(temp.subList(0,Math.min(3,temp.size())));
            node=nn;
        }
        return result;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node parent = process(products);
        return search(parent,searchWord);
    }

    public static void main(String[] args) {
        SearchSuggestion ss = new SearchSuggestion();
        ss.suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"},"mouse");
    }
}
