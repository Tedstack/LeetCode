package Solution;

public class version {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("[.]");
        String[] ver2 = version2.split("[.]");
        int n = Math.max(ver1.length,ver2.length);
        for(int i=0;i<n;i++){
            int num1=0,num2=0;
            if(i<ver1.length)
                num1 = stringToInteger(ver1[i]);
            if(i<ver2.length)
                num2 = stringToInteger(ver2[i]);
            if(num1>num2)
                return 1;
            else if(num1<num2)
                return -1;
        }
        return 0;
    }

    public int stringToInteger(String s){
        int result=0;
        int dec=1;
        for(int i=s.length()-1;i>=0;i--){
            result += (s.charAt(i)-'0')*dec;
            dec*=10;
        }
        return result;
    }
}
