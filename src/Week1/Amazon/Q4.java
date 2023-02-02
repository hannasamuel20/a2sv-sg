package Week1.Amazon;

import java.util.ArrayList;
import java.util.List;

public class Q4 {
    public String numberToWords(int num) {
        if(num == 0)return "Zero";
        String[] map1 = {"Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
        String[] map2 = {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
        String[] map3 = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
        String[] map4 = {"","Thousand ","Million ","Billion "};
        List<String> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        while(num > 0){
            StringBuilder sb = new StringBuilder();
            int slice = num%1000;
            int f  = slice/100;
            int s = (slice-f*100)/10;
            int t = slice-s*10-f*100;
            if(f>0){
                sb.append(map3[f]);
                sb.append("Hundred ");
            }
            if(s == 1){
                sb.append(map1[t]);
            }else if(s > 0 && t == 0){
                sb.append(map2[s]);
            }else {
                if(s>1)
                    sb.append(map2[s]);
                sb.append(map3[t]);
            }
            list.add(sb.toString());
            num/=1000;
        }
        for(int i=list.size()-1; i>=0; i--){
            res.append(list.get(i));
            if(list.get(i).length()!=0)
                res.append(map4[i]);
        }
        return res.toString().trim();


    }
}
