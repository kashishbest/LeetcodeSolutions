package org.example.eleven_hundred;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-file-system/
 */
public class FileSystem {

    class Node {
        String path;
        int value;
        Map<String, Node> children;

        public Node(String path, int value) {
            this.path = path;
            this.value = value;
            children = new HashMap<>();
        }
    }
    Node parent;
    public FileSystem() {
        parent = new Node("",0);
    }

    public boolean createPath(String path, int value) {
        String[] parts = path.split("/");
        int i = 1;
        Node node = parent;
        while(i < parts.length) {
            String part = parts[i];
            Node nn = node.children.get(part);
            if(nn==null) {
                if(i != parts.length-1) return false;
                node.children.put(part,new Node(part,value));
                return true;
            }
            if(i == parts.length-1) return false;
            node = nn;
            i++;
        }
        return true;
    }

    public int get(String path) {
        String[] parts = path.split("/");
        System.out.println(parts.length);
        int i = 1;
        Node node = parent;
        while(i < parts.length) {
            String part = parts[i];
            Node nn = node.children.get(part);
            if(nn==null) return -1;
            node = nn;
            i++;
        }
        return node.value;
    }
}
