package Week2.Linkedin;

public class Q3 {
    public boolean isRobotBounded(String instructions) {
        int[] pos = {0,0};
        char[] dirs = {'N','E','S','W'};
        int idx = 0;
        for(int i=0; i<4; i++){
            for(char letter:instructions.toCharArray()){
                if(letter == 'G'){
                    if(dirs[idx] == 'N') pos[0]++;
                    else if(dirs[idx] == 'S') pos[0]--;
                    else if(dirs[idx] == 'E')pos[1]++;
                    else pos[1]--;
                }else if(letter == 'L'){
                    idx--;
                    if(idx == -1)idx = 3;
                }else{
                    idx = (idx+1)%4;
                }
            }
        }
        return pos[0] == 0 && pos[1] == 0 && idx == 0;
    }
}
