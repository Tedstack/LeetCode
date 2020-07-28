package Greedy;

public class Gas {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            if(gas[i]<cost[i])
                continue;
            else if(move(gas,cost,i))
                return i;
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n=gas.length;
        int minCity=-1;
        int totalGas=0;
        int minGas=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            totalGas-=cost[i];
            if(totalGas<minGas){
                minGas=totalGas;
                minCity=(i+1)%n;
            }
        }
        return totalGas>=0?minCity:-1;
    }

    public boolean move(int[] gas, int[] cost, int i){
        Boolean couldMove=true;
        int index=i;
        int totalGas=gas[index];
        while(couldMove){
            totalGas-=cost[index];
            if(totalGas<0)
                couldMove=false;
            else{
                index++;
                if(index==gas.length)
                    index=0;
                if(index==i)
                    return true;
                totalGas+=gas[index];
            }
        }
        return false;
    }
}
