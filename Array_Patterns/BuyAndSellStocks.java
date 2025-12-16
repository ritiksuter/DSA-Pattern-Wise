public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] nums = { 7,1,5,3,6,4 };
        int ans = maxProfit(nums);
        System.out.println(ans);
    }

    public static int maxProfit(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                max = Math.max(diff, max);
            }
        }
        return max;
    }

    public static int maxProfitWithLessTC(int[] nums) {
        int max = 0;
        int mini = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - mini;
            max = Math.max(max, diff);
            mini = Math.max(mini, nums[i]);
        }
        return max;
    }
}