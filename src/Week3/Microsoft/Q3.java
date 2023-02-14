package Week3.Microsoft;

public class Q3 {
    public int minimumDeletions(String s) {
        int[] leftBs = new int[s.length()+1];
        int[] rightAs = new int[s.length()+1];
        for(int i=s.length()-1; i>=0; i--){
            rightAs[i] = rightAs[i+1];
            if(s.charAt(i) == 'a')rightAs[i]++;
        }
        for(int i=0; i<s.length(); i++){
            leftBs[i+1] = leftBs[i];
            if(s.charAt(i) == 'b')leftBs[i+1]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<leftBs.length; i++){
            min = Math.min(min,leftBs[i]+rightAs[i]);
        }
        return min;


    }

}
