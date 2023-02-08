package Week2.Uber;

public class Q1 {
    public int thirdMax(int[] nums) {
        long fm = Long.MIN_VALUE,sm = Long.MIN_VALUE,tm = Long.MIN_VALUE;
        int count = 0;

        for(int num:nums){
            if(num > fm){
                tm = sm;
                sm = fm;
                fm = num;
                count++;
            }else if(num > sm && num!=fm){
                tm = sm;
                sm = num;
                count++;
            }else if(num > tm && num!=fm && num!=sm){
                tm = num;
                count++;
            }
        }
        return (int)(count>=3?tm:fm);

    }
}
