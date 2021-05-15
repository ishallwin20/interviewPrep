package hashtablelc;

import java.util.LinkedList;

public class LinkedListBucket implements Bucket{
    private LinkedList<Integer> container;

    LinkedListBucket() {
        container = new LinkedList<Integer>();
    }

    @Override
    public void insert(int key) {
        container.add(key);
    }

    @Override
    public boolean contains(int key) {
        if(container.contains(key)) return true;
        return false;
    }

    @Override
    public void remove(int key) {
        try {
            container.remove(Integer.valueOf(key));
        } catch (Exception e) {

        }
    }
}
