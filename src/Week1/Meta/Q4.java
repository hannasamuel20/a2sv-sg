package Week1.Meta;

import java.util.*;


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class Q4 {
    Map<Integer, List<int[]>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        helper(root,0,0);
        int min = 0;
        int max = 0;
        for(int key:map.keySet()){
            min = Math.min(min,key);
            max = Math.max(max,key);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=min; i<=max; i++){
            Collections.sort(map.get(i),(int[] a, int [] b)->{
                if(a[1] == b[1])return a[0] - b[0];
                return a[1] - b[1];
            });
            List<Integer> l = new ArrayList<>();
            for(int[] arr:map.get(i)){
                l.add(arr[0]);
            }
            res.add(l);
        }
        return res;
    }
    public void helper(TreeNode node, int row, int col){
        if(node == null) return;
        helper(node.left,row+1,col-1);
        helper(node.right,row+1,col+1);
        if(!map.containsKey(col)){
            map.put(col, new ArrayList<>());
        }
        map.get(col).add(new int[]{node.val,row});

    }
}
