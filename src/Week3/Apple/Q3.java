package Week3.Apple;

public class Q3 {
    public boolean checkValidString(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return check(0,s,0,memo);
    }

    public boolean check(int idx,String s, int count,int[][] memo){
        if(count < 0) return false;
        if(idx == s.length())  return count == 0;

        if(memo[idx][count] != 0)
            return memo[idx][count] == 1;
        boolean res = false;
        if(s.charAt(idx) == '('){
            res = check(idx+1,s,count+1,memo);
        }else if(s.charAt(idx) == ')'){
            res = check(idx+1,s,count-1,memo);
        }else{
            res = check(idx+1,s,count,memo) || check(idx+1,s,count+1,memo) || check(idx+1,s,count-1,memo);
        }

        memo[idx][count] = res?1:-1;
        return res;

    }
}
