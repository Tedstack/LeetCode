package Solution;

import java.util.Stack;

public class simplifyPath {
    public String solution(String path) {
        String[] fileNameList=path.split("/");
        Stack<String> fileStack=new Stack<>();
        for(int i=0;i<fileNameList.length;i++){
            if(fileNameList[i].equals("..")){
                if(!fileStack.isEmpty()){
                    fileStack.pop();
                }
            }else{
                if(!fileNameList[i].equals(".") && !fileNameList[i].equals(""))
                    fileStack.push(fileNameList[i]);
            }
        }
        String result="";
        while(!fileStack.isEmpty()){
            String file=fileStack.pop();
            result="/"+file+result;
        }
        if(result.equals(""))
            result="/";
        return result;
    }
}
