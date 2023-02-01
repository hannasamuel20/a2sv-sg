package Week1;

public class Q1 {
    public int minimumRecolors(String blocks, int k) {
        int res = blocks.length();
        int w = 0;
        int start = 0;
        for(int end=0; end<blocks.length(); end++){
            if(blocks.charAt(end) == 'W') w++;
            if(k == end-start+1){
                res = Math.min(res,w);
                if(blocks.charAt(start++) == 'W') w--;
            }
        }
        return res;

    }
}
