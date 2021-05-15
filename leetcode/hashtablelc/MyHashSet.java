package hashtablelc;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private static final int KEY_RANGE = 10000;
    private LinkedListBucket[] bucketArr;


    public MyHashSet() {
        bucketArr = new LinkedListBucket[KEY_RANGE];
        for(int i = 0 ; i<KEY_RANGE ;i++) {
            bucketArr[i] = new LinkedListBucket();
        }
    }

    private int _hasher(int key) {
        return key%KEY_RANGE;
    }

    public void add(int key) {
        bucketArr[_hasher(key)].insert(key);
    }

    public void remove(int key) {
        bucketArr[_hasher(key)].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bucketArr[_hasher(key)].contains(key);
    }

}
