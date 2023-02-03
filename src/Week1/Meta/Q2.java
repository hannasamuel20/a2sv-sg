package Week1.Meta;

import java.util.ArrayDeque;

public class Q2 {
    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] files = path.split("/");
        for(String file:files){
            if(file.equals("..")){
                if(!stack.isEmpty())stack.removeLast();
            }else if(!file.equals("") && !file.equals(".")){
                stack.addLast(file);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/"+stack.removeFirst());
        }
        return sb.length()==0?"/":sb.toString();


    }
}
