package Solution;

public class leetcode6 {
    //zigzag conversion
    public String convert(String s, int numRows) {
        int length=s.length();
        if(length<=1 || numRows==1)
            return s;
        int numCols=(length/(2*numRows-2)+1)*(numRows-1);
        char[][] zString=new char[numRows][numCols];
        int row=0,col=0;
        boolean moveDown=true;
        for(int i=0;i<length;i++){
            zString[row][col]=s.charAt(i);
            if(row+1<numRows && moveDown)
                row++;
            else if(moveDown)
                moveDown=false;
            if(row>0 && !moveDown){
                row--;
                col++;
            }else if(!moveDown) {
                moveDown = true;
                row++;
            }
        }
        String result="";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++)
                if(zString[i][j]!=0)
                    result=result+String.valueOf(zString[i][j]);
        }
        return result;
    }
}
