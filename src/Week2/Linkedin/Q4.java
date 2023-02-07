package Week2.Linkedin;

import java.util.ArrayList;
import java.util.List;

public class Q4 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<Integer> counts = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int wordsLens = 0;
        int wordCount = 0;
        for(String word:words){
            if(wordsLens+wordCount+word.length()>maxWidth){
                counts.add(wordCount);
                lens.add(wordsLens);
                wordCount = 0;
                wordsLens = 0;
            }
            wordsLens +=word.length();
            wordCount++;
        }
        counts.add(wordCount);
        lens.add(wordsLens);

        int idx = 0;
        for(int i=0; i<counts.size()-1; i++){
            int w = counts.get(i);
            int size = maxWidth - lens.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j=idx; j<counts.get(i)+idx; j++){
                sb.append(words[j]);
                if(w-1== 0) continue;
                int space = (size/(--w));
                if(size%(w) > 0)space++;
                size -= space;
                for(int k=0; k<space; k++) sb.append(' ');
            }
            while(sb.length()<maxWidth) sb.append(' ');
            res.add(sb.toString());
            idx+=counts.get(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int j=idx; j<counts.get(counts.size()-1)+idx; j++){
            sb.append(words[j]);
            if(sb.length()<maxWidth) sb.append(' ');
        }
        while(sb.length()<maxWidth) sb.append(' ');
        res.add(sb.toString());
        return res;
    }
}
