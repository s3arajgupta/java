package practice.neetCode150.part5BinarySearch.medium;

import java.util.*;
import modules.*;;

public class timeBasedKeyValueStore {

    public static void main(String args[]) {

        timeBasedKeyValueStore obj = new timeBasedKeyValueStore();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));

    }

    Map<String, List<Pair<String, Integer>>> store;

    public timeBasedKeyValueStore() {

        store = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {

        if (!store.containsKey(key))
            store.put(key, new ArrayList<>());

        store.get(key).add(new Pair<String, Integer>(value, timestamp));

    }

    public String get(String key, int timestamp) {

        List<Pair<String, Integer>> list = store.get(key);
        String res = new String();

        if (list == null)
            return res;

        int l = 0, r = list.size() - 1, mid = 0;

        while (l <= r) {

            mid = l + (r - l) / 2;

            if (list.get(mid).getSecond() <= timestamp) {
                res = list.get(mid).getFirst();
                l = mid + 1;
            } else
                r = mid - 1;

        }

        return res;

    }

}
