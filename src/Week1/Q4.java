package Week1;

import java.util.Arrays;

public class Q4 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] arr = new int[plantTime.length][2];
        for(int i=0; i<arr.length; i++){
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }

        Arrays.sort(arr,(int[] a, int []b)->{
            if(a[1] == b[1])return a[0]-b[0];
            return b[1] - a[1];
        });

        int res = 0;
        int growing = 0;
        for(int[] plant: arr){
            res+=plant[0];
            growing = Math.max(plant[1],Math.max(growing-plant[0],0));
        }

        return res+growing;

    }

}
