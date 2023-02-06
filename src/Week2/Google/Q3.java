package Week2.Google;

public class Q3 {
}
class DetectSquares {
    int[][] count;
    public DetectSquares() {
        count = new int[1001][1001];
    }

    public void add(int[] point) {
        count[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        int res = 0;
        for(int i=0; i<count.length; i++){
            if(count[point[0]][i]>0 && i!=point[1]){
                int diff = i-point[1];
                int[] p0 = {point[0],i};

                int[] p1 = {point[0]+diff,i};
                int[] p2 = {point[0]+diff,point[1]};

                int[] np1 = {point[0]-diff,i};
                int[] np2 = {point[0]-diff,point[1]};

                if(p1[0]>=0 && p1[0]<count.length){
                    res+=count[p0[0]][p0[1]]*count[p1[0]][p1[1]]*count[p2[0]][p2[1]];
                }
                if(np1[0]>=0 && np1[0]<count.length){
                    res+=count[p0[0]][p0[1]]*count[np1[0]][np1[1]]*count[np2[0]][np2[1]];
                }


            }
        }
        return res;

    }
}
