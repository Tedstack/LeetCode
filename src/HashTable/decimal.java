package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if((numerator<0 && denominator>0) ||(numerator>0 && denominator<0))
            sb.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num/den);
        if(num%den==0) {
            return sb.toString();
        }
        sb.append(".");
        long remain =num % den;
        Map<Long, Integer> map=new HashMap<>();
        while(remain!=0){
            if(map.containsKey(remain)){
                sb.insert(map.get(remain),"(");
                sb.append(")");
                return sb.toString();
            }
            map.put(remain,sb.length());
            remain *= 10;
            sb.append(remain/den);
            remain%=den;
        }
        return sb.toString();
    }
}
