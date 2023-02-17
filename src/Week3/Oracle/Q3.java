package Week3.Oracle;
import java.util.*;
public class Q3 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(new StringBuilder(),list,n*2,0);
        return list;
    }
    public void backtrack(StringBuilder sb,List<String> list,int n,int curr){
        if(n == 0){
            list.add(sb.toString());
            return;
        }
        if(curr < n){
            sb.append('(');
            backtrack(sb,list,n-1,curr+1);
            sb.deleteCharAt(sb.length()-1);
        }

        if(curr > 0){
            sb.append(')');
            backtrack(sb,list,n-1,curr-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
