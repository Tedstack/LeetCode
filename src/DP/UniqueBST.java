package DP;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result=new ArrayList<>();
        if(n==0)
            return result;
        return genTree(1,n);
    }
    /*split the n into 1-i, i, i-n. So the child trees could be build independently*/
    private List<TreeNode> genTree(int left,int right){
        List<TreeNode> result=new ArrayList<>();
        //keep the rule of the BST
        if(left>right)
            result.add(null);
        for(int i=left;i<=right;i++){
            //recursive to generate all left child BSTs
            List<TreeNode> left_tree=genTree(left,i-1);
            //recursive to generate all right child BSTs
            List<TreeNode> right_tree=genTree(i+1,right);
            //Combine the left and right to generate all solutions
            for(int j=0;j<left_tree.size();j++){
                for(int k=0;k<right_tree.size();k++){
                    TreeNode solNode=new TreeNode(i);
                    solNode.left=left_tree.get(j);
                    solNode.right=right_tree.get(k);
                    result.add(solNode);
                }
            }
        }
        return result;
    }
}
