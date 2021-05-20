package arrays;

import java.util.Arrays;

public class ShalvinList {
    private static final int DEFAULT_SIZE = 10;
    private int count = 0;
    private int [] _storage;
    ShalvinList() {
        _storage = new int[DEFAULT_SIZE];
    }

    ShalvinList(int size) {
        _storage = new int[size];
    }

    public void add(int item) {
        if(count !=0 && count % DEFAULT_SIZE == 0) {
            _storage = Arrays.copyOf(_storage,_storage.length+DEFAULT_SIZE);
            _storage[count] = item;
        } else {
            _storage[count] = item;
        }

        count++;
    }

    public int get(int index) {
        return _storage[index];
    }



}
