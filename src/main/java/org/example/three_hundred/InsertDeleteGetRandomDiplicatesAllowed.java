package org.example.three_hundred;

import java.util.*;

public class InsertDeleteGetRandomDiplicatesAllowed {
    Map<Integer, Set<Integer>> map;
    List<Integer> store;
    Random random;

    public InsertDeleteGetRandomDiplicatesAllowed() {
        map = new HashMap<>();
        store = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {

        store.add(val);
        boolean rVal = !map.containsKey(val);
        Set<Integer> temp = map.getOrDefault(val, new HashSet<>());
        temp.add(store.size() - 1);
        map.put(val, temp);
        return rVal;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int indexToRemove = map.get(val).iterator().next();
        int temp = store.get(store.size()-1);

        store.set(indexToRemove,temp);
        store.remove(store.size()-1);


        map.get(val).remove(indexToRemove);
        if(map.get(val).size() == 0)
            map.remove(val);

        if(indexToRemove == store.size()) return true;

        map.get(temp).remove(store.size());
        map.get(temp).add(indexToRemove);
        return true;
    }

    public int getRandom() {
        return store.get(random.nextInt(store.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomDiplicatesAllowed obj = new InsertDeleteGetRandomDiplicatesAllowed();
        obj.insert(1);
        obj.insert(1);
        obj.insert(2);
        obj.insert(2);
        obj.insert(3);
        obj.insert(3);
        obj.remove(1);
        obj.remove(2);
        obj.remove(2);
        obj.remove(1);
        obj.remove(3);
        obj.insert(4);
        obj.remove(3);
//        obj.remove(3);
    }
}
