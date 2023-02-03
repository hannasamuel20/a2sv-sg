package Week1.Meta;

public class Q1 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return check(s,left+1,right) || check(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean check(String s,int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
