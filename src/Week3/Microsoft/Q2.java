package Week3.Microsoft;

public class Q2 {
    public boolean reorderedPowerOf2(int n) {
        int[][] arr = new int[32][10];
        int pow = 0;
        boolean res = false;
        while(pow <= 30){
            int num = (int)Math.pow(2,pow);
            while(num > 0){
                arr[pow][num%10]++;
                num/=10;
            }
            pow++;
        }

        int[] given  = new int[10];
        while(n > 0){
            given[n%10]++;
            n/=10;
        }
        for(int[] num:arr)
            res = res || compare(num,given);

        return res;

    }
    public boolean compare(int[] arr1, int[] arr2){
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
