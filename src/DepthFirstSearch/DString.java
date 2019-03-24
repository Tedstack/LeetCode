package DepthFirstSearch;

public class DString {
    public String decodeString(String s) {
        int[] bracket=findFirstBracket(s);
        while(bracket[0]!=-1 && bracket[1]!=-1){
            String dec=s.substring(bracket[0]+1,bracket[1]);
            int num=0,index=bracket[0]-1,count=0;
            while(index>=0){
                if('0'<=s.charAt(index) && s.charAt(index)<='9'){
                    num+=(s.charAt(index)-'0')*Math.pow(10,count);
                    count++;
                    index--;
                }else
                    break;
            }
            String pre=s.substring(0,index+1);
            String post=s.substring(bracket[1]+1,s.length());
            for(int i=0;i<num;i++){
                pre=pre+dec;
            }
            s=pre+post;
            bracket=findFirstBracket(s);
        }
        return s;
    }
    public int[] findFirstBracket(String s){
        int[] result=new int[2];
        try {
            result[1]=s.indexOf("]");
            String temp=s.substring(0,result[1]);
            while(temp.contains("[")){
                result[0]+=temp.indexOf("[")+1;
                temp=temp.substring(temp.indexOf("[")+1,temp.length());
            }
            result[0]--;
            return result;
        }catch (Exception e){
            result[0]=-1;
            result[1]=-1;
            return result;
        }
    }
}
