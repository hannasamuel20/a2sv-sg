package Week2.TikTok;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public String reformatDate(String date) {
        Map<String,String> map = new HashMap<>();
        map.put("Jan","01");map.put("Feb","02");map.put("Mar","03");
        map.put("Apr","04");map.put("May","05");map.put("Jun","06");
        map.put("Jul","07");map.put("Aug","08");map.put("Sep","09");
        map.put("Oct","10");map.put("Nov","11");map.put("Dec","12");
        String[] split = date.split(" ");
        String res = split[2]+"-"+map.get(split[1])+"-";
        res+= split[0].length()==4?split[0].substring(0,2):("0"+split[0].substring(0,1));
        return res;

    }

}
