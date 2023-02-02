package Week1.Amazon;

public class Q2 {
    public long numberOfWays(String s) {
        long totalZeros = 0;
        long totalOnes = 0;
        for(char letter:s.toCharArray()){
            if(letter == '1')totalOnes++;
            else totalZeros++;
        }
        long leftZeros = 0;
        long leftOnes = 0;
        long res = 0;
        for(int i=0; i<s.length()-1; i++){
            char letter = s.charAt(i);
            if(letter == '1'){
                leftOnes++;
                res+=leftZeros*(totalZeros-leftZeros);
            }
            else{
                leftZeros++;
                res+=leftOnes*(totalOnes-leftOnes);
            }

        }
        return res;




    }
}
