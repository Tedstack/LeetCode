package BinaryTree;

import DS.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Serialize {
    public String serializeBT(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("NULL,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(serializeBT(root.left));
        sb.append(serializeBT(root.right));
        return sb.toString();
    }

    public TreeNode deserializeBT(String data){
        if (data == null || data.length() == 0)
            return null;
        String[] valList=data.split(",");
        int[] index=new int[]{0};
        return help(valList,index);
    }

    public TreeNode help(String[] valList, int[] index){
        if(index[0]>=valList.length)
            return null;
        String val=valList[index[0]];
        if(val.equals("NULL"))
            return null;
        TreeNode node=new TreeNode(Integer.valueOf(val));
        index[0]++;
        node.left=help(valList,index);
        index[0]++;
        node.right=help(valList,index);
        return node;
    }

    public String serializeBST(TreeNode root){
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(serializeBST(root.left));
        sb.append(serializeBST(root.right));
        return sb.toString();
    }

    public TreeNode deserializeBST(String data){
        LinkedList<String> que = new LinkedList<String>();
        que.addAll(Arrays.asList(data.split(",")));
        return buildBST(que);
    }

    public TreeNode buildBST(LinkedList<String> que){
        String str = que.pollFirst();
        if(str.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = buildBST(que);
        root.right = buildBST(que);
        return root;
    }
}
