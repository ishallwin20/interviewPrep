package may2021;

import java.util.Arrays;

public class TrainMinTimeToArrive {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour < dist.length-1) return -1;
        Math.ceil(Arrays.stream(dist).sum()/hour);
        for(int i = (int)Math.ceil(Arrays.stream(dist).sum()/hour);;) {
            double sumTime = 0;
            double sumTimeMins1 = 0;
            for(int j=0;j< dist.length;j++) {
                if(j == dist.length - 1) {
                    sumTimeMins1 = sumTime;
                }
                sumTime = sumTime + (j != dist.length-1 ? Math.ceil(dist[j]/(i*1.0)) : dist[j]/(i*1.0));
            }

            if(sumTime <= hour) return i;
            else {
                i = Math.max((int)Math.floor(dist[dist.length-1]/(1.0 * (hour-sumTimeMins1))),i+1);
            }
        }
    }

    public static void main(String[] args) {
        int [] test = new int[3];
        test[0] = 1;
        test[1] = 3;
        test[2] = 2;

        int [] test2 = new int[3];
        test2[0] = 1;
        test2[1] = 1;
        test2[2] = 100000;


        TrainMinTimeToArrive trainMinTimeToArrive = new TrainMinTimeToArrive();
        /*System.out.println(trainMinTimeToArrive.minSpeedOnTime(test,6));
        System.out.println(trainMinTimeToArrive.minSpeedOnTime(test,2.7));
        System.out.println(trainMinTimeToArrive.minSpeedOnTime(test,1.9));*/
        System.out.println(trainMinTimeToArrive.minSpeedOnTime(test,3.7));
        System.out.println(trainMinTimeToArrive.minSpeedOnTime(test,4.7));

        System.out.println(trainMinTimeToArrive.minSpeedOnTime(test2,2.01));
    }
}
