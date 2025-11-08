package org.example.five_hundred;

import java.util.*;

/**
 * https://leetcode.com/problems/design-in-memory-file-system/description/
 */
public class FileSystem {
    class Directory {
        String path;
        Map<String,Directory> directoryMap;
        Map<String,String> files;

        public Directory(String path) {
            this.path = path;
            directoryMap = new HashMap<>();
            files = new HashMap<>();
        }
    }
    Directory root;
    public FileSystem() {
        root = new Directory("/");
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        if(path.equals("/")) {
            result.addAll(root.files.keySet());
            result.addAll(root.directoryMap.keySet());
            result.sort(String::compareTo);
            return result;
        }

        Directory wd = root;
        String[] parts = path.split("/");

        for (int i =1; i < parts.length; i++) {
            Directory nd = wd.directoryMap.get(parts[i]);
            if(nd == null) {
                if(i == parts.length-1 && wd.files.containsKey(parts[i])) {
                    result.add(parts[i]);
                }
                return result;
            }
            wd = nd;
        }
        result.addAll(wd.files.keySet());
        result.addAll(wd.directoryMap.keySet());
        result.sort(String::compareTo);
        return result;
    }

    public void mkdir(String path) {
        Directory wd = root;
        String[] parts = path.split("/");

        for (int i =1; i < parts.length; i++) {
            if (wd.directoryMap.containsKey(parts[i])) {
                wd = wd.directoryMap.get(parts[i]);
                continue;
            }
            wd.directoryMap.put(parts[i], new Directory(parts[i]));
            wd = wd.directoryMap.get(parts[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Directory wd = root;
        String[] parts = filePath.split("/");

        for (int i =1; i < parts.length-1; i++) {
            if (wd.directoryMap.containsKey(parts[i])) {
                wd = wd.directoryMap.get(parts[i]);
                continue;
            }
            wd.directoryMap.put(parts[i], new Directory(parts[i]));
            wd = wd.directoryMap.get(parts[i]);

        }
        String fileName = parts[parts.length-1];
        wd.files.put(fileName, wd.files.getOrDefault(fileName,"") + content);
    }

    public String readContentFromFile(String filePath) {
        Directory wd = root;
        String[] parts = filePath.split("/");

        for (int i =1; i < parts.length-1; i++) {
            if (wd.directoryMap.containsKey(parts[i])) {
                wd = wd.directoryMap.get(parts[i]);
                continue;
            }
            wd.directoryMap.put(parts[i], new Directory(parts[i]));
            wd.directoryMap.get(parts[i]);
        }
        String fileName = parts[parts.length-1];
        return wd.files.get(fileName);
    }

}
