package Week1;

public class Q2 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] sum = new int[mat.length+1][mat[0].length+1];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                sum[i+1][j+1]+=sum[i+1][j]+mat[i][j];
            }
        }
        for(int i=0; i<mat[0].length; i++){
            for(int j=0; j<mat.length; j++){
                sum[j+1][i+1]+=sum[j][i+1];
            }
        }
        int[][] res = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                int b = Math.min(i+k+1,mat.length);
                int r = Math.min(j+k+1,mat[0].length);
                int l = Math.max(j-k,0);
                int t = Math.max(i-k,0);
                res[i][j] = sum[b][r] - sum[t][r] - sum[b][l] + sum[t][l];
            }
        }
        return res;




    }
}
