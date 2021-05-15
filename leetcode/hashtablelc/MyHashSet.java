package hashtablelc;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private List<Integer> container;

    public MyHashSet() {
        container = new ArrayList<Integer>();
    }

    public void add(int key) {
        if(!container.contains(key)) container.add(key);
    }

    public void remove(int key) {
        try {
            container.remove(Integer.valueOf(key));
        } catch (Exception e) {

        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return container.indexOf(key) == -1 ? false : true;
    }

}
