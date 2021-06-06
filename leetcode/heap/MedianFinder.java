package heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int minSize;
    int maxSize;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minSize = 0;
        maxSize = 0;
    }

    public void addNum(int num) {
        if(minSize == 0) {
            minHeap.offer(num);
            minSize++;
            return;
        }

        if(maxSize == 0) {
            if(num < minHeap.peek()) {
                maxHeap.offer(num);
            } else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);

            }
            maxSize++;
            return;
        }

        if(num < minHeap.peek()) {
            maxHeap.offer(num);
            maxSize++;
        } else {
            minHeap.offer(num);
            minSize++;
        }
        balance();
    }

    public double findMedian() {
        if(maxSize > minSize) return maxHeap.peek();
        if(maxSize < minSize) return minHeap.peek();
        return (maxHeap.peek() + minHeap.peek())/2.0;
    }

    private void balance() {
        if(Math.abs(minSize - maxSize) <= 1) return;
        if(maxSize > minSize) {
            minHeap.offer(maxHeap.poll());
            maxSize--;
            minSize++;
        } else {
            maxHeap.offer(minHeap.poll());
            maxSize++;
            minSize--;
        }
    }
}

class MedianFinderDriver {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        /*for(int i=0;i<10;i++) {
            int randInt =(int) (Math.random() * 10) + 1;
            mf.addNum(randInt);
        }*/

        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());


        System.out.println(mf.findMedian());
    }
}