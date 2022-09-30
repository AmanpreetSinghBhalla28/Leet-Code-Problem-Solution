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
    public boolean roodToNodePath(TreeNode root,TreeNode target, List<TreeNode> rootToNodePathList){
        
        if(root == null){
            return false;
        }
        boolean res = (root==target) || roodToNodePath(root.left,target,rootToNodePathList) ||                                              roodToNodePath(root.right,target,rootToNodePathList);
        
        if(res){
            rootToNodePathList.add(root);
            return true;
        }
        return res;
    }
    
    public void printKDown(TreeNode root,int k, TreeNode block,List<Integer> ans){
        if(root==null || k<0 || root==block){
            return;
        }
        if(k==0){
            ans.add(root.val);
        }
        printKDown(root.left, k-1, block,ans);
        printKDown(root.right, k-1, block,ans);
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList<>();
        
        List<TreeNode> rootToNodePathList = new ArrayList<>();
        roodToNodePath(root,target,rootToNodePathList);
        
        TreeNode block = null;
        for(int i=0; i<rootToNodePathList.size();i++){
            printKDown(rootToNodePathList.get(i),k-i,block,ans);
            block = rootToNodePathList.get(i);
        }
        return ans;
    }
}