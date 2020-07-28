package DP;

public class stockTranscation {
    //only one transaction
    public int  maxProfit(int[] prices) {
        if(prices.length==0 || prices.length==1)
            return 0;
        int minPrice=prices[0],profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=minPrice)
                profit=Math.max(profit,prices[i]-minPrice);
            else
                minPrice=prices[i];
        }
        return profit;
    }
    //any transaction you may want to make
    public int maxProfitTwo(int[] prices) {
        if(prices.length==0 || prices.length==1)
            return 0;
        int buy=prices[0],profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=buy){
                profit+=prices[i]-buy;
                buy=prices[i];
            }
            else
                buy=prices[i];
        }
        return profit;
    }

    public int maxProfitTwoTrans(int[] prices){
        if(prices.length==0 || prices.length==1)
            return 0;
        int[] leftMax=new int[prices.length];
        int[] rightMax=new int[prices.length];
        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
                leftMax[i]=leftMax[i-1];
            } else{
                leftMax[i]=Math.max(leftMax[i-1],prices[i]-minPrice);
            }
        }
        int maxPrice=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>maxPrice){
                maxPrice=prices[i];
                rightMax[i]=rightMax[i+1];
            }else{
                rightMax[i]=Math.max(rightMax[i+1],maxPrice-prices[i]);
            }
        }
        int res=rightMax[0];
        for(int i=1;i<prices.length-2;i++){
            res = Math.max(res,leftMax[i]+rightMax[i+1]);
        }
        return res;
    }

    public int maxProfitCoolDown(int[] prices) {
        if(prices.length==0 || prices.length==1)
            return 0;
        int length=prices.length;
        int[] cooldown=new int[length];
        int[] sell=new int[length];
        int[] buy=new int[length];
        cooldown[0]=0;
        sell[0]=0;
        buy[0]=-prices[0];
        for(int i=1;i<length;i++){
            cooldown[i]=sell[i-1];
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],cooldown[i-1]-prices[i]);
        }
        return Math.max(cooldown[length-1],sell[length-1]);
    }
    public int maxProfitFee(int[] prices,int fee) {
        if(prices.length==0 || prices.length==1)
            return 0;
        int length=prices.length;
        int[] sell=new int[length];
        int[] buy=new int[length];
        sell[0]=0;
        buy[0]=-prices[0]-fee;
        for(int i=1;i<length;i++){
            sell[i]=Math.max(sell[i-1],buy[i - 1] + prices[i]);
            buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i]-fee);
        }
        return sell[length-1];
    }
}
