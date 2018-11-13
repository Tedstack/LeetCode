package Solution;

import java.util.Arrays;
/*3sum closest*/
public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0, result = nums[0] + nums[1] + nums[2];
        for (int i = 0, length = nums.length; i <= length - 2; i++) {
            int start = i + 1, end = length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                int tempDiff = Math.abs(sum - target);
                if (tempDiff == 0)
                    return sum;
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (diff > tempDiff) {
                    diff = tempDiff;
                    result = sum;
                }
            }
        }
        return result;
    }
}
