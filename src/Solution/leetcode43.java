package Solution;

public class leetcode43 {
    public String multiply(String num1, String num2) {
        char[] result=new char[num1.length()+num2.length()];
        for(int i=0;i<result.length;i++)
            result[i]='0';
        for(int i=num1.length()-1;i>=0;i--){
            int add=0;
            for(int j=num2.length()-1;j>=0;j--){
                int num=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+result[i+j+1]-'0';
                result[i+j+1]=Character.forDigit((num+add)%10,10);
                add=(num+add)/10;
            }
            result[i]+=add;
        }
        String output="";
        for(int i=0;i<result.length;i++)
            if(result[i]!='0') {
                while(i<result.length) {
                    output += Character.toString(result[i]);
                    i++;
                }
            }
        if(output.equals(""))
            return "0";
        return output;
    }
}
