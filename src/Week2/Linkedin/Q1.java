package Week2.Linkedin;

import java.util.ArrayDeque;

public class Q1 {
    public int minOperations(String[] logs) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for(String log:logs){
            if(log.equals("../")){
                if(!stack.isEmpty()) stack.poll();
            }else if(!log.equals("./")){
                stack.add(log);
            }
        }
        return stack.size();

    }

}
