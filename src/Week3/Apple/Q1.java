package Week3.Apple;

public class Q1 {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber > 0){
            res.append((char)(((columnNumber-1)%26)+'A'));
            columnNumber=(columnNumber-1)/26;
        }
        return res.reverse().toString();
    }
}
