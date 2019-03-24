package Array;

import java.util.ArrayList;
import java.util.List;

public class sqiral {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height=matrix.length;
        int length=matrix[0].length;
        List<Integer> result=new ArrayList<>();
        if(height*length==0)
            return result;
        char[] direct=new char[]{'r','d','l','u'};
        boolean[][] visit=new boolean[height][length];
        int s1=0,s2=0,index=0;
        while(result.size()!=height*length){
            if(!visit[s1][s2]) {
                result.add(matrix[s1][s2]);
                visit[s1][s2] = true;
            }
            char d=direct[index%4];
            if(d=='r' && s2+1<length && !visit[s1][s2+1])
                s2++;
            else if(d=='d' && s1+1<height && !visit[s1+1][s2])
                s1++;
            else if(d=='l' && s2-1>=0 && !visit[s1][s2-1])
                s2--;
            else if(d=='u' && s1-1>=0 && !visit[s1-1][s2])
                s1--;
            else
                index++;
        }
        return result;
    }
}
