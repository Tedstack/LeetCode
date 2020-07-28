package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class smallerCount {
    // index way. (nlogn)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] sorted = nums.clone();
        int[] rank = new int[nums.length+1];
        Arrays.sort(sorted);
        for(int i=nums.length-1;i>=0;i--){
            int index = findIndex(sorted, nums[i])+1;
            rank[index]++;
            int sum = calSum(rank, index);
            result.add(0,sum);
        }
        return result;
    }

    public int findIndex(int[] nums, int target){
        int start=0, end =nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public int calSum(int[] rank, int index){
        int sum=0;
        for(int i=0;i<index;i++)
            sum+=rank[i];
        return sum;
    }

    class Node{
        public int val;
        public int count;
        public int left_count;
        public Node left;
        public Node right;

        public Node(int val){
            this.val=val;
            count =1;
            left_count=0;
        }

    }

    Node root=null;

    public List<Integer> countSmallerByTree(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--)
            result.add(0, insert(nums[i]));
        return result;
    }

    public int insert(int val){
        if(root == null){
            root = new Node(val);
            return 0;
        }
        Node temp = root;
        Node node = new Node(val);
        int result =0;
        while(true){
            if(temp.val == val){
                temp.count++;
                break;
            } else if(temp.val>val){
                if(temp.left!=null)
                    temp = temp.left;
                else {
                    temp.left = node;
                    break;
                }
            } else {
                result += temp.left_count + temp.count;
                if(temp.right!=null)
                    temp=temp.right;
                else{
                    temp.right = node;
                    break;
                }
            }
        }
        return result;
    }
}