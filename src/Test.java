import BackTracking.Gray;
import BackTracking.Palindrome;
import BinarySearch.smallerCount;
import BreadthFirstSearch.wordLabber;
import DP.*;
import DS.*;
import DepthFirstSearch.*;
import Greedy.Gas;
import HashTable.*;
import Solution.*;
import BinaryTree.*;
import Array.*;
import List.*;

import java.util.*;

public class Test {
    public static void main(String[] args){
//        wordLabber sol=new wordLabber();
        List<String> wordlist = new ArrayList<>();
        wordlist.add("cat");
        wordlist.add("cats");
        wordlist.add("and");
        wordlist.add("sand");
        wordlist.add("dog");
//        List<List<String>> result = sol.findLadders("a","c",wordlist);
//        StringBuilder str = new StringBuilder();
//
//        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(7);
//        treeDepth sol = new treeDepth();
//        System.out.println(sol.depthV2(root));


        Calculate c = new Calculate();
        System.out.println(c.calculate("2*(5+5*2)/3+(6/2+8)"));
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals(""))
                result += words[i] + " ";
        }
        return result.trim();
    }

    public static String convertToTitle(int n) {
        String result = "";
        Stack<String> stack=new Stack<>();
        while(n > 0){
            int num=n/26;
            if(n%26==0){
                stack.push("Z");
                n=n/27;
            }else{
                stack.push(String.valueOf((char)('A'+n%26-1)));
                n=n/26;
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
