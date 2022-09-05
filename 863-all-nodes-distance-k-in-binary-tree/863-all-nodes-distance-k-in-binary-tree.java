/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean roodToNodePath(TreeNode root,TreeNode target, ArrayList<TreeNode> ans){
     
        if(root==null){
            return false;
        }
        boolean res = (root == target) || roodToNodePath(root.left,target,ans)|| roodToNodePath(root.right,target,ans);
        if(res){
            ans.add(root);
        }
        return res;
    }
    
    public void printKDepth(TreeNode root,TreeNode block,int k, List<Integer> res){
        if(root==null || k<0 || root==block){
            return;
        }
        if(k==0){
            res.add(root.val);
            return;
        }
        printKDepth(root.left,block,k-1,res);
        
        printKDepth(root.right,block,k-1,res);
    
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        ArrayList<TreeNode> ans = new ArrayList<>();
       roodToNodePath( root,target,  ans);
        
        List<Integer> res = new ArrayList<>();
        TreeNode block = null;
        for(int i=0; i < ans.size();i++){
            if(k-i>=0){
                printKDepth(ans.get(i),block,k-i,res);
                block = ans.get(i);
            }
        }
        return res;
    }
}