/*
 * Problem Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

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
class Solution {
    public int maxSum;
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int l=solve(root.left);
        int r=solve(root.right);

        int niche_hi_Acha_hai=l+r+root.val;
        int koi_ek_acha_hai=Math.max(l,r)+root.val;

        int only_root_acha_hai=root.val;

        maxSum=Math.max(Math.max(maxSum,niche_hi_Acha_hai),Math.max(only_root_acha_hai,koi_ek_acha_hai));

        return Math.max(koi_ek_acha_hai,only_root_acha_hai);
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        int x=solve(root);

        return maxSum;
    }
}