package Week3.Snapchat;

public class Q1 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int idx1 = a.length()-1;
        int idx2 = b.length()-1;
        while(idx1 >= 0 || idx2 >= 0){
            int x = 0, y = 0;
            if(idx1 >= 0 && a.charAt(idx1) == '1'){
                x = 1;
            }
            if(idx2>=0 && b.charAt(idx2) == '1'){
                y = 1;
            }
            idx1--;idx2--;
            int sum = (x+y+carry)%2;
            carry = (x+y+carry)>1?1:0;
            res.append(sum);

        }
        if(carry>0)res.append(carry);
        return res.reverse().toString();



    }
}
