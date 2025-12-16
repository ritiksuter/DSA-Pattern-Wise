public class SlidingWindowPattern {
    public static void main(String[] args) {
        int[] arr = {4, 6, 3, -1, 15, -7};
        int k = 3;
        int ans = maxSubarraySum(arr, k);
        System.out.println(ans);
    }

    public static int maxSubarraySum(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
