public class KadaneAlgo {
    public static void main(String[] args) {
        int[] nums = {2, -3, -7, -2, -10, -4};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int left = 0;
        int maxSum = Integer.MIN_VALUE;

        while (left < nums.length) {
            sum += nums[left];
            maxSum = Math.max(maxSum, sum);

            if(sum < 0) {
                sum = 0;
            }
            left++;

        }
        return maxSum;
    }
}