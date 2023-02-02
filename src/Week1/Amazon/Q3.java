package Week1.Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3 {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letterLogs = new ArrayList<>();
        String[] res = new String[logs.length];
        int k = res.length-1;
        for(int i=logs.length-1; i>=0; i--){
            String[] log = logs[i].split(" ");
            boolean isDigitLog = Character.isDigit(log[1].charAt(0));
            if(isDigitLog){
                res[k--] = logs[i];
            }else{
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs,(String[] a, String[] b)->{
            int idx = 1;
            while(idx < a.length && idx < b.length){
                if(!a[idx].equals(b[idx])){
                    return a[idx].compareTo(b[idx]);
                }
                idx++;
            }
            if(a.length == b.length){
                return a[0].compareTo(b[0]);
            }
            return a.length-b.length;
        });
        k = 0;
        for(String[]log : letterLogs){
            StringBuilder concat = new StringBuilder();
            for(String l:log){
                concat.append(l);
                concat.append(' ');
            }
            res[k++] = concat.toString().trim();
        }
        return res;



    }
}
