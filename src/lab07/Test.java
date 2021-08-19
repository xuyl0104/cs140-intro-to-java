package lab07;

/**
 * test the set class we create in ArraySet
 */
public class Test {
    
    public static void main(String[] args) {
        ArraySet set = new ArraySet();
        set.add("asdf");
        set.printSet();
        set.add("second");
        set.printSet();
        set.add("third");
        set.printSet();
        set.add("third");
        set.printSet();
        set.add("third");
        set.printSet();

        String[] strs = {"one", "two", "two", "one", "onw"};
        set.addAll(strs);
        set.printSet();

        set.remove("one");
        set.printSet();
        set.remove("onw");
        set.printSet();
        set.remove("twoo");
        set.printSet();
        set.remove("two");
        set.printSet();
    }
}
