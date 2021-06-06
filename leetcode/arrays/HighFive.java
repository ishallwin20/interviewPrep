package arrays;

import java.util.*;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, ModifiedList> data = new HashMap<Integer, ModifiedList>();

        for(int i=0;i<items.length;i++) {
            if(data.get(items[i][0]) == null) {
                data.put(items[i][0] , new ModifiedList(items[i][1]));
            } else {
                data.get(items[i][0]).add(items[i][1]);
            }
        }

        int [][] out = new int[data.size()][2];
        int count = 0;
        for(int key : data.keySet()) {
            int avg = Arrays.stream(data.get(key).get()).sum()/5;
            out[count][0] = key;
            out[count][1] = avg;
            count++;
        }

        Arrays.sort(out,Comparator.comparingInt(a -> -a[1]));


        return out;
    }
    public static void main(String[] args) {
        int[][] test = new int[][] {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}, {1,99}, {1,64}};
        HighFive h = new HighFive();
        h.highFive(test);
    }
}

class ModifiedList {
    private int [] _data;
    private static final int MAX_SIZE = 5;
    ModifiedList(int initData) {
        this._data = new int[MAX_SIZE];
        this.add(initData);
    }

    public void add(int val) {
        if(val > _data[MAX_SIZE-1]) {
            for(int i=0;i<MAX_SIZE;i++) {
                if(_data[i] < val) {
                    int temp = val;
                    val = _data[i];
                    _data[i] = temp;
                }
            }
        }
    }

    public int[] get() {
        return _data;
    }
}
