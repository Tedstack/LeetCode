package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Topological {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] adjacent=new int[numCourses];
        boolean[] visited=new boolean[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0],new ArrayList<>(Arrays.asList(prerequisites[i][1])));
            }else
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            adjacent[prerequisites[i][1]]++;
        }
        int temp=findOneAdjacent(adjacent,visited),count=0;
        while(temp!=-1){
            if(map.containsKey(temp)) {
                List<Integer> list = map.get(temp);
                for (Integer i : list) {
                    adjacent[i]--;
                }
            }
            count++;
            visited[temp]=true;
            temp=findOneAdjacent(adjacent,visited);
        }
        return count==numCourses;
    }
    public int findOneAdjacent(int[] nums, boolean[] visited){
        for(int i=0;i<nums.length;i++)
            if(nums[i]==0 && !visited[i])
                return i;
        return -1;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order=new int[numCourses];
        int[] adjacent=new int[numCourses];
        boolean[] visited=new boolean[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0],new ArrayList<>(Arrays.asList(prerequisites[i][1])));
            }else
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            adjacent[prerequisites[i][1]]++;
        }
        int temp=findOneAdjacent(adjacent,visited),index=numCourses-1;
        while(temp!=-1){
            order[index]=temp;
            index--;
            if(map.containsKey(temp)) {
                List<Integer> list = map.get(temp);
                for (Integer i : list) {
                    adjacent[i]--;
                }
            }
            visited[temp]=true;
            temp=findOneAdjacent(adjacent,visited);
        }
        if(index==-1)
            return order;
        else
            return new int[]{};

    }
}
