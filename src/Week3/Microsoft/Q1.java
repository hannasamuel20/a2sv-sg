package Week3.Microsoft;

public class Q1 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int val = n;
        int j = n-1;
        for(int i=0; i<n; i++){
            if(i < j){
                res[i] = val;
                res[j--] = -val;
                val--;
            }
        }
        return res;


    }
}
