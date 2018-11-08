package Solution;

public class leetcode12 {
    /*Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.*/
    public String intToRoman(int num) {
        int thou_num=num/1000;
        num=num%1000;
        int hud_num=num/100;
        num=num%100;
        int ten_num=num/10;
        int unit_num=num%10;
        String Roman="";
        while(thou_num>0){
            Roman=Roman+"M";
            thou_num--;
        }
        Roman=subRoman(Roman,hud_num,"C","CD","CM","D");
        Roman=subRoman(Roman,ten_num,"X","XL","XC","L");
        Roman=subRoman(Roman,unit_num,"I","IV","IX","V");
        return Roman;
    }
    public int romanToInt(String s) {
        int length=s.length();
        int index=length-1,result=0;
        while(index>=0){
            char symbol=s.charAt(index);
            if(symbol=='I'){
                if(index+1<=length-1 && (s.charAt(index+1)=='V' || s.charAt(index+1)=='X'))
                    result-=1;
                else
                    result+=1;
            }else if(symbol=='V')
                result+=5;
            else if(symbol=='X'){
                if(index+1<=length-1 && (s.charAt(index+1)=='L' || s.charAt(index+1)=='C'))
                    result-=10;
                else
                    result+=10;
            }else if(symbol=='L')
                result+=50;
            else if(symbol=='C'){
                if(index+1<=length-1 && (s.charAt(index+1)=='D' || s.charAt(index+1)=='M'))
                    result-=100;
                else
                    result+=100;
            }else if(symbol=='D')
                result+=500;
            else
                result+=1000;
            index--;
        }
        return result;
    }
    private String subRoman(String Roman,int num,String R1,String R2,String R3,String R4){
        if(num<=3){
            while(num>0) {
                Roman = Roman + R1;
                num--;
            }
        }else if(num==4)
            Roman=Roman+R2;
        else if(num==9)
            Roman=Roman+R3;
        else{
            Roman=Roman+R4;
            num=num-5;
            while(num>0){
                Roman=Roman+R1;
                num--;
            }
        }
        return Roman;
    }
}
