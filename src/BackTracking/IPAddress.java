package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> reuslt = new ArrayList<>();
        if(s==null || s.length()<4 || s.length() > 12) return reuslt;
        restore(s,"",0,reuslt);
        return reuslt;
    }

    public void restore(String s, String part, int count, List<String> result){
        if(count==4 && s.isEmpty())
            result.add(part);
        for(int i=1;i<=Math.min(s.length(), 3);i++){
            String str = s.substring(0,i);
            if(str.charAt(0)=='0' && str.length()>1) continue;
            if(str.length()==3 && Integer.valueOf(str)>255) continue;
            String node="";
            if(part.equalsIgnoreCase(""))
                node=str;
            else
                node=part+"."+str;
            restore(s.substring(i),node,count+1,result);
        }
    }
}

