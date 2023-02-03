package Week1.Meta;

public class Q3 {
    int [][] ranges;
    int[] arr;
    int sum = -1;

    public Q3(int[] w) {
        arr = w;
        ranges = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            ranges[i][0] = sum+1;
            ranges[i][1] = ranges[i][0]+arr[i]-1;
            sum = ranges[i][1];
        }
    }

    public int pickIndex() {
        int rand = (int)(Math.random()*(sum+1));
        int start = 0;
        int end = ranges.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(ranges[mid][0]<=rand && rand<=ranges[mid][1]){
                return mid;
            }else if(rand < ranges[mid][0]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;

    }
}
