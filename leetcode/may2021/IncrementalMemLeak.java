package may2021;

public class IncrementalMemLeak {
    public int[] memLeak(int memory1, int memory2) {
        int count = 1;
        while(true) {
            if(count > memory1 && count > memory2) break;
            if(memory1 >= memory2) {
                memory1 -= count;
            } else {
                memory2 -= count;
            }
            count ++;
        }
        int[] fin = new int[3];
        fin[0] = count;
        fin[1] = memory1;
        fin[2] = memory2;

        return fin;
    }
    public static void main(String[] args) {
        IncrementalMemLeak incrementalMemLeak = new IncrementalMemLeak();

        incrementalMemLeak.memLeak(8,11);
    }
}
