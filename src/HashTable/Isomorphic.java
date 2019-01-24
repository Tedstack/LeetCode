package HashTable;

import java.util.HashMap;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] sArray = new int[256];
        int[] tArray = new int[256];
        for(int i=0; i<sChars.length; i++) {
            if(sArray[sChars[i]] != tArray[tChars[i]]) {
                return false;
            } else {
                sArray[sChars[i]] = i+1;
                tArray[tChars[i]] = i+1;
            }
        }
        return true;
    }
}
