package Week2.TikTok;
import java.util.*;
public class Q3 {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        backtrack(0,s,new StringBuilder(),0);
        return res;

    }

    public void backtrack(int idx,String s, StringBuilder sb,int count){
        int portion = 0;
        if(idx == s.length() || count == 4){
            if(idx == s.length() && count == 4)
                res.add(sb.toString());
            return;
        }
        StringBuilder temp = new StringBuilder();
        for(int i=idx; i<s.length(); i++){
            portion=portion * 10 + s.charAt(i)-'0';
            temp.append(s.charAt(i));
            if(portion <= 255){
                sb.append(temp.toString());
                if(count<3)sb.append('.');
                backtrack(i+1,s,sb,count+1);
                if(count<3)sb.deleteCharAt(sb.length()-1);
                for(int j=0; j<temp.length(); j++)
                    sb.deleteCharAt(sb.length()-1);
                if(portion == 0) return;
            }else return;
        }
    }
}
