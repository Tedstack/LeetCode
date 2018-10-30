package Solution;

public class leetcode8 {
    public int myAtoi(String str) {
        int length=str.length();
        if(length==0)
            return 0;
        boolean positive=true;
        int index;
        for(index=0;index<length;index++){
            if(str.charAt(index)==' ')
                continue;
            else if(str.charAt(index)=='+') {
                index++;
                break;
            }
            else if(str.charAt(index)=='-') {
                positive = false;
                index++;
                break;
            }
            else if(str.charAt(index)>='0' && str.charAt(index)<='9')
                break;
            else
                return 0;
        }
        for(;index<length;index++){
            if(str.charAt(index)=='0')
                continue;
            else
                break;
        }
        long result=0;
        for(int i=index;i<length;i++){
            if(i-index>=12)
                return 0;
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                result=result*10+(str.charAt(i)-'0');
                if(result>Integer.MAX_VALUE){
                    if(positive)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
            }else
                break;
        }
        if(!positive)
            result=0-result;
        return (int)result;
    }
}
