package may2021;

import java.util.*;
import java.util.stream.Collectors;

public class ProcessClassUsingServers {
    Map<Integer, List<Integer>> serverLoadVsIndex = new HashMap<Integer,List<Integer>>();
    Map<Integer,Integer> busyIndexAndItsFreeTime = new HashMap<Integer,Integer>();
    public int[] assignTasks(int[] servers, int[] tasks) {
        //Populate Map
        for(int i=0;i<servers.length;i++) {
            if(serverLoadVsIndex.get(servers[i]) == null) {
                serverLoadVsIndex.put(servers[i], new ArrayList<Integer>());
                serverLoadVsIndex.get(servers[i]).add(i);
            } else {
                serverLoadVsIndex.get(servers[i]).add(i);
            }
        }

        int[] fin = new int[tasks.length];

        //Check Tasks
        //Set<Integer> keySet = serverLoadVsIndex.keySet().stream().sorted();
        List<Integer> sortedKeys = serverLoadVsIndex.keySet().stream().sorted().collect(Collectors.toList());
        for(int i=0;i<tasks.length;i++) {
            freeUpBusyMap(i);
            boolean assigned = false;
            for(int key : sortedKeys) {
                List<Integer> serverList = serverLoadVsIndex.get(key);
                for (Integer server : serverList) {
                    if(busyIndexAndItsFreeTime.get(server) == null) {
                        fin[i] = server;
                        assigned = true;
                        busyIndexAndItsFreeTime.put(server,i+tasks[i]);
                        break;
                    }
                }
                if(assigned) break;
            }

            if(!assigned) {
                fin[i] = getMinKey();
                busyIndexAndItsFreeTime.put(fin[i],busyIndexAndItsFreeTime.get(fin[i])+tasks[i]);
            }
        }

        return fin;
    }

    private void freeUpBusyMap(int time) {
        busyIndexAndItsFreeTime.entrySet().removeIf(entry -> (time == (entry.getValue())));
    }

    private int getMinKey() {
        int minKey = -1;
        int minValue = Integer.MAX_VALUE;
        for(int key : busyIndexAndItsFreeTime.keySet()) {
            int value = busyIndexAndItsFreeTime.get(key);
            if(value < minValue) {
                minValue = value;
                minKey = key;
            }
        }
        return minKey;
    }

    public static void main(String[] args) {
        int[] servers = new int[5];
        int[] tasks = new int[7];

        servers[0]=5;
        servers[1]=1;
        servers[2]=4;
        servers[3]=3;
        servers[4]=2;

        tasks[0]=2;
        tasks[1]=1;
        tasks[2]=2;
        tasks[3]=4;
        tasks[4]=5;
        tasks[5]=2;
        tasks[6]=1;

        int[] servers1 = new int[] {10,63,95,16,85,57,83,95,6,29,71};
        int[] tasks1 = new int[] {70,31,83,15,32,67,98,65,56,48,38,90,5};



        ProcessClassUsingServers processClassUsingServers = new ProcessClassUsingServers();
        processClassUsingServers.assignTasks(servers1,tasks1);
    }
}
