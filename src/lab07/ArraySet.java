package lab07;

import java.util.Arrays;

public class ArraySet {
    private String[] store = new String[]{};

    public void add(String s) {
        if (!contains(s)) {
            store = Arrays.copyOf(store, store.length + 1);
            store[store.length - 1] = s;
        }
    }

    public boolean contains(String s) {
        boolean found = false;
        for (int i = 0; i < store.length; ++i) {
            if (store[i].equals(s)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public void addAll(String[] strs) {
        for (String str : strs) {
            add(str);
        }
    }

    public void printSet() {
        System.out.println("The set is: ");
        for (String str : store) {
            System.out.println(str + " ");
        }
        System.out.println();        
    }

    public void remove(String s) {
        int pos = -1;
        for (int i = 0; i < store.length; ++i) {
            if (s.equals(store[i])) {
                pos = i;
                break;
            }
        }
        // if (pos >= 0) {
        //     String[] storeTemp = new String[store.length - 1];
        //     for (int i = 0; i < pos; ++i) {
        //         storeTemp[i] = store[i]; // _(0) to _(pos-1) --> _(0) to _(pos-1)
        //     }

        //     for (int i = pos + 1; i < store.length; ++i) {
        //         storeTemp[i - 1] = store[i]; // _(pos+1) to _(length-1) --> _(pos) to _(length-2)
        //     }
        //     store = storeTemp;
        // }
        if (pos >= 0) {
            String[] storeTemp = new String[store.length - 1];
            System.arraycopy(store, 0, storeTemp, 0, pos);
            System.arraycopy(store, pos+1, storeTemp, pos, (store.length - 1 - pos));
            store = storeTemp;
        }
    }

    public String toString () {
        return Arrays.toString(store);
    } 
    public String[] getStore() {
        return store;
    }
    public static void main(String[] args) {
        var test = new ArraySet();
        test.addAll(new String[] {"cat", "dog", "Horse", "dog", "cat"});
        System.out.println(test);
    }
}
