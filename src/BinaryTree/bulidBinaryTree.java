package BinaryTree;
import DS.*;

public class bulidBinaryTree {
    //Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0)
            return null;
        TreeNode root=new TreeNode(preorder[0]);
        if(preorder.length==1)
            return root;
        int index=0;
        for(;index<inorder.length;index++){
            if(inorder[index]==preorder[0])
                break;
        }
        int[] leftPreOrder=new int[index];
        int[] leftInOrder=new int[index];
        int[] rightPreOrder=new int[preorder.length-index-1];
        int[] rightInOrder=new int[preorder.length-index-1];
        for(int i=0;i<index;i++){
            leftPreOrder[i]=preorder[i+1];
            leftInOrder[i]=inorder[i];
        }
        root.left=buildTreePreIn(leftPreOrder,leftInOrder);
        for(int i=0;i<preorder.length-index-1;i++){
            rightPreOrder[i]=preorder[i+index+1];
            rightInOrder[i]=inorder[i+index+1];
        }
        root.right=buildTreePreIn(rightPreOrder,rightInOrder);
        return root;
    }
    public TreeNode buildTreePI2(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0)
            return null;
        return dfPreIn(preorder,inorder,0,0,preorder.length);
    }
    public TreeNode dfPreIn(int[] preorder,int[] inorder,int preIndex,int inIndex, int len){
        if(len==0)
            return null;
        TreeNode root=new TreeNode(preorder[preIndex]);
        if(len==1)
            return root;
        int index=inIndex;
        for(;index<inorder.length;index++){
            if(inorder[index]==preorder[preIndex])
                break;
        }
        root.left=dfPreIn(preorder, inorder,preIndex+1,inIndex,index-inIndex);
        root.right=dfPreIn(preorder, inorder,preIndex+index-inIndex+1,index+1,len-index+inIndex-1);
        return root;
    }
    //Construct Binary Tree from Inorder and Postorder Traversal
    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if(postorder.length==0 || inorder.length==0)
            return null;
        return dfPostIn(inorder,postorder,0,postorder.length-1,postorder.length);
    }
    public TreeNode dfPostIn(int[] inorder,int[] postorder,int inIndex,int postIndex, int len){
        if(len==0)
            return null;
        TreeNode root=new TreeNode(postorder[postIndex]);
        if(len==1)
            return root;
        int index=inIndex;
        for(;index<inIndex+len;index++){
            if(inorder[index]==postorder[postIndex])
                break;
        }
        int len_left=index-inIndex;
        int len_right=len-len_left-1;
        root.left=dfPostIn(inorder, postorder,inIndex,postIndex-len_right-1,len_left);
        root.right=dfPostIn(inorder, postorder,index+1,postIndex-1,len_right);
        return root;
    }
    public int numTrees(int n) {
        return DP(1,n);
    }
    public int DP(int begin,int end){
        int count=0;
        if(end<begin)
            return 1;
        for(int i=begin;i<=end;i++){
            int left=DP(begin,i-1);
            int right=DP(i+1,end);
            count+=left*right;
        }
        return count;
    }
}
