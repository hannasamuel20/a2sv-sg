package Week2.Yahoo;

public class Q3 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int max = 0;
        for(int i=0; i<img1.length; i++){
            for(int j=0; j<img1[0].length; j++){
                max = Math.max(max,Math.max(countOverlap(i,j,img1,img2),countOverlap(i,j,img2,img1)));
            }
        }
        return max;
    }

    public int countOverlap(int idx1,int idx2,int[][] img1, int[][] img2){
        int res = 0;
        int count = 0;
        for(int i=idx1; i<img1.length; i++){
            for(int j=idx2; j<img1[0].length; j++){
                if(img1[i][j] == 1 && img2[i-idx1][j-idx2] == 1)
                    count++;
            }
        }
        res = count;
        count = 0;
        for(int i=idx1; i<img1.length; i++){
            for(int j=img1[0].length - idx2 -1; j>=0; j--){
                if(img1[i][j] == 1 && img2[i-idx1][j+idx2] == 1)
                    count++;
            }
        }
        return Math.max(res,count);
    }
}
