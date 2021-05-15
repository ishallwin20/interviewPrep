package hashtablelc;

import java.util.LinkedList;

public interface Bucket {
    void insert(int key);
    boolean contains(int key);
    void remove(int key);
}
